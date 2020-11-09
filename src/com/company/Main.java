package com.company;

import clases.CapacidadEndedudamiento;

import java.util.Scanner;

import static com.company.constantes.Constantes.*;

public class Main {
    //Recuerda que aca empieza todo

    //Con este objeto de la clase Scanner puedes capturar informacion por consola cada ves que lo uses
    // recuerda cerrar el flujo de consulta cada ves lo uses sobre para que los uses in.close()
    public static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        CapacidadEndedudamiento capacidadEndedudamiento = new CapacidadEndedudamiento();
        String confirmacion;
        boolean entrada = true;
        boolean control;

        do {
            control = true;
            System.out.println(MSJ_BIENVENIDO);
            capacidadEndedudamiento.setIngresosTotales(Integer.parseInt(validar(MSJ_INGRESOS_TOTALES)));
            capacidadEndedudamiento.setGastosFijos(Integer.parseInt(validar(MSJ_GASTOS_FIJOS)));
            capacidadEndedudamiento.setGastoVaribales(Integer.parseInt(validar(MSJ_GASTOS_VARIABLES)));

            while (control) {
                System.out.println(MSJ_CONFIRMACION_DATOS + capacidadEndedudamiento.getIngresosTotales() +
                        ", " + capacidadEndedudamiento.getGastosFijos() + ", " +
                        capacidadEndedudamiento.getGastoVaribales() +
                        "\nSI/NO");
                
                confirmacion = in.nextLine().toUpperCase();
                switch (confirmacion) {
                    case "SI":
                        entrada = false;
                        control = false;
                        break;
                    case "NO":
                        System.out.println(SEPARADOR);
                        control = false;
                        break;
                    default:
                        System.out.println(MSJ_CONFIRMACION_DATOS_NO_VALIDA);
                }
            }
        } while (entrada);

        System.out.println(MSJ_CAPACIDAD_DE_ENDEUDAMIENTO + capacidadEndedudamiento.getCapacidadEndeudamiento() +
                "\n" + MSJ_INFORMATIVO_VALORES_REGISTRADOS + capacidadEndedudamiento.toString());
        in.close();
    }

    private static boolean isNumeric(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    private static String validar(String mensaje) {
        String value = "";
        boolean esNumerico = false;
        while (!esNumerico) {
            System.out.println(mensaje);
            value = in.nextLine();
            esNumerico = isNumeric(value);
            if (!esNumerico) {
                System.out.println(MSJ_VALIDAR_VALORES);
            }
        }
        return value;
    }
}
