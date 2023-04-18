/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Recintes;

import java.util.List;

/**
 *
 * @author ausias
 */
public abstract class Recinte {
    private String _nom;
    private List<String> _espectaclesAdmesos;
    
    public Recinte(String nom, List<String> espectaclesAdmesos){
        this._nom = nom;
        this._espectaclesAdmesos = espectaclesAdmesos;
    }

    public List<String> getEspectaclesAdmesos(){
        return this._espectaclesAdmesos;
    }
    
}
