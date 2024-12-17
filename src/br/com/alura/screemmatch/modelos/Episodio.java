package br.com.alura.screemmatch.modelos;

import br.com.alura.screemmatch.calculos.Classificavel;

public class Episodio implements Classificavel {
    private int numero; //n° do episódio
    private String nome; //nome do episódio
    private Serie serie; //série a qual pertence o episódio

    public int getTotalVisualizacoes() {
        return totalVisualizacoes;
    }

    public void setTotalVisualizacoes(int totalVisualizacoes) {
        this.totalVisualizacoes = totalVisualizacoes;
    }

    private int totalVisualizacoes; //número de visualizações para ser usado no metodo getClassificação

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    //o método é implementado de Classificavel, porém diferente do que está se usando em Filme.
    @Override
    public int getClassificacao() {
        //se o episódio tiver mais que 100 views retorna 4, senão retorna 2
        if(totalVisualizacoes > 100){
            return 4;
        } else {
        return 2;
        }
    }
}
