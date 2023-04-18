/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Espectacles;

/**
 *
 * @author ausias
 */
public abstract class Espectacle {
    private final String _nom;
    private final boolean _patiDeButaques;
    private final boolean _llotges;
    
    public Espectacle(String nom, boolean patiDeButaques, boolean llotges){
        this._nom = nom;
        this._patiDeButaques = patiDeButaques;
        this._llotges = llotges;
    }

    public boolean getPatiDeButaques() {
        return this._patiDeButaques;
    }

    public boolean getLlotges() {
        return this._llotges;
    }
    
}
