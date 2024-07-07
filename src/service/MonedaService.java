package service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MonedaService {
    String direccionApi="https://v6.exchangerate-api.com/v6/2450d6d9980a2509de81c0e7/pair/";

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
    public void convetirMoneda( String direcionComplemento){
        String direccion=direccionApi+direcionComplemento;
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            System.out.println(json);
        }catch (NumberFormatException | IOException | InterruptedException e){
            System.out.println("Ocurrió un error: ");
            System.out.println(e.getMessage());
        }catch(IllegalArgumentException e) {
            System.out.println("Error en la URI, verifique la dirección.");
        }

    }
}
