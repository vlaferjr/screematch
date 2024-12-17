package br.com.alura.screemmatch.modelos;
//TODA SÉRIE É UM TÍTULO
public class Serie extends Titulo{
    /* Os atributos e métodos da classe Série são apenas o que tem nas Séries e não tem em Filmes*/
    private int temporadas;
    private int episodiosPorTemporada;
    private boolean ativa;
    private int minutosPorEpisodio;

    //criação do construtor da Série
    public Serie(String nome, int anoLancamento) {
        super(nome, anoLancamento);
    }

    public int getTemporadas() {
        return temporadas;
    }
    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public int getEpisodiosPorTemporada() {
        return episodiosPorTemporada;
    }

    public void setEpisodiosPorTemporada(int episodiosPorTemporada) {
        this.episodiosPorTemporada = episodiosPorTemporada;
    }

    public boolean getAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public int getMinutosPorEpisodio() {
        return minutosPorEpisodio;
    }

    public void setMinutosPorEpisodio(int minutosPorEpisodio) {
        this.minutosPorEpisodio = minutosPorEpisodio;
    }

    //anotação que possibilita a sobrescrita de um método
    /*Entende que está sendo usado na classe mãe (classe Titulo) porém o método será reeescrito*/
    @Override
    public int getDuracaoMinutos() {
        //calcula a duração total em minutos de uma série
        return temporadas * (episodiosPorTemporada * minutosPorEpisodio);
    }

    //utilização do toString para que a lista de título seja impressa corretamente
    @Override
    public String toString() {
        return "\n Série: "+ this.getNome() + "| Ano de lançamento: " + this.getAnoLancamento() ;
    }
}
