package br.com.alura.screemmatch.calculos;

public class Recomendacao {

    //método que vai filtrar para assistir agora (4 estrelas) ou depois (2 estrelas)
    public void filtra(Classificavel classificavel){//filtra recebe um classificavel
        //se a classificação (classe Classificavel) >= 4
        if(classificavel.getClassificacao() >= 4){
            System.out.println("Está entre os mais assistidos");
            //se a classificação >= 2
        } else if (classificavel.getClassificacao()>=2){
            System.out.println("Nem bom, nem ruim em avaliações");
        } else {
            System.out.println("Está entre os piores");
        }
    }
}
