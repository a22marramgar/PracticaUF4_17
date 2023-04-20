/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Representacions;

import Espectacles.Espectacle;
import Recintes.Recinte;
import java.time.LocalDateTime;

/**
 *
 * @author ausias
 */
public class Representacio {

    private Espectacle _espectacle;
    private Recinte _recinte;
    private LocalDateTime _data;
    private boolean[][] _seients;
    private boolean[] _llotges;
    
    public Representacio(Espectacle espectacle, Recinte recinte, 
            LocalDateTime data, boolean[][] seients, boolean[] llotges){
        this._espectacle = espectacle;
        this._recinte = recinte;
        this._data = data;
        this._seients = seients;
        this._llotges = llotges;
    }
    
    public Espectacle getEspectacle() {
        return this._espectacle;
    }

    public Recinte getRecinte() {
        return this._recinte;
    }

    public LocalDateTime getDate() {
        return this._data;
    }

    public int getEntradesBuides() {
        int espaisLliures = 0;
        for (boolean[] filaSeients : _seients) {
            for (boolean seient : filaSeients) {
                if (!seient) {
                    espaisLliures++;
                }
            }
        }
        return espaisLliures;
    }
    
    public int getEspais() {
        return this._seients.length*this._seients[0].length;
    }

    public boolean[][] getSeients() {
        return this._seients;
    }
    
    public boolean[] getLlotges(){
        return this._llotges;
    }
    
    public int llotgesDisponibles(){
        int espaisLliures = 0;
        for (boolean llotja : _llotges) {
            if(!llotja){
                espaisLliures++;
            }
        }
        return espaisLliures;
    }
    
    public boolean reservarSeient(int fila, int columna){
        boolean seient = this._seients[fila][columna];
        boolean reservat = false;
        if(!seient){
            reservat = true;
            this._seients[fila][columna] = true;
        }
        return reservat;
    }
    
    public String getNomRepresentacio(){
        return (this._espectacle.getNom()+", "+this._recinte.getName()+", "+this._data);
    }

    public boolean reservarLlotja(int posLlotja) {
        boolean llotja = this._llotges[posLlotja];
        boolean reservat = false;
        if(!llotja){
            reservat = true;
            this._llotges[posLlotja] = true;
        }
        return reservat;
    }
}
