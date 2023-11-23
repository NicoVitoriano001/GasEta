package com.example.appgaseta.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.appgaseta.model.Combustivel;

import java.util.ArrayList;
import java.util.List;

public class GasEtaDB extends SQLiteOpenHelper {
    public static final String DB_NAME = "gaseta.db";
    public static final int DB_VERSION = 1;
   // int DB_VERSION = 1;
  Cursor cursor; //se ficar vermelho, CTRL+SPACE
    SQLiteDatabase db;

    public GasEtaDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlTabelaCombustivel
                = "CREATE TABLE Combustivel (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nomeDoCombustivel TEXT, " +
                "precoDoCombustivel REAL, " +
                "recomendacao TEXT)";

        db.execSQL(sqlTabelaCombustivel);

        String sqlTabelaVeiculo
                = "CREATE TABLE Veiculo (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nomeDoVeiculo TEXT, " +
                "placaDoVeiculo TEXT)" ;

        db.execSQL(sqlTabelaVeiculo);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { }

    public void salvarObjeto(String tabela, ContentValues dados){
        db.insert(tabela, null, dados);

    }


public List<Combustivel> listarDados() {

    List<Combustivel> lista = new ArrayList<>();

    Combustivel registro;

    String querySQL = "SELECT * FROM Combustivel";

    cursor = db.rawQuery(querySQL, null);

    if (cursor.moveToFirst()) {

        do {
            registro = new Combustivel();
            registro.setId(cursor.getInt(0));
            registro.setNomeDoCombustivel(cursor.getString(1));
            registro.setPrecoDoCombustivel(cursor.getDouble(2));
            registro.setRecomendacao(cursor.getString(3));

            lista.add(registro);

        }while(cursor.moveToNext());

    } else { }
    return lista;


}

public void alterarObjeto(String tabela, ContentValues dados){

        //pegar o ID do registro a ser alterado
    // update TABLE set campo=novoDado WHERE id=?
    int id = dados.getAsInteger("id");

    db.update(tabela, dados, "id=?",
            new String[]{Integer.toString(id)});

}


    public void deletarObjeto(String tabela, int id){
        //pegar o ID do registro a ser alterado
        // delete from TABLE WHERE id=?
        db.delete(tabela, "id=?",
                new String[]{Integer.toString(id)});

    }


}




