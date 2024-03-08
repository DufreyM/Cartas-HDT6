import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class Controlador {
    Scanner scanner = new Scanner(System.in);
    Map<String, Integer> coleccionUsuario = new HashMap<>();

    public void ejecutar(){
    
        System.out.println("Seleccione la implementación de Map que desea usar:");
        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap");
        int opcion = scanner.nextInt();
        InterfaceMap collection = null;

        switch (opcion) {
            case 1:
                collection = new HashMapF();
                break;
            case 2:
                collection = new TreeMapF();
                break;
            case 3:
                collection = new LinkedHasMapF();
                break;
            default:
                System.out.println("Opción no válida. Se seleccionará HashMap por defecto.");
                collection = new HashMapF();
                break;
        }

        Map<String, String> cartas = Lector.leerCartas(collection);

        while (true) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Agregar una carta a la colección");
            System.out.println("2. Mostrar el tipo de una carta");
            System.out.println("3. Mostrar la colección del usuario");
            System.out.println("4. Mostrar la colección del usuario ordenada por tipo");
            System.out.println("5. Mostrar todas las cartas existentes");
            System.out.println("6. Mostrar todas las cartas existentes ordenadas por tipo");
            System.out.println("7. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine();
            int contadorUsuario = 1; 
            switch (choice) {
                case 1:
                    System.out.println("Ingrese el nombre de la carta que desea agregar:");
                    String nombreCarta = scanner.nextLine();
        
                    if (cartas.containsKey(nombreCarta)) {
                        if (coleccionUsuario.containsKey(nombreCarta)==(cartas.containsKey(nombreCarta))){
                            contadorUsuario = contadorUsuario + 1; 
                        }
                        coleccionUsuario.put(nombreCarta, contadorUsuario);
                        System.out.println("Carta agregada correctamente.");
                    } else {
                        System.out.println("La carta no se encuentra disponible.");
                    }
                    break;
                    
                case 2:
                    System.out.println("Ingrese el nombre de la carta:");
                    String carta = scanner.nextLine();
                    String tipo = cartas.get(carta);
                    if (tipo != null) {
                        System.out.println("Tipo de la carta '" + carta + "': " + tipo);
                    } else {
                        System.out.println("La carta no se encuentra en la colección.");
                    }
                    break;

                case 3:
                for  (Map.Entry<String, Integer> entry : coleccionUsuario.entrySet()) {
                        System.out.println("Nombre: " + entry.getKey() + ", Cantidad: " + entry.getValue());
                    }
                    break;
                 
                case 4:
                for (Map.Entry<String, Integer> entrada : coleccionUsuario.entrySet()){
                    for (Map.Entry<String, String> entry : cartas.entrySet()){
                         if (entrada.getKey().equalsIgnoreCase(entry.getKey())){
                            if (entry.getValue().equalsIgnoreCase("Monstruo")){
                            System.out.println("Tipo: " + entry.getValue() + " Nombre: " + entrada.getKey() + ", Cantidad: " + entrada.getValue());
                            }

                            if (entry.getValue().equalsIgnoreCase("Trampa")){
                            System.out.println("Tipo: " + entry.getValue() + " Nombre: " + entrada.getKey() + ", Cantidad: " + entrada.getValue());
                            }

                            if (entry.getValue().equalsIgnoreCase("Hechizo")){
                            System.out.println("Tipo: " + entry.getValue() + " Nombre: " + entrada.getKey() + ", Cantidad: " + entrada.getValue());
                            }
                        }
                    }
                }
                    break;

                case 5:
                    for (Map.Entry<String, String> entry : cartas.entrySet()) {
                        System.out.println("Nombre: " + entry.getKey() + ", Tipo: " + entry.getValue());
                    }
                    break;

                case 6:
                //Media hora de mi vida para comprender como por qué no posía usar == y era equals
                    System.out.println("MONSTRUO");
                    for (Map.Entry<String, String> entry : cartas.entrySet())
                        if (entry.getValue().equalsIgnoreCase("Monstruo")){
                        System.out.println("Nombre: " + entry.getKey() + ", Tipo: " + entry.getValue());
                     }
                    System.out.println("TRAMPA");
                    for (Map.Entry<String, String> entry : cartas.entrySet())
                        if (entry.getValue().equalsIgnoreCase("Trampa")){
                        System.out.println("Nombre: " + entry.getKey() + ", Tipo: " + entry.getValue());
                    }
                    System.out.println("HECHIZO");
                    for (Map.Entry<String, String> entry : cartas.entrySet())
                        if (entry.getValue().equalsIgnoreCase("Hechizo")){
                        System.out.println("Nombre: " + entry.getKey() + ", Tipo: " + entry.getValue());
                    }
                    break;

                case 7:
                    System.out.println("Gracias por usar cartas");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}

