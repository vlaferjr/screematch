package br.com.alura.screemmatch.principal.busca_api;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CriacaoJsonGson {
    private final Gson gson;

    /*Construtor*/
    public CriacaoJsonGson() {
        this.gson = new GsonBuilder()
                //ajustando a declaração do objeto para informar que o Json vem com letra maiúscula
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting() //imprimir o json em formato correto
                .create();
    }

    /*Getter*/
    public Gson getGson() {
        return gson;
    }
}
