/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package grandprix5ainf_gruppo8;

import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author gabri
 */
public class GrandPrix5Ainf_gruppo8 {

    public static void main(String[] args) {
        String marca = null; //assegnare il valore dal file a questa variabile
        String nome = null;
        String cognome = null;
        String giocatore = null;
        //istanziamo gli oggetti
        car macchina1 = new car(marca);
        driver guidatore1 = new driver(nome,cognome);
        player giocatore1 = new player(giocatore,"Dati.json");
        giocatore1.leggi();
        System.out.println(giocatore1.nomeFile);
        
    }
    
}
