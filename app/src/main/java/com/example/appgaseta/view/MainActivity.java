package com.example.appgaseta.view;

//import são as classes necessárias

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.appgaseta.Controller.CursoController;
import com.example.appgaseta.Controller.PessoaController;
import com.example.appgaseta.R;
import com.example.appgaseta.model.Pessoa;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    //outro objeto. tem que instanciar esse objeto, na MainActivty
    //Classe-Pessoa objeto-pessoa

    PessoaController controller;
    CursoController cursoController;
    Pessoa pessoa;
    List<String> nomesDosCuros;
    Pessoa outrapessoa;
    String dadosPessoa;
    String dadosOutraPessoa;
    EditText edit_primeiroNome;
    EditText edit_SobrenomeAluno;
    EditText editNomeCurso;
    EditText editTelefoneContato;
    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
//criou os objetos (estanciou os objetos)
        //atribuir dados, valores ao objetos, conforme Pessoa (generate > getts and setts)
      /*pessoa.setPrimeiroNome("Nico");
        pessoa.setSobreNome("Vitor");
        pessoa.setCursoDesejado("Android");
        pessoa.setTelefoneContato("85-11002020203");*/

        controller = new PessoaController(MainActivity.this);
        controller.toString();

        pessoa = new Pessoa();
        controller.buscar(pessoa);

        edit_primeiroNome = findViewById(R.id.edit_primeiroNome);
        edit_SobrenomeAluno = findViewById(R.id.edit_SobrenomeAluno);
        editNomeCurso = findViewById(R.id.editNomeCurso);
        editTelefoneContato = findViewById(R.id.editTelefoneContato);

        edit_primeiroNome.setText(pessoa.getPrimeiroNome());
        edit_SobrenomeAluno.setText(pessoa.getSobreNome());
        editNomeCurso.setText(pessoa.getCursoDesejado());
        editTelefoneContato.setText(pessoa.getTelefoneContato());

        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        //Adapter        //Layout        //Injetar o Adapter ao Spinner > Lista será gerada com nome dos cursos
        cursoController = new CursoController();
        nomesDosCuros = cursoController.dadosParaSpinner();
        spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                cursoController.dadosParaSpinner());

        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);

        spinner.setAdapter(adapter);
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit_primeiroNome.setText("");
                edit_SobrenomeAluno.setText("");
                editNomeCurso.setText("");
                editTelefoneContato.setText("");

                controller.limpar();

            }
        });
        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Volte sempre", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pessoa.setPrimeiroNome(edit_primeiroNome.getText().toString());
                pessoa.setSobreNome(edit_SobrenomeAluno.getText().toString());
                pessoa.setCursoDesejado(editNomeCurso.getText().toString());
                pessoa.setTelefoneContato(editTelefoneContato.getText().toString());

                Toast.makeText(MainActivity.this, "Salvo " + pessoa.toString(), Toast.LENGTH_LONG).show();
                //1 parte - criação do método inverso. Criou aqui controller.salvar();, para poder ser preenchido automático na Class PessoaController
                //2 parte -  ao criar o métido salvar na Class PessoaController, ele está fazio, colocar  controller.salvar(pessoa); e permitir Add

                controller.salvar(pessoa);

                //Toast.makeText(MainActivity.this, "Salvo " + pessoa.toString(), Toast.LENGTH_LONG).show();

            }
        });

        /*dadosPessoa = "Primeiro nome: ";
        dadosPessoa += pessoa.getPrimeiroNome();
        dadosPessoa += " Sobrenome: ";
        dadosPessoa += pessoa.getSobreNome();
        dadosPessoa += " Curso Desejado: ";
        dadosPessoa += pessoa.getCursoDesejado();
        dadosPessoa += " Telefone de Contato: ";
        dadosPessoa += pessoa.getTelefoneContato();

        dadosOutraPessoa = "Primeiro nome: ";
        dadosOutraPessoa += outrapessoa.getPrimeiroNome();
        dadosOutraPessoa += " Sobrenome: ";
        dadosOutraPessoa += outrapessoa.getSobreNome();
        dadosOutraPessoa += " Curso Desejado: ";
        dadosOutraPessoa += outrapessoa.getCursoDesejado();
        dadosOutraPessoa += " Telefone de Contato: ";
        dadosOutraPessoa += outrapessoa.getTelefoneContato();*/

//visualizar pelo tostring
        Log.i("POOAndroid", pessoa.toString());
    //    Log.i("POOAndroid", outrapessoa.toString());

    }
}