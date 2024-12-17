package br.com.alura.screemmatch.principal.busca_api;

import br.com.alura.screemmatch.excecao.AnoInvalidoException;
import br.com.alura.screemmatch.modelos.Titulo;
import br.com.alura.screemmatch.modelos.TituloOmdb;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBuscaApi {

    /*--------------------Declaração de variáveis --------------*/

    private final CriacaoJsonGson criacaoJsonGson = new CriacaoJsonGson(); //variável criacaoJsonGson usada para pegar o método criaJson
    private final AcessaApiOmdb acessaApi = new AcessaApiOmdb(); //variável para acessar a api
    private final EscreveArquivo escreveArquivo = new EscreveArquivo(); //variável para acessar o método para escrever em arquivos

    /*--------------------Main que vai chamar o método executar --------------*/
    public static void main(String[] args) throws IOException, InterruptedException {
        //chama o método executar
        new PrincipalComBuscaApi().executar();
    }

    /*--------------------Método Executar --------------*/
    public void executar()throws IOException, InterruptedException{
        /*Solicitando ao usuário que busque um filme*/
        Scanner leitura = new Scanner(System.in);

        //busca declarada e iniciada
        String busca = "";

        //criação da lista de filmes para ser impressa no Json
        List<Titulo> listaTitulos = new ArrayList<>();

        // criação do objeto gson que recebe da classe CriacaoJson
        Gson gson = criacaoJsonGson.getGson();

        //enquanto busca != sair
        while (!busca.equalsIgnoreCase("sair")){
            //Pergunta ao usuário: qual filme pesquisar
            System.out.println("Digite o filme a ser pesquisado:");

            //busca recebe o que foi digitado
            busca = leitura.nextLine();

            //se busca for sair, pára o sistema
            if(busca.equalsIgnoreCase("sair")){
                break;
            }
            try{ //try -> tente fazer o procedimento abaixo

                // Realiza o acesso a API da classe AcessaApi no método acessoApi passando a busca
                HttpResponse<String> response = acessaApi.acessoApi(busca);

                //se o status da busca do filme for 200
                if(response.statusCode() == 200){
                    //criando título através da Recrod TituloOmdb
                    TituloOmdb meuTituloOmdb = gson.fromJson((String) response.body(), TituloOmdb.class);

                    //atribuindo TituoOmdb ao tipo Titulo
                    Titulo meuTitulo = new Titulo(meuTituloOmdb);

                    //imprimir meuTitulo
                    System.out.println("Título convertido de Omdb para classe título: \n" + meuTitulo);

                    //adicionando títulos na lista
                    listaTitulos.add(meuTitulo);

                } else{
                    //caso contrário da erro de requisição
                    System.out.println("Erro na requisição! Código de status:" + response.statusCode());
                }
            }
            /*----------- Exceptions ---------------*///
            catch (NumberFormatException e){
                System.out.println("Erro de formato numérico: " + e.getMessage());
            }
            catch (IllegalArgumentException e){
                System.out.println("Argumento inválido: " + e.getMessage());
            }
            catch (AnoInvalidoException e){
                System.out.println("Ano inválido: " + e.getMensagem());
            }
            catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
            }
        }

        //impressão da lista de títulos
        System.out.println(gson.toJson(listaTitulos));

        //acessa a classe para escrita de arquivos
        escreveArquivo.escreverArquivoTxt(listaTitulos,gson);

        //finalizar o programa
        System.out.println("Programa finalizado corretamente");
    }
}