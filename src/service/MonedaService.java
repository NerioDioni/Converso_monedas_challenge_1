package service;

public class MonedaService {

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
}
