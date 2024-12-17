package com.example.hotel.inputHandler;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class InputValidator {
  private static final Scanner scanner = new Scanner(System.in);

  public static String readString(String prompt) {
    System.out.println(prompt);
    return scanner.nextLine();
  }

  public static int readInt(String prompt) {
    int input;
    while (true) {
      try {
        System.out.println(prompt);
        input = Integer.parseInt(scanner.nextLine());
        return input;
      } catch (NumberFormatException e) {
        System.out.println("Entrada inválida. Por favor ingrese un número entero.");
      }
    }
  }

  public static double readDouble(String prompt) {
    double input;
    while (true) {
      try {
        System.out.println(prompt);
        input = Double.parseDouble(scanner.nextLine());
        return input;
      } catch (NumberFormatException e) {
        System.out.println("Entrada inválida. Por favor ingrese un número decimal.");
      }
    }
  }

  public static LocalDate readLocalDate(String prompt) {
    LocalDate date;
    while (true) {
      try {
        System.out.println(prompt);
        date = LocalDate.parse(scanner.nextLine());
        return date;
      } catch (Exception e) {
        System.out.println("Fecha inválida. El formato debe ser: yyyy-MM-dd");
      }
    }
  }

  public static LocalTime readLocalTime(String prompt) {
    LocalTime time;
    while (true) {
      try {
        System.out.println(prompt);
        time = LocalTime.parse(scanner.nextLine());
        return time;
      } catch (Exception e) {
        System.out.println("Hora inválida. El formato debe ser: HH:mm");
      }
    }
  }

  public static void clearBuffer() {
    if (scanner.hasNextLine()) {
      scanner.nextLine();
    }
  }
}
