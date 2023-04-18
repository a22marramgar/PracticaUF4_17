/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practicauf4_17;

import Espectacles.*;
import java.util.Arrays;
import java.util.List;
import static utils.UIUtilities.*;

/**
 *
 * @author ausias
 */
public class PracticaUF4_17 {

    final static List<String> tipusEspectacle = Arrays.asList(
            new String[]{"ObraTeatral","Opera","Pelicula","ProvaEsportiva"});
    public static List<Espectacle> llistaEspectacles;
    
    public static void main(String[] args) {
        int opcio = 0;
        do {
            opcio = Menu("Registrar espectacle", "Registrar recinte",
                    "Registrar representacio", "Reserves", "Sortir");
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
                default:
                    break;
            }
        } while (opcio != 5);
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void RegistrarRepresentacio() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void Reserves() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
