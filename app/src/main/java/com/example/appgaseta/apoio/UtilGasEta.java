package com.example.appgaseta.apoio;

public class UtilGasEta {

    public void metodoEstatico(){
//para utilizar, vai no MainActivity
    }

    public static void metodoNaoEstatico(){}

    public static String mensagem(){
        return "Qualquer Mensagem";
    }

    public static String calcularMelhorOpcao(double gasolina, double etanol){

        // preco ideal = gasolina * 0.70 = 3,548

        double  precoIdeal = gasolina * 0.70;
        String mensagemDeRetorno;

        if (etanol<=precoIdeal){
            mensagemDeRetorno = "Abastecer com Etanol";
            }else{
            mensagemDeRetorno = "Abastecer com Gasolina";
        }
        return mensagemDeRetorno;
    }


}
