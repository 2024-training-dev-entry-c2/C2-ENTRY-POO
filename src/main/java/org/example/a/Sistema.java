package org.example.a;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.Scanner;

public class Sistema {

    public static Scanner Keyboard = new Scanner(System.in);

    public static int convertirStringAInt(String str) {
        int numero = 0;
        int longitud = str.length();

        // Iterar sobre cada carácter del String
        for (int i = 0; i < longitud; i++) {
            // Obtener el valor numérico del carácter (por ejemplo, '1' -> 1)
            char c = str.charAt(i);
            int valor = c - '0';  // Resta el valor ASCII de '0' para obtener el número

            // Multiplicar el número actual por 10 (para mover los dígitos a la izquierda)
            // y sumar el valor actual
            numero = numero * 10 + valor;
        }

        return numero;
    }

    public static String ingresarTexto(String msg) {
        System.out.print(msg);
        return Keyboard.nextLine();
    }

    public static int ingresarNumero(String msg) {
        int numero = 0;
        System.out.print(msg);
        while (true) {
            if (Keyboard.hasNextInt()) {
                numero = Keyboard.nextInt();
                break;
            } else {
                System.out.println("Error: Debe ingresar un número válido. Intente nuevamente.");
                Keyboard.next();
            }
        }
        return numero;
    }

    public static boolean compararArrays(int[] array1, int[] array2) {
        // Verificar si ambos arreglos son nulos
        if (array1 == null || array2 == null) {
            return false; // Si alguno es nulo, no son iguales
        }

        // Verificar si tienen la misma longitud
        if (array1.length != array2.length) {
            return false; // Si no tienen la misma longitud, no son iguales
        }

        // Comparar los elementos de los dos arreglos
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false; // Si algún elemento es diferente, los arreglos no son iguales
            }
        }

        return true; // Si todos los elementos son iguales, los arreglos son iguales
    }

    public static void mostrarDatosAtributos(Object obj) {
        // Obtener la clase del objeto
        Class<?> clase = obj.getClass();

        // Obtener todos los campos (atributos) de la clase
        Field[] campos = clase.getDeclaredFields();

        // Mostrar el nombre y valor de cada atributo
        System.out.println("Datos de la clase: " + clase.getSimpleName());
        for (Field campo : campos) {
            campo.setAccessible(true); // Permite acceder a atributos privados
            try {
                // Mostrar el nombre del atributo y su valor
                System.out.println(campo.getName() + ": " + campo.get(obj));
            } catch (IllegalAccessException e) {
                System.out.println("No se pudo acceder al atributo " + campo.getName());
            }
        }
        System.out.println("------");
    }
}
