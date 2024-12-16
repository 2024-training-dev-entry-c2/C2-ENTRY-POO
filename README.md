# HotelApp

## Descripción

HotelApp es una aplicación de consola Java que simula un sistema de reservas de hotel. Permite a los usuarios realizar, actualizar y cancelar reservas en diferentes hoteles, tipos de habitaciones y ciudades.

## Funcionalidades

* **Realizar una reserva:**
    * Seleccionar ciudad, tipo de alojamiento, cantidad de adultos y niños, cantidad de habitaciones, fechas de estadía.
    * Filtrar hoteles y habitaciones disponibles según los criterios de búsqueda.
    * Calcular el costo total de la reserva, incluyendo posibles descuentos o aumentos.
    * Confirmar la reserva e ingresar los datos personales del usuario.
* **Actualizar una reserva:**
    * Buscar la reserva por email y fecha de nacimiento.
    * Modificar las fechas de estadía, el hotel, el tipo de habitación, la cantidad de habitaciones o los datos personales.
* **Cancelar una reserva:**
    * Buscar la reserva por email y fecha de nacimiento.
    * Confirmar la cancelación y liberar la disponibilidad de la habitación.
* **Mostrar todas las reservas:**
    * Listar todas las reservas realizadas con sus detalles.

## Estructura del Código

* **`Main.java`:** Contiene la clase principal con el método `main` y la lógica de la aplicación.
* **Arrays:**
    * `hotelNombres`, `tipoAlojamiento`, `ciudades`, `calificaciones`, `precios`: Almacenan información de los hoteles.
    * `habitacionHotelID`, `habitacionTipos`, `habitacionCaracteristicas`, `habitacionPrecios`: Almacenan información de las habitaciones.
    * `habitacionDisponibilidad`: Matriz tridimensional que indica la disponibilidad de cada habitación para cada día del año.
    * `nombresReservas`, `emailsReservas`, `fechaNacimientoReservas`, `hotelesReservas`, `habitacionesReservas`, `fechasInicioReservas`, `fechasFinReservas`, `cantidadAdultosReservas`, `cantidadNiniosReservas`: Almacenan información de las reservas.
* **Métodos:**
    * `inicializarDatos()`: Inicializa los datos de hoteles, habitaciones y disponibilidad.
    * `mostrarMenu()`: Muestra el menú principal de la aplicación.
    * `realizarReserva()`: Gestiona el proceso de creación de una nueva reserva.
    * `actualizarReserva()`: Permite al usuario modificar una reserva existente.
    * `cancelarReserva()`: Cancela una reserva y libera la disponibilidad de la habitación.
    * `mostrarReservas()`: Muestra una lista de todas las reservas.
    * `eliminarDuplicados()`: Elimina duplicados de un array de strings.
    * `listarOpciones()`: Muestra una lista de opciones al usuario y solicita una selección.
    * `filtrarHoteles()`: Filtra los hoteles según los criterios de búsqueda.
    * `filtrarHabitaciones()`: Filtra las habitaciones disponibles en un hotel.
    * `calcularDescuento()`: Calcula el descuento o aumento en el precio según las fechas de estadía.
    * `solicitarFecha()`: Solicita al usuario una fecha en el formato "dd/MM/yyyy".
    * `solicitarNumero()`: Solicita al usuario un número entero.

## Cómo Ejecutar

1. Compilar el código Java: `javac Main.java`
2. Ejecutar la aplicación: `java Main`

## Ejemplo de Uso

1. Al ejecutar la aplicación, se mostrará el menú principal.
2. Seleccionar la opción "1" para realizar una reserva.
3. Seguir las instrucciones en la consola para seleccionar la ciudad, tipo de alojamiento, fechas, etc.
4. Ingresar los datos personales para confirmar la reserva.
5. Se mostrará un resumen de la reserva con el costo total.
6. Para actualizar o cancelar una reserva, seleccionar la opción correspondiente en el menú principal e ingresar el email y fecha de nacimiento asociados a la reserva.

## Notas

* La aplicación utiliza arrays para almacenar los datos. Se podrían utilizar estructuras de datos más eficientes como ArrayLists o HashMaps para un mejor rendimiento.
* La lógica de cálculo de descuentos y aumentos se podría simplificar o modificar según las necesidades.
* Se podrían agregar más funcionalidades como la gestión de usuarios, la búsqueda de hoteles por nombre, la visualización de la disponibilidad de habitaciones en un calendario, etc.
* La interfaz de usuario de consola es básica. Se podría mejorar la experiencia del usuario con una interfaz gráfica.
