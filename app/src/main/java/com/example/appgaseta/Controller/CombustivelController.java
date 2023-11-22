package com.example.appgaseta.Controller;

import android.content.SharedPreferences;

import com.example.appgaseta.model.Combustivel;
import com.example.appgaseta.view.GasEtaActivity;

public class CombustivelController {

    SharedPreferences preferences;

    SharedPreferences.Editor dadosPreferences;

    //psfs
    public static final String NOME_PREFERENCES = "pref_gaseta";

    public CombustivelController(GasEtaActivity activity){
        preferences =
                activity.getSharedPreferences(NOME_PREFERENCES,0);
        dadosPreferences = preferences.edit();

    }

    public void salvar(Combustivel combustivel){
        dadosPreferences.putString("combustivel", combustivel.getNomeDoCombustivel());
        dadosPreferences.putFloat("preçoDoCOmbustivel", (float) combustivel.getPrecoDoCombustivel());
        dadosPreferences.putString("recomendacao", combustivel.getRecomendacao());
        dadosPreferences.apply();
    }

    public void limpar(){
        dadosPreferences.clear();
        dadosPreferences.apply();
    }

}
