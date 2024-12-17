package br.com.alura.screemmatch.principal.busca_api;

import br.com.alura.screemmatch.modelos.Titulo;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EscreveArquivo {

    public void escreverArquivoTxt(List<Titulo> listaTitulos, Gson gson) throws IOException {

        //criar objeto e criar o arquivo a ser escrito
        try (FileWriter escrita = new FileWriter("filmes.json")){

            //escrever a lista no formato Json no arquivo
            escrita.write(gson.toJson(listaTitulos));
        }
        System.out.println("Arquivo filmes.json criado com sucesso!");
    }
}
