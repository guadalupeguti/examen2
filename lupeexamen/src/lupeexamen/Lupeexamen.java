package lupeexamen;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class Lupeexamen 
{
    public static void main(String[] args) 
    {
       Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese los datos del usuario:");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine().toUpperCase();

        System.out.print("Apellido paterno: ");
        String apellidoPaterno = scanner.nextLine().toUpperCase();

        System.out.print("Apellido materno: ");
        String apellidoMaterno = scanner.nextLine().toUpperCase();

        System.out.print("Fecha de nacimiento (formato AAAA-MM-DD): ");
        String fechaNacimiento = scanner.nextLine();

        System.out.print("Sexo (H/M): ");
        char sexo = scanner.nextLine().toUpperCase().charAt(0);

        // Generar CURP
        String curp = generarCURP(nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, sexo);
        System.out.println("CURP: " + curp);

        // Generar RFC
        String rfc = generarRFC(nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento);
        System.out.println("RFC: " + rfc);
    }

    private static String generarCURP(String nombre, String apellidoPaterno, String apellidoMaterno, String fechaNacimiento, char sexo) {
        // Implementación básica, no cumple con la especificación oficial
        return apellidoPaterno.substring(0, 2) + apellidoMaterno.charAt(0) + nombre.charAt(0) +
                fechaNacimiento.substring(2, 4) + fechaNacimiento.substring(5, 7) + fechaNacimiento.substring(8) +
                String.valueOf(sexo) + "XXX";
    }

    private static String generarRFC(String nombre, String apellidoPaterno, String apellidoMaterno, String fechaNacimiento) {
        // Implementación básica, no cumple con la especificación oficial
        String rfcFecha = fechaNacimiento.substring(2, 4) + fechaNacimiento.substring(5, 7) + fechaNacimiento.substring(8);
        String rfcNombre = obtenerParteNombre(nombre);
        String rfcPaterno = obtenerParteApellido(apellidoPaterno);
        String rfcMaterno = obtenerParteApellido(apellidoMaterno);

        return rfcPaterno + rfcMaterno + rfcNombre + rfcFecha + "XXX";
    }

    private static String obtenerParteNombre(String nombre) {
        if (nombre.length() >= 3) {
            return nombre.substring(0, 3);
        } else {
            return nombre + "X";
        }
    }

    private static String obtenerParteApellido(String apellido) {
        if (apellido.length() >= 2) {
            return apellido.substring(0, 2);
        } else {
            return apellido + "X";
        }
    } 
    }
    

