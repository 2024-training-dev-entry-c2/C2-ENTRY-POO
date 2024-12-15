package com.bookstay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    // Global variables
    static List<List<String>> lodgings = new ArrayList<>();

    public static void main(String[] args) {

    }

    /* ############################### INITIALIZE DATA ############################### */
    public static void initializeData() {
        // Lodging structure: [Name, City, Category, Rating, Price, Description, MaxPeople, Rooms, Activities, Meals, ReservationData]
        // Room structure: " Name | Description | Price | MaxAdults | MaxChildren | Quantily "

        // Hotels
        addLodging("Hotel Mar Azul", "Cartagena", "Hotel", "4.9", "",
                "Hotel frente al mar con excelentes comodidades", "",
                "Habitación Estándar|La habitación estándar cuenta con 1 cama queen, aire acondicionado, minibar, baño privado y TV de pantalla plana.|200000|2|1|10;" +
                        "Habitación Deluxe|La habitación deluxe tiene cama king, balcón con vista al mar, cafetera, y servicio de habitaciones las 24 horas.|400000|2|2|5;" +
                        "Suite|La suite incluye una sala de estar separada, jacuzzi, minibar surtido, y vistas panorámicas al océano.|800000|2|2|3",
                "", "", "");

        addLodging("Hotel Los Andes", "Bogotá", "Hotel", "4.6", "",
                "Hotel moderno con vistas a la ciudad", "",
                "Habitación Estándar|Una opción económica y cómoda con una cama queen, baño privado y TV por cable.|200000|2|1|10;" +
                        "Habitación Deluxe|Amplia habitación con cama king, vistas a la ciudad y minibar incluido.|400000|2|2|5;" +
                        "Suite|La suite cuenta con una sala de estar privada, jacuzzi, y escritorio para trabajo.|800000|2|2|3",
                "", "", "");

        addLodging("Hotel Bahia Blanca", "Santa Marta", "Hotel", "4.7", "",
                "Hotel cerca de la playa con piscina y spa", "",
                "Habitación Estándar|Habitación con cama king, TV por cable, aire acondicionado y baño privado.|250000|2|1|12;" +
                        "Habitación Deluxe|Habitación con vistas al mar, minibar y jacuzzi privado.|500000|2|2|6;" +
                        "Suite Presidencial|Suite amplia con sala de estar, jacuzzi, y vistas al océano.|1000000|2|2|2",
                "", "", "");

        addLodging("Hotel Mirador del Valle", "Medellín", "Hotel", "4.8", "",
                "Hotel con una vista espectacular de la ciudad", "",
                "Habitación Estándar|Habitación con cama queen, escritorio y baño privado.|220000|2|1|8;" +
                        "Habitación Deluxe|Habitación con vistas a las montañas, minibar y cafetera.|400000|2|2|4;" +
                        "Suite|Suite con salón independiente, jacuzzi y minibar.|850000|2|2|3",
                "", "", "");

        addLodging("Hotel Costa Dorada", "Cartagena", "Hotel", "4.5", "",
                "Hotel frente a la playa con restaurante y gimnasio", "",
                "Habitación Estándar|Habitación con cama queen, aire acondicionado, TV por cable y baño privado.|200000|2|1|10;" +
                        "Habitación Deluxe|Habitación con vistas al mar, minibar y escritorio.|400000|2|2|6;" +
                        "Suite Familiar|Suite con 2 habitaciones, sala de estar y vista al océano.|600000|4|2|4",
                "", "", "");

        // Apartaments
        addLodging("Apartamento Playa", "Cartagena", "Apartamento", "4.7", "500000",
                "Apartamento moderno con vista al océano", "6", "", "", "", "");

        addLodging("Apartamento Mirador", "Bogotá", "Apartamento", "4.6", "350000",
                "Apartamento con vistas panorámicas de la ciudad", "4", "", "", "", "");

        addLodging("Apartamento Acapulco", "Cartagena", "Apartamento", "4.8", "600000",
                "Apartamento con vista al mar y piscina privada", "5", "", "", "", "");

        addLodging("Apartamento Pinares", "Santa Marta", "Apartamento", "4.5", "400000",
                "Apartamento de lujo con terraza privada", "8", "", "", "", "");

        addLodging("Apartamento Estrella", "Medellín", "Apartamento", "4.7", "550000",
                "Apartamento moderno con acceso a gimnasio y piscina", "4", "", "", "", "");

        // Farm Stays
        addLodging("Finca El Bosque", "Armenia", "Finca", "4.8", "800000",
                "Finca tranquila rodeada de bosque", "10", "", "", "", "");

        addLodging("Finca Los Pinos", "Pereira", "Finca", "4.9", "900000",
                "Finca con vistas a la montaña y espacios amplios", "12", "", "", "", "");

        addLodging("Finca Valle Verde", "Manizales", "Finca", "4.6", "750000",
                "Finca ideal para retiros y actividades al aire libre", "8", "", "", "", "");

        addLodging("Finca El Paraíso", "Caldas", "Finca", "4.7", "850000",
                "Finca en un valle tranquilo rodeado de naturaleza", "14", "", "", "", "");

        addLodging("Finca Los Robles", "Quindío", "Finca", "4.8", "950000",
                "Finca con senderos ecológicos y vista panorámica", "10", "", "", "", "");

        // Day Resorts
        addLodging("Día de Sol Caribe", "San Andrés", "Día de sol", "5.0", "200000",
                "Disfruta del sol, playa y actividades acuáticas", "4", "", "Snorkeling, paseos en bote, kayak, yoga en la playa", "Almuerzo con platos típicos, cena a la carta", "");

        addLodging("Día de Sol Tulum", "Tulum", "Día de sol", "4.9", "220000",
                "Un día de sol con actividades en la Riviera Maya", "2", "", "Tour en cenotes, paseos en bicicleta, actividades acuáticas", "Comida mexicana tradicional, bebidas incluidas", "");

        addLodging("Día de Sol Santa Marta", "Santa Marta", "Día de sol", "5.0", "180000",
                "Relájate en la playa con actividades acuáticas", "6", "", "Surf, paddleboard, snorkeling, caminatas", "Almuerzo buffet, cena en restaurante exclusivo", "");

        addLodging("Día de Sol Cartagena", "Cartagena", "Día de sol", "4.8", "150000",
                "Disfruta del sol en las playas más bellas", "5", "", "Bicicross, deportes acuáticos, yoga", "Comida local, bebidas tropicales", "");

        addLodging("Día de Sol Isla Barú", "Cartagena", "Día de sol", "4.9", "210000",
                "Un día de sol con todas las comodidades frente al mar", "8", "", "Kayak, excursión a la isla, pesca", "Comida caribeña, cócteles", "");
    }

    public static void addLodging(String name, String city, String category, String rating, String price, String description, String maxPeople, String rooms, String activities, String meals, String reservationData) {
        lodgings.add(Arrays.asList(name, city, category, rating, price, description, maxPeople, rooms, activities, meals, reservationData));
    }


}
