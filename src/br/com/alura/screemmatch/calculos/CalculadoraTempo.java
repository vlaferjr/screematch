package br.com.alura.screemmatch.calculos;

import br.com.alura.screemmatch.modelos.Filme;
import br.com.alura.screemmatch.modelos.Serie;
import br.com.alura.screemmatch.modelos.Titulo;

public class CalculadoraTempo {

    //acumula os tempos de séries armazenados
    private int tempoTotal;

    public int getTempoTotal() {
        return tempoTotal;
    }

    /*Método para incluir filme a ser somado o tempo total*/
   /* public void incluir(Filme filme){
        //acrescentando os tempos dos filmes
        tempoTotal = tempoTotal + filme.getDuracaoMinutos(); //ou tempoTotal += filme.getDuracaoMinutos()
    }

    public void incluir(Serie serie){
        //acrescentando os tempos dos filmes
        tempoTotal = tempoTotal + serie.getDuracaoMinutos(); //ou tempoTotal += filme.getDuracaoMinutos()
    }*/

    //ao passar um título, podemos passar como parâmetros Filmes e Séries
    public void incluir (Titulo titulo){
        tempoTotal += titulo.getDuracaoMinutos();
    }
}
