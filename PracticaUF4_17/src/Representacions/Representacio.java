/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Representacions;

import Espectacles.Espectacle;
import Recintes.Recinte;
import java.util.Date;

/**
 *
 * @author ausias
 */
public class Representacio {

    private Espectacle _espectacle;
    private Recinte _recinte;
    private Date _data;
    private char[][] _seients;
    
    public Representacio(Espectacle espectacle, Recinte recinte, Date data, char[][] seients){
        this._espectacle = espectacle;
        this._recinte = recinte;
        this._data = data;
        this._seients = seients;
    }
    
    public Espectacle getEspectacle() {
        return this._espectacle;
    }

    public Recinte getRecinte() {
        return this._recinte;
    }

    public Date getDate() {
        return this._data;
    }

    public int getEntradesBuides() {
        int espaisLliures = 0;
        for (char[] filaSeients : _seients) {
            for (char seient : filaSeients) {
                if (seient=='_') {
                    espaisLliures++;
                }
            }
        }
        return espaisLliures;
    }
    
    public int getEspais() {
        return this._seients.length*this._seients[0].length;
    }

    public char[][] getSeients() {
        return this._seients;
    }
    
    public boolean reservarSeient(int fila, int columna){
        char seient = this._seients[fila][columna];
        boolean reservat = false;
        if(seient == '_'){
            reservat = true;
        }
        return reservat;
    }
}
