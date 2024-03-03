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
import java.util.Random;

/**
 *
 * @author gabri
 */

public class GrandPrix5Ainf_gruppo8 {

    public static void main(String[] args) {
        String nome = null; 
        String cognome = null; 
        String giocatore = null; 
        String nomeFile = "informazioniUtente.csv";
        int nMacchine;
        int nMacchinaTruccata;
        int numeroCircuito;
        int n = 0;
        
        //INSTANZIAMO GLI OGGETTI
        driver guidatore1 = new driver(nome,cognome);
        player giocatore1 = new player(giocatore,"informazioniUtente.csv");
        giocatore1.leggi();

        //RICHIESTA DELLE INFORMAZIONI PERSONALI AL GIOCATORE
        Scanner scanner = new Scanner(System.in);
        ArrayList<car> autoList = new ArrayList<>();
        
        System.out.print("Inserisci nome: "); //richiede l'username in input
        String username = scanner.nextLine();//assegna l'username letto in input alla variabile "username"
        String usernameUpper = username.toUpperCase();
        
        System.out.print("Inserisci password: "); //richiede la password in input
        String passwordGiocatore = scanner.nextLine(); //assegna la password letta in input alla variabile "password"
        String passwordUpper = passwordGiocatore.toUpperCase();
        
        do {
            System.out.print("\nInserisci il numero di auto che desideri aggiungere: ");
            nMacchine = scanner.nextInt();
            if(nMacchine == 0){
                System.out.println("Devi inserire un numero maggiore di 0!!");
            }
        } while (nMacchine <= 0);
        scanner.nextLine();

        //CICLO PER AGGIUNGERE LE MACCHINE NELL'ARRAY LIST
        for (int i = 0; i < nMacchine; i++) {
            Random random = new Random();
            int contatore = i+1;
            System.out.print("\nMacchina n" + contatore + ": " );
            System.out.print("\nInserisci la marca dell'auto: ");
            String marca = scanner.nextLine();
            System.out.print("Inserisci il modello dell'auto: ");
            String modello = scanner.nextLine();
            System.out.print("Inserisci l'anno di produzione dell'auto: ");
            int anno = scanner.nextInt();
            
            //LE MACCHINE INSERITE OTTENGONO UNA VELOCITA' RANDOM
            int velocita = 1 + random.nextInt(250);        
            scanner.nextLine();

            autoList.add(new car(marca, modello, anno, velocita));
        }

        //STAMPA TUTTE LE MACCHINE INSERITE
        System.out.println("\nLe auto aggiunte sono: ");
        for (car car : autoList) {
            n = n + 1;
            System.out.println("Macchina n" + n + "| Marca: " + car.getMarca() + ", Modello: " + car.getModello() + ", Anno: " + car.getAnno());
        }
          
        //RICHIESTA SE SI VUOLE TRUCCARE UNA MACCHINA - BISOGNA FAR SI CHE LA VELOCITA' DELLA MACCHINA TRUCCATA AUMENTI
        System.out.println("\nVuoi truccare una macchina? (0: Si) (1: No) ");
        int risposta = scanner.nextInt();
        if(risposta == 0){
            do {
                System.out.println("\nChe macchina vuoi truccare? ");
                nMacchinaTruccata = scanner.nextInt();
                    if(nMacchinaTruccata == 0){
                        System.out.println("Devi inserire un numero maggiore di 0!! ");
                    }
                    if(nMacchinaTruccata > nMacchine){
                           System.out.println("Devi inserire un numero compreso da 1 a " + nMacchine + "!! ");
                    }
            } while (nMacchinaTruccata <= 0 || nMacchinaTruccata > 3);
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
        
        String passwordCifrata = matrix.cifra(passwordUpper);
        
        //COPIO IL NOME E LA PASSWORD CIFRATA NEL FILE "informazioniUtente.csv"
        try{
            //scrivo nel buffer
            BufferedWriter br = new BufferedWriter(new FileWriter(nomeFile));
            br.write(username + ";" + passwordCifrata); 
            br.write("\n\r");
            //svuoto il buffer e salvo nel file i dati
            br.flush();         
        } catch (IOException ex) {
            System.err.println("Errore metodo join");
        }
        
        //CREIAMO I CIRCUITI
        circuito[] circuitoArray = new circuito[3];
        circuitoArray[0] = new circuito("Monza", 1 , 700);
        circuitoArray[1] = new circuito("Milano", 2 , 600);
        circuitoArray[2] = new circuito("Montecarlo", 3 , 800);        
        //si potrebbe pensare ad un'array dinamico di circuiti dove far inserire agli utenti nuovi circuiti
        
        //STAMPARE LA LISTA DEI CIURCUITI
        for (int i = 0; i < 3; i++) {
            n = n + 1;
            System.out.println("Circuito n" + n + "| " + circuitoArray[i]); //da sistemare
        }
        
        //L'UTENTE SCEGLIE IL CIRCUITO SU CUI FAR CORRERE LE SUE MACCHINE
        do {
            System.out.print("\nInserisci il numero del circuito su cui vuoi gareggiare (il numero deve andare da 1 a 3): ");
            numeroCircuito = scanner.nextInt();
            if(numeroCircuito == 0){
                System.out.println("Devi inserire un numero maggiore di 0!! ");
            }
            if(numeroCircuito > 3){
                System.out.println("Devi inserire un numero compreso da 1 a 3!! ");
            }
        } while (numeroCircuito <= 0 || numeroCircuito > 3);   
    }
}
