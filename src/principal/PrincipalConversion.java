package principal;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import service.MonedaService;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalConversion {
    public static void main(String[] args) throws IOException, InterruptedException{
        MonedaService monedaService=new MonedaService();
        Scanner lectura = new Scanner(System.in);
        int opcion = 0;

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        String dirApi="https://v6.exchangerate-api.com/v6/2450d6d9980a2509de81c0e7/pair/";
        String paresAconvetir;
        float montoAConvertir= 0.0f;
        String direccion="";

        while(opcion != 9) {
            monedaService.mostrarMenu();
            opcion = lectura.nextInt();

            switch (opcion){
                case 1:
                    paresAconvetir="EUR/USD/";
                    montoAConvertir=2f;
                    direccion =dirApi+paresAconvetir+montoAConvertir;

                    try {
                        HttpClient client = HttpClient.newHttpClient();
                        HttpRequest request = HttpRequest.newBuilder()
                                .uri(URI.create(direccion))
                                .build();
                        HttpResponse<String> response = client
                                .send(request, HttpResponse.BodyHandlers.ofString());

                        String json = response.body();
                        System.out.println(json);
                    }catch (NumberFormatException e){
                        System.out.println("Ocurrió un error: ");
                        System.out.println(e.getMessage());
                    }catch(IllegalArgumentException e) {
                        System.out.println("Error en la URI, verifique la dirección.");
                    }

                    break;
                case 2:
                    paresAconvetir="EUR/USD/";
                    montoAConvertir=1f;
                    direccion =dirApi+paresAconvetir+montoAConvertir;

                    try {
                        HttpClient client = HttpClient.newHttpClient();
                        HttpRequest request = HttpRequest.newBuilder()
                                .uri(URI.create(direccion))
                                .build();
                        HttpResponse<String> response = client
                                .send(request, HttpResponse.BodyHandlers.ofString());

                        String json = response.body();
                        System.out.println(json);
                    }catch (NumberFormatException e){
                        System.out.println("Ocurrió un error: ");
                        System.out.println(e.getMessage());
                    }catch(IllegalArgumentException e) {
                        System.out.println("Error en la URI, verifique la dirección.");
                    }

                    break;
                case 3:
                    paresAconvetir="EUR/USD/";
                    montoAConvertir=1f;
                    direccion =dirApi+paresAconvetir+montoAConvertir;

                    try {
                        HttpClient client = HttpClient.newHttpClient();
                        HttpRequest request = HttpRequest.newBuilder()
                                .uri(URI.create(direccion))
                                .build();
                        HttpResponse<String> response = client
                                .send(request, HttpResponse.BodyHandlers.ofString());

                        String json = response.body();
                        System.out.println(json);
                    }catch (NumberFormatException e){
                        System.out.println("Ocurrió un error: ");
                        System.out.println(e.getMessage());
                    }catch(IllegalArgumentException e) {
                        System.out.println("Error en la URI, verifique la dirección.");
                    }

                        break;
                case 9:
                    System.out.println("Finalizando el programa. Muchas gracias por usar nuestros servicios");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
           }
       }
    }


}
