/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grandprix5ainf_gruppo8;

import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author gabri
 */
public class player {
    String giocatore;
    String nomeFile;
    public player(String giocatore, String nomeFile){
        this.giocatore=giocatore;
        this.nomeFile=nomeFile;
    }
        public void leggi(){
        FileReader fr;
        int i; 
        try { 
            //1) apro il file
            fr = new FileReader(nomeFile);
            //2) leggo carattere per carattere e lo stampo 
            while ((i=fr.read()) != -1)
                System.out.print((char) i);
            System.out.print("\n\r");
            //3) chiudo il file
            fr.close();
        } catch (IOException ex) {
        System.err.println("Errore in lettura!");
        }
    }
}
