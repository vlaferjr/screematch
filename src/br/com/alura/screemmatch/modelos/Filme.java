package br.com.alura.screemmatch.modelos;

import br.com.alura.screemmatch.calculos.Classificavel;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

//classe filme herda os atributos de título
//TODO FILME É UM TÍTULO
//Título está usando métodos da Interface Classificável
public class Filme extends Titulo implements Classificavel {
    /* Os atributos e métodos da classe Filmes são apenas o que tem nos filmes e não tem em séries*/
    private String diretor;

    //construtor para o objeto Filme
    public Filme(String nome, int anoLancamento) {
        super(nome, anoLancamento); //setar um nome que está chegando na String
    }

    public String getDiretor() {
        return diretor;
    }
    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    //método que está implementado na interface Classificavel
    @Override //indica que está sendo sobrescrito de outra classe / interface
    public int getClassificacao() {
        //função pegaMedia (classe título) / 2
        return (int)pegaMedia()/2;
    }

    //método ToString que vai imprimir o filme de maneira personalizada
    @Override //sobrescrevendo o método ToString
    public String toString() {
        return "\n Filme: " + this.getNome() + " | Ano de lançamento: " + this.getAnoLancamento() ;
    }
}
