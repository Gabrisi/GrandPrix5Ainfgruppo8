/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package grandprix5ainf_gruppo8;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.*;

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
        String nomeFile = "File.csv";
        
        //INSTANZIAMO GLI OGGETTI
        car macchina1 = new car(marca);
        driver guidatore1 = new driver(nome,cognome);
        player giocatore1 = new player(giocatore,"Dati.json");
        giocatore1.leggi();
        System.out.println(giocatore1.nomeFile);

        //RICHIESTA DELLE INFORMAZIONI PERSONALE DELL'UTENTE
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Inserisci nome: "); //richiede l'username in input
        String username = scanner.nextLine();//assegna l'username letto in input alla variabile "username"
        
        System.out.print("Inserisci password: "); //richiede la password in input
        String passwordGiocatore = scanner.nextLine(); //assegna la password letta in input alla variabile "password"
        
        System.out.print("Inserisci il numero delle macchine che vuoi: "); //richiede il numero delle macchine in input
        int nMacchine = scanner.nextInt();//assegna l'username letto in input alla variabile "username"
        
        //scanner.close(); // chiudo lo scanner
        
        //RICHIESTA SE SI VUOLE TRUCCARE UNA MACCHINA
        for(int i=1; i<nMacchine; i++) {
	System.out.print("Vuoi truccare la macchina " + i + "?");
        String risposta = scanner.nextLine();
        System.out.println(risposta);
        if("si".equals(risposta)){
            System.out.print("Hai truccato la macchina numero " + i + "!");
        }else{
            risposta = null;
            }
        }
        //COPIO IL NOME E LA PASSWORD NEL FILE "File.csv"
        try{
            // scrivo nel buffer
            BufferedWriter br = new BufferedWriter(new FileWriter(nomeFile));
            br.write(username + ";" + passwordGiocatore); 
            br.write("\n\r");
            // svuoto il buffer e salvo nel file i dati
            br.flush();         
        } catch (IOException ex) {
            System.err.println("Errore metodo join");
        }
        
        //CIFRO LA PASSWORD CON IL CIFRARIO DI VIGENERE
        ArrayList<Vigenere> quadranti = new ArrayList<Vigenere>(); 

        Matrice matrix=new Matrice("TPSIT");
    
        Vigenere quadrante_1=new Vigenere(0,12,0,12,matrix);
        quadranti.add(quadrante_1);
    
        Vigenere quadrante_2=new Vigenere(0,12,12,26,matrix);
        quadranti.add(quadrante_2);
    
        Vigenere quadrante_3=new Vigenere(12,26,0,12,matrix);
        quadranti.add(quadrante_3);
    
        Vigenere quadrante_4=new Vigenere(12,26,12,26,matrix);
        quadranti.add(quadrante_4);
        
        for(Vigenere v:quadranti){
         Thread t= new Thread(v);
         t.start();
         try {
           t.join();
         }catch (InterruptedException ex) {
             System.err.println("Errore metodo join");
         }
        }  
        
        String passwordCifrata = matrix.cifra(passwordGiocatore);
        
        }
    }

