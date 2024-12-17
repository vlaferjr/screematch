package br.com.alura.screemmatch.principal.busca_api;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class AcessaApiOmdb {

    private static final String ENDERECO_API = "https://www.omdbapi.com/";
    private static final String API_KEY = "298de078"; //chave para acesso

    public HttpResponse<String> acessoApi(String busca) throws IOException, InterruptedException {

        //concatena o endereço completo passando o Endr API + a busca no padrão UTF8 + chave
        String enderecoCompleto = ENDERECO_API + "?t=" + URLEncoder.encode(busca, StandardCharsets.UTF_8) + "&apikey=" + API_KEY;

        //define a criação da URI com o endereço completo
        URI uri = URI.create(enderecoCompleto);

        //client é o cliente que vai fazer o pedido ao servidor
        HttpClient client = HttpClient.newHttpClient();

        //request - o que é e para onde vai a requisição
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .build(); //buider é um padrão de projeto para criar objetos complexos

        /*RESPOSTA DA REQUISIÇÃO*/
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
