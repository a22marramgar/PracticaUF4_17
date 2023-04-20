/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practicauf4_17;

import Espectacles.*;
import Recintes.*;
import Representacions.Representacio;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import static utils.UIUtilities.*;

/**
 *
 * @author ausias
 */
public class PracticaUF4_17 {

    final static List<String> tipusEspectacle = Arrays.asList(
            new String[]{"ObraTeatral", "Opera", "Pelicula", "ProvaEsportiva"});
    public static List<Espectacle> llistaEspectacles;
    public static List<Recinte> llistaRecintes;
    public static List<Representacio> llistaRepresentacions;

    public static void main(String[] args) {
        llistaEspectacles = new ArrayList<>();
        llistaRecintes = new ArrayList<>();
        llistaRepresentacions = new ArrayList<>();
        int opcio = 0;
        do {
            opcio = Menu("Registrar espectacle", "Registrar recinte",
                    "Registrar representacio", "Reserves", 
                    "Llistar espectacles per a una data",
                    "Llistar butaques i llotges d'una representacio","Sortir");
            switch (opcio) {
                case 1:
                    RegistrarEspectacle();
                    break;
                case 2:
                    RegistrarRecinte();
                    break;
                case 3:
                    RegistrarRepresentacio();
                    break;
                case 4:
                    Reserves();
                    break;
                case 5:
                    LlistarPerDia();
                    break;
                case 6:
                    LlistarEspaisRepresentacio();
                    break;
                default:
                    break;
            }
        } while (opcio != 7);
    }

    private static void RegistrarEspectacle() {
        String nomEspectacle = llegirString("Nom de l'espectacle: ");
        int opcio = MenuAL(tipusEspectacle);
        switch (opcio) {
            case 1:
                llistaEspectacles.add(new ObraTeatral(nomEspectacle));
                break;
            case 2:
                llistaEspectacles.add(new Opera(nomEspectacle));
                break;
            case 3:
                llistaEspectacles.add(new Pelicula(nomEspectacle));
                break;
            case 4:
                llistaEspectacles.add(new ProvaEsportiva(nomEspectacle));
            default:
                break;
        }
    }

    private static void RegistrarRecinte() {
        String nomRecinte = llegirString("Nom del recinte: ");
        int opcio = Menu("Liceu", "PalauEsports", "Teatre");
        switch (opcio) {
            case 1:
                llistaRecintes.add(new Liceu(nomRecinte));
                break;
            case 2:
                llistaRecintes.add(new PalauEsports(nomRecinte));
                break;
            case 3:
                llistaRecintes.add(new Teatre(nomRecinte));
                break;
            default:
                break;
        }
    }

    private static void RegistrarRepresentacio() {
        int opcio = MenuEspectacle(llistaEspectacles);
        Espectacle espectacle = llistaEspectacles.get(opcio - 1);
        Recinte recinte = MenuRecinte(llistaRecintes, espectacle);
        LocalDateTime data = registrarDate();
        int filas = 0;
        int columnas = 0;
        if (espectacle.getPatiDeButaques()) {
            filas = llegirInt("Numero de files del pati de butaques: ");
            columnas = llegirInt("Numero de columnes de butaques: ");
        }
        boolean[][] butaques = new boolean[filas][columnas];
        int nllotges = 0;
        if (espectacle.getLlotges()) {
            nllotges = llegirInt("Numero de llotges: ");
        }
        boolean[] llotges = new boolean[nllotges];
        llistaRepresentacions.add(
                new Representacio(espectacle, recinte, data, butaques, llotges));
    }

    private static LocalDateTime registrarDate() {
        int day = llegirInt("Dia: ");
        int month = llegirInt("Mes: ");
        int year = llegirInt("Any: ");
        int hrs = llegirInt("Hora: ");
        int min = llegirInt("Minuts: ");
        LocalDateTime data = LocalDateTime.of(year, month,day, hrs, min);
        return data;
    }

    private static void Reserves() {
        Representacio representacio = MenuRepresentacio(llistaRepresentacions);
        reservaButaques(representacio);
        reservaLlotges(representacio);
    }

    private static void reservaButaques(Representacio representacio) {
        System.out.println("Reservar butaca?");
        int opcio = Menu("Si", "No");
        if (opcio == 1) {
            mostrarSeients(representacio);
            int fila = llegirInt("Fila: ") - 1;
            int columna = llegirInt("Columna: ") - 1;
            boolean reservat = representacio.reservarSeient(fila, columna);
            if (reservat) {
                System.out.println("Reserva feta!");
            } else {
                System.out.println("No es pot fer la reserva");
            }
        }
    }

    private static void mostrarSeients(Representacio representacio) {
        for (boolean[] seientFila : representacio.getSeients()) {
            System.out.print("|");
            for (boolean seient : seientFila) {
                
                if (seient) {
                    System.out.print("*|");
                } else {
                    System.out.print("_|");
                }
            }
            System.out.println("");
        }
    }

    private static void reservaLlotges(Representacio representacio) {
        if (representacio.llotgesDisponibles() > 0) {
            System.out.println("Reservar llotja?");
            int opcio = Menu("Si", "No");
            if (opcio == 1) {
                mostrarLlotges(representacio);
                int posLlotja = llegirInt("Llotja: ");
                boolean reservat = representacio.reservarLlotja(posLlotja - 1);
                if (reservat) {
                    System.out.println("Reserva feta!");
                } else {
                    System.out.println("No es pot fer la reserva");
                }
            }
        }
    }

    private static void mostrarLlotges(Representacio representacio) {
        int countLlotja = 1;
        for (boolean llotja : representacio.getLlotges()) {
            System.out.print("Llotja " + countLlotja + ": ");
            System.out.print(llotja ? "reservada" : "buida");
            System.out.println("");
            countLlotja++;
        }
    }

    private static void LlistarPerDia() {
        int day = llegirInt("Dia: ");
        int month = llegirInt("Mes: ");
        int year = llegirInt("Any: ");
        for (Representacio representacio : llistaRepresentacions) {
            LocalDateTime data = representacio.getDate();
            if(data.getDayOfMonth()==day&&data.getMonthValue()==month&&data.getYear()==year){
                System.out.println(representacio.getNomRepresentacio());
            }
        }
    }

    private static void LlistarEspaisRepresentacio() {
        Representacio representacio = MenuRepresentacio(llistaRepresentacions);
        mostrarSeients(representacio);
        mostrarLlotges(representacio);
    }

}
