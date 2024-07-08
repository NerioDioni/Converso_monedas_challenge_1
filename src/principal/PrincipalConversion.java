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
        Scanner lectura = new Scanner(System.in);


        while(opcion != 9) {

            try{
                monedaService.mostrarMenu();
                opcion = lectura.nextInt();
            }catch (InputMismatchException e) {
                System.out.println("Ocurrió un error:se esperaba un numero de tipo entero ");
                System.out.println(e.getMessage());
              // opcion = 25;
                //break;

            }


            //opcion = lectura.nextInt();
            switch (opcion){
                case 1:
                    parAconvetir="EUR/USD/";
                    monedaService.convetirMoneda(parAconvetir);
                    System.out.println("---valor de opcion:"+opcion);

                    break;

                case 2:
                    parAconvetir="EUR/USD/";
                    monedaService.convetirMoneda(parAconvetir);
                    break;

                case 3:
                    parAconvetir="EUR/USD/";
                    monedaService.convetirMoneda(parAconvetir);
                    break;

                case 4:
                    parAconvetir="EUR/USD/";
                    monedaService.convetirMoneda(parAconvetir);
                    break;
                case 5:
                    parAconvetir="EUR/USD/";
                    monedaService.convetirMoneda(parAconvetir);
                    break;
                case 6:
                    parAconvetir="EUR/USD/";
                    monedaService.convetirMoneda(parAconvetir);
                    break;

                case 9:
                    System.out.println("Finalizando el programa. Muchas gracias por usar nuestros servicios");
                    break;
                default:
                    System.out.println("Opción inválida");
                    System.out.println("---valor de opcion:"+opcion);

                    break;
           }

        }

    }


}
