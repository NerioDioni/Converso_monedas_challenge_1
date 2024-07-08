package service;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelo.MonedaDto;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MonedaService {
    private String direccionApi="https://v6.exchangerate-api.com/v6/2450d6d9980a2509de81c0e7/pair/";
    private Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();
    private float montoAConvertir= -1;
    private String direccionCompletaApi;

    public void mostrarMenu(){
        String menu = """
                *********************************************
                ** Escriba el número de la opción deseada **
                1 - Covetir dolares a peso argentino
                2 - Covetir peso argentino a dolares
                3 - Covetir colon salvadorenio a dolares
                4 - Covetir dolares a colon salvadorenio 
                5 - Covetir 
                6 - Covetir 
                7 - Covetir                 
                9 - Salir
                **********************************************
                """;
        System.out.println(menu);

    }
    public void convetirMoneda( String parAConvertir) throws IOException, InterruptedException {
        //datoAConvetirMoneda();
        System.out.println("--ingrese valor a convertir--");
        Scanner lectura = new Scanner(System.in);
        try {
            montoAConvertir=lectura.nextFloat();

        }catch(InputMismatchException e) {
            System.out.println("Error en sevice: ingrese valor adeacuado, se esperaba un numero.");
            System.out.println(e);
            System.out.println("---valor de montoaConvetir en error de sevice"+montoAConvertir);
            montoAConvertir=-1;
            System.out.println("---valor de montoaConvetir en error de sevice luego de modificar"+montoAConvertir);

        }
        if (montoAConvertir>=0.0) {
            direccionCompletaApi = direccionApi + parAConvertir + montoAConvertir;
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(direccionCompletaApi))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();

                System.out.println("--response:"+response);
                System.out.println("--json:"+json);
                System.out.println("--direcion completa pasada a Api"+direccionCompletaApi);
                System.out.println("--valor en formato float:"+montoAConvertir+",--valor convetido a string:"+Float.toString(montoAConvertir));
                MonedaDto miMonedaDto = gson.fromJson(json, MonedaDto.class);
                System.out.println("tipo DTO:");
                System.out.println(miMonedaDto);


            /*Titulo miTitulo = new Titulo(miTituloOmdb);
            System.out.println("Titulo ya convertido: " + miTitulo);
            titulos.add(miTitulo);*/


            } catch (NumberFormatException e) {
                System.out.println("Ocurrió un error:en formato ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Error en la URI, verifique la dirección.");
            }
        }else {System.out.println("valor a convertir debe se positivo");}



    }
    public void datoAConvetirMoneda(){

    }
}
