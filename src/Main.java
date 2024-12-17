import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ReservationLogic reservationSystem = new ReservationLogic();

        while (true) {
            System.out.println("\n----------[Bienvenido a Booking Hotel!]---------- \n");
            System.out.println("Que deseas realizar:");
            System.out.println("1. Mostrar Reservas");
            System.out.println("2. Realizar reserva");
            System.out.println("3. Salir");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    reservationSystem.displayReservations();
                    break;
                case 2:
                    reservationSystem.makeReservation(scanner);
                    break;
                case 3:
                    System.out.println("Has salido del aplicativo");
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

}
