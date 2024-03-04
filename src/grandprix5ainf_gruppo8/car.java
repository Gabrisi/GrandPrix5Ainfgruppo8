/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grandprix5ainf_gruppo8;

import java.util.Random;

/**
 *
 * @author gabri
 */

public class car extends Thread {
    public String marca;
    public String modello;
    public int anno;
    public int velocita;
    

    public car(String marca, String modello, int anno, int velocita) {
        this.marca = marca;
        this.modello = modello;
        this.anno = anno;
        this.velocita = velocita;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }
    
    @Override
    public void run(){
        
    }
}
