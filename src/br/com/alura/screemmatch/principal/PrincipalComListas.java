package br.com.alura.screemmatch.principal;

import br.com.alura.screemmatch.modelos.Filme;
import br.com.alura.screemmatch.modelos.Serie;
import br.com.alura.screemmatch.modelos.Titulo;

import java.io.File;
import java.util.*;

public class PrincipalComListas {
    public static void main(String[] args) {
        //criação dos 3 objetos filme
        Filme meuFilme = new Filme("O poderoso chefão", 1970);
        Filme meuFilme2 = new Filme("Como eu era antes de você", 2015);
        var filme3 = new Filme("Divertidamente 2", 2024);

        //criação da série
        Serie serie1 = new Serie("La Casa de Papel", 2016);

        //Avaliações dos filmes
        meuFilme.avalia(8);
        meuFilme2.avalia(6.5);
        filme3.avalia(8.5);

        /*variáveis de referência*/
        Filme f1 = filme3; //f1 e filme 3 são a mesma coisa


        //Crição da lista título (vale para Filmes e séries)
        /*Observar que título aceita tanto filmes quanto séries*/
        //ArrayList<Titulo>lista = new ArrayList<>();
        List<Titulo> lista = new LinkedList<>(); //Array List tb pode ser escrito como List
        //adicionando os filmes à lista
        lista.add(meuFilme);
        lista.add(meuFilme2);
        lista.add(filme3);

        //adicionando a série à lista
        lista.add(serie1);

        //percorrendo a lista de título com foreach
        for(Titulo item: lista){ // para cada item da lista do tipo título
            System.out.println(item.getNome()); //imprimir os 4 itens da lista
            //Se o item for um filme e sua classificação for maior que 2 então mostra
            if(item instanceof Filme filme && filme.getClassificacao()>2){
                System.out.println("Classificação: " + filme.getClassificacao());
            }
            /*passar a classificação - referenciando da Classe Filme*/
            //Filme filme = (Filme) item; //fazer um cast referenciando que um item é um filme
        }

        /*Ordenação dos títulos de Filmes e Séries - Por nome do título*/
        Collections.sort(lista);
        System.out.println("\n\n ------- ORDENAÇÃO DA LISTA DE TÍTULOS - DEPOIS DO COMPARETO NA CLASSE TÍTULO ------------ \n" +
                lista );

        /*Ordenação dos títulos e filmes por Ano de lançamento*/
        //uso do comparator comparando todo o título recebido pelo ano de lançamento de cada título
        lista.sort(Comparator.comparing(Titulo::getAnoLancamento));
        System.out.println("\n\n---------ORDENAÇÃO DA LISTA DE TÍTULOS (POR ANO)- DEPOIS DO COMPARATOR \n" +
                lista);

        /******************* ORDENAÇÃO DE LISTAS - ARTISTA ************************/
        //busca por artista

        //criação de uma nova lista
        ArrayList <String> buscaPorArtista = new ArrayList<>();

        //Adicionando elementos às listas
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("Robert De Niro");
        buscaPorArtista.add("George Clooney");
        buscaPorArtista.add("All Pacino");
        buscaPorArtista.add("Eddye Murph");

        //impressão de lista sem ordenação
        System.out.println("\n\n----- IMPRESSÃO DA LISTA DE ATORES SEM ORDENAÇÃO ------ \n" +
                buscaPorArtista);

        //uso do collections.sort para ordenação de lista
        Collections.sort(buscaPorArtista);
        System.out.println("\n\n ------ IMPRESSÃO DA LISTA DE ATORES - USANDO COLLECTIONS.SORT --------- \n" +
                buscaPorArtista);

    }

}
