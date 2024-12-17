package br.com.alura.screemmatch.modelos;

import br.com.alura.screemmatch.excecao.AnoInvalidoException;
import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.NotNull;

public class Titulo implements Comparable<Titulo>{
    //atributos em comum para Filmes e Séries
    @SerializedName("Title") //mapeando para dizer que no Json vindo está como Title e não como nome.
    private String nome;
    @SerializedName("Year")
    private int anoLancamento;//mapeando para dizer que no Json vindo está como Year e não como anoLancamento.
    private boolean incluiPlano;
    //A classe principal não pode atribuir valor à soma das avaliações
    private double somaAvaliacoes;
    private int totalAvaliacoes;
    private int duracaoMinutos;

    //criação do construtor
    public Titulo(String nome, int anoLancamento) {
        this.nome = nome;
        this.anoLancamento = anoLancamento;
    }

    /*construtor de TituloOmdb para Titulo*/
    public Titulo(@NotNull TituloOmdb meuTituloOmdb) {
        this.nome = meuTituloOmdb.getTitle();
        //fazer a validação do ano se tiver mais de 4 caracteres
        if(meuTituloOmdb.getYear() == null || meuTituloOmdb.getYear().length() > 4){
            //lançar uma nova exceção
            throw new AnoInvalidoException("O ano deve possuir 4 caracteres numéricos");
        }
        //valueOf => Pega o ano que veio como String do Json e converte num inteiro
        this.duracaoMinutos = Integer.valueOf((meuTituloOmdb.getYear()));
        this.duracaoMinutos = Integer.valueOf(meuTituloOmdb.getRuntime().substring(0,3));
    }

    //criação de métodos

    //método que vai somar as  avaliações
    public  void avalia(double nota){
        somaAvaliacoes += nota; //avaliacao = avaliacao + nota;
        totalAvaliacoes ++; //ir contando o total de avaliações
    }

    //método para retornar a média das avaliações
    public double pegaMedia(){
        return somaAvaliacoes / totalAvaliacoes;
    }

    //método para devolver ao principal o total de avaliações
    public int getTotalAvaliacoes(){
        return totalAvaliacoes;
    }

    //método para permitir settar o nome na classe br.com.alura.screemmatch.principal.Principal
    //this significa que refere-se ao nome declarado na classe
    public void setNome(String nome) {
        this.nome = nome;
    }

    //método para permitir settar o anoLançamento na classe br.com.alura.screemmatch.principal.Principal
    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    //método para permitir settar o DuraçãoMinutos na classe br.com.alura.screemmatch.principal.Principal
    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    public void setIncluiPlano(boolean incluiPlano) {
        this.incluiPlano = incluiPlano;
    }

    //métodos Getters para a leitura dos atributos

    public String getNome() {
        return nome;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public boolean isIncluiPlano() {
        return incluiPlano;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    //método para imprimir a ficha técnica do filme
    public void exibeFichaTecnica(){
        System.out.println("\n\n******* FICHA TÉCNICA *********");
        System.out.println("Nome: " + nome);
        System.out.println("Lançado em: " + anoLancamento);
        System.out.println("Duração: "+ getDuracaoMinutos() + " minutos");
    }

    //implementação do método CompareTo da classe Comparable
    @Override
    public int compareTo(Titulo outroTitulo) {
        //retorno é a comparação do nome de um título com o nome de outro título
        return this.getNome().compareTo(outroTitulo.getNome());
    }
    //criação do método ToString
    @Override
    public String toString() {
        return "Nome do filme: '" + nome + '\'' +
                ", Ano de lançamento: " + anoLancamento +
                ", Tempo de duração: " + duracaoMinutos + " minutos \n";
    }
}
