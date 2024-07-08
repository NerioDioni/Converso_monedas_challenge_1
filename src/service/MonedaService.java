package service;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelo.Moneda;
import modelo.MonedaDto;
import java.io.IOException;
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
                1 - Covetir euros a dolares
                2 - Covetir peso mexicano a euros
                3 - Covetir balboa panamenio a peso mexicano
                4 - Covetir rublos rusos a peso colombiano 
                5 - Covetir euros a liras turcas
                6 - Covetir  dolares de nueva zelanda a won koreano              
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
            System.out.println("Ingrese valor adeacuado, se esperaba un numero.");
            montoAConvertir=-1;
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
                MonedaDto miMonedaDto = gson.fromJson(json, MonedaDto.class);
                Moneda miMoneda= new Moneda(miMonedaDto);
                System.out.println("--"+miMoneda+"--");

            } catch (NumberFormatException e) {
                System.out.println("Ocurrió un error:en formato ");
            } catch (IllegalArgumentException e) {
                System.out.println("Error en la URI, verifique la dirección.");
            }
        }else {System.out.println("valor a convertir debe se positivo");}
    }

}
