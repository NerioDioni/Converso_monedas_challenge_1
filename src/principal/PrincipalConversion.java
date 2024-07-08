package principal;

import service.MonedaService;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PrincipalConversion {
    public static void main(String[] args) throws IOException, InterruptedException {
        int opcion = 0;
        String parAconvetir;
        MonedaService monedaService=new MonedaService();


        while(opcion != 9) {
            try{
                Scanner lectura = new Scanner(System.in);
                monedaService.mostrarMenu();
                opcion = lectura.nextInt();
            }catch (InputMismatchException e) {
                System.out.println("Ocurrió un error:se esperaba un numero de tipo entero ");
                System.out.println(e);
                opcion=-1;

            }
            switch (opcion){
                case 1:
                    parAconvetir="EUR/USD/";
                    monedaService.convetirMoneda(parAconvetir);
                    break;
                case 2:
                    parAconvetir="MXN/EUR/";
                    monedaService.convetirMoneda(parAconvetir);
                    break;
                case 3:
                    parAconvetir="PAB/MXN/";
                    monedaService.convetirMoneda(parAconvetir);
                    break;
                case 4:
                    parAconvetir="RUB/COP/";
                    monedaService.convetirMoneda(parAconvetir);
                    break;
                case 5:
                    parAconvetir="EUR/TRY/";
                    monedaService.convetirMoneda(parAconvetir);
                    break;
                case 6:
                    parAconvetir="NZD/KRW/";
                    monedaService.convetirMoneda(parAconvetir);
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
