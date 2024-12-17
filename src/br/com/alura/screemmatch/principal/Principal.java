package br.com.alura.screemmatch.principal;

import br.com.alura.screemmatch.calculos.CalculadoraTempo;
import br.com.alura.screemmatch.calculos.Recomendacao;
import br.com.alura.screemmatch.modelos.Episodio;
import br.com.alura.screemmatch.modelos.Filme;
import br.com.alura.screemmatch.modelos.Serie;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        //ciação de um novo objeto meuFilme do tipo br.com.alura.screemmatch.modelos.Filme
        /*através do construtor criado na classe Filmes, os parâmetros serão passados diretamente, ou seja,
        * os atributos estão sendo definidos agora dentro do construtor e não mais na classe br.com.alura.screemmatch.principal.Principal*/
        Filme meuFilme = new Filme("O poderoso chefão", 1970);// br.com.alura.screemmatch.modelos.Filme é um tipo por referência
        meuFilme.setDuracaoMinutos(180);

        //inserir as notas de avaliação do filme
        meuFilme.avalia(8);
        meuFilme.avalia(7);
        meuFilme.avalia(5);

        //impressão dos atributos do br.com.alura.screemmatch.modelos.Filme
        meuFilme.exibeFichaTecnica(); //chamada para o método que está na classe br.com.alura.screemmatch.modelos.Filme

        //impressão das avaliações
        System.out.println("\n\n******* AVALIAÇÕES *********");
        System.out.println("Total de avaliações:"+ meuFilme.getTotalAvaliacoes());

        //impressão da média das avaliações
        System.out.println("\n\n******* MÉDIA DAS AVALIAÇÕES *********");
        System.out.println("A média das avaliações foi:" + meuFilme.pegaMedia());

       //definição de atributos das séries
        //obs que os atributos e métodos passados não são de Série mas sim da Título, que Série herdou
        Serie laCasaDePapel = new Serie("La Casa de Papel", 2016);

        //os atributos abaixo são exclusivos da Classe Séries
        laCasaDePapel.setTemporadas(5);
        laCasaDePapel.setEpisodiosPorTemporada(12);
        laCasaDePapel.setMinutosPorEpisodio(50);
        laCasaDePapel.exibeFichaTecnica();

        // //definindo atributos do objeto meuFilme2
        Filme meuFilme2 = new Filme("Como eu era antes de você", 2015);
        meuFilme2.setDuracaoMinutos(150);

        /*Operações com a calculadora*/
        //instnacia do objeto
        CalculadoraTempo calculadora = new CalculadoraTempo();
        //inclussão de filmes
        calculadora.incluir(meuFilme); //tempo do filme 1
        calculadora.incluir(meuFilme2); //tempo do filme 2
        calculadora.incluir(laCasaDePapel);
        // mostra tempo total
        System.out.println("\n\n******* Tempo total de Filmes assistidis *********");
        System.out.println("O tempo total de Filmes que vc vai consumir é de: " + calculadora.getTempoTotal());

        //operações com o Classificável
        Recomendacao filtroRecomendacao = new Recomendacao();
        //filtrar o filme para saber se está entre os melhores
        filtroRecomendacao.filtra(meuFilme);


        //Instanciando objeto Episódio
        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(laCasaDePapel);
        episodio.setTotalVisualizacoes(300);
        //filtrando para saber se o episódio está entre os assistidos
        filtroRecomendacao.filtra(episodio);

        //instanciando um 3º filme para trabalhar com as listas
        var filme3 = new Filme("Divertidamente 2", 2024); //var faz uma inferência do tipo declarado
        filme3.setDuracaoMinutos(200);
        filme3.avalia(9);

        //declaração de uma Array List
        ArrayList<Filme> listaDeFilmes = new ArrayList<>();//objeto lista com filmes armazenados
        //adicionando filmes
        listaDeFilmes.add(filme3);
        listaDeFilmes.add(meuFilme2);
        listaDeFilmes.add(meuFilme);
        System.out.println("\n\n******* LISTA DE FILMES *********");
        //ver quantos elementos foram adicionados na lista
        System.out.println("Tamanho da lista de filmes: " + listaDeFilmes.size());
        //Pegar o nomme do 1º filme da lista = get(0) seria pegar o primeiro elemento da lista
        System.out.println("Primeiro filme adicionado na lista: " + listaDeFilmes.get(0).getNome());
        //imprimir o ToString do primeiro filme
        System.out.println("ToString do primeiro filme da lista: "+ listaDeFilmes.get(0).toString());

        //imprimir a lista toda
        System.out.println("Lista completa de filmes: \n" + listaDeFilmes);
    }
}
