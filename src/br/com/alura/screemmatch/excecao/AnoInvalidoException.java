package br.com.alura.screemmatch.excecao;

public class AnoInvalidoException extends RuntimeException {

    private String mensagem;
    //construtor
    public AnoInvalidoException(String mensagem) {
        this.mensagem = mensagem;
    }
    //pegar a mensagem.
    public String getMensagem() {
        return this.mensagem;
    }
}
