/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grandprix5ainf_gruppo8;

import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author gabri
 */

public class car extends Thread {
    public String marca;
    public String modello;
    public int anno;
    public int velocita;
    public int distanzaPercorsa;
    

    public car(String marca, String modello, int anno, int velocita) {
        this.marca = marca;
        this.modello = modello;
        this.anno = anno;
        this.velocita = velocita;
        this.distanzaPercorsa = 0;
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
    
    public int getDistanzaPercorsa() {
        return distanzaPercorsa;
    }
    
    public static void simulazioneGara(ArrayList<car> cars, int circuitLength,int velocita) {
        for (car car : cars) {
            car.start();
        }

        for (car car : cars) {
            try {
                car.join();
            } catch (InterruptedException e) {
               System.out.println("Errore nel metodo join");
            }
        }

        //ORDINA LE AUTO IN BASE ALLA DISTANZA PERCORSA (ORDINE DECRESCENTE)
        Collections.sort(cars, Comparator.comparingInt(car::getDistanzaPercorsa).reversed());

        //STAMPA I RISULTATI DELLA GARA
        System.out.println("\n[Giudice] Risultrati della gara:");
        int position = 1;
        for (car car : cars) {
            System.out.println("Posizione " + position + ": " + car.getMarca() + " " + car.getModello() + " - distanza percorsa: " + car.getDistanzaPercorsa()+velocita + " metri");
            position++;
        }
    }
}
