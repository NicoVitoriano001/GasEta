package com.example.appgaseta.model;

public class Pessoa {



    // criar objeto precisa de construtor  // Aqui é construtor  //Atributos > objetos > modelo > template
    private String primeiroNome; //atributo ao método
    private String sobreNome; //atributo ao método
    private String cursoDesejado; //atributo ao método
    private String telefoneContato; //atributo ao método



    //construtor público, criou a classe pessoa
    public Pessoa(){}

    //Métodos de acesso  - Getts and Setts //botao direito, generate, getts and setts, selecionar tudo
    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome)
    {
        this.primeiroNome = primeiroNome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getCursoDesejado() {
        return cursoDesejado;
    }

    public void setCursoDesejado(String cursoDesejado) {
        this.cursoDesejado = cursoDesejado;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }

    // To String - Para texto ou strings de caracteres
    //@tost  > (generate via wizard, selecionar todos os atributos da classe)
    @Override
    public String toString() {
        return "Pessoa{" +
                "primeiroNome='" + primeiroNome + '\'' +
                ", sobreNome='" + sobreNome + '\'' +
                ", cursoDesejado='" + cursoDesejado + '\'' +
                ", telefoneContato='" + telefoneContato + '\'' +
                '}';
    }
}
