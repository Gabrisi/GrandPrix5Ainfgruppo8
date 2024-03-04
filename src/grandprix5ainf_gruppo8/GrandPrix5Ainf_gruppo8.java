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
        int nMacchinaTruccata = 0;
        int numeroCircuito;
        int nGiri;
        int flag = 0;
        int contatore1 = 0;
        int contatore2 = 0;
        int contatore3 = 0;
        
        //INSTANZIAMO GLI OGGETTI
        driver guidatore1 = new driver(nome,cognome);
        player giocatore1 = new player(giocatore,"informazioniUtente.csv");
        giocatore1.leggi();

        //RICHIESTA DELLE INFORMAZIONI PERSONALI AL GIOCATORE
        Scanner scanner = new Scanner(System.in);
        ArrayList<car> autoList = new ArrayList<>();
        
        System.out.print("[LogIn] Inserisci nome: "); //richiede l'username in input
        String username = scanner.nextLine();//assegna l'username letto in input alla variabile "username"
        String usernameUpper = username.toUpperCase();
        
        System.out.print("[LogIn] Inserisci password: "); //richiede la password in input
        String passwordGiocatore = scanner.nextLine(); //assegna la password letta in input alla variabile "password"
        String passwordUpper = passwordGiocatore.toUpperCase();
        
        do {
            System.out.print("\n[Giudice] Inserisci il numero di auto che desideri aggiungere: ");
            nMacchine = scanner.nextInt();
            if(nMacchine == 0){
                System.out.println("[Giudice] Devi inserire un numero maggiore di 0!!");
            }
        } while (nMacchine <= 0);
        scanner.nextLine();

        //CICLO PER AGGIUNGERE LE MACCHINE NELL'ARRAY LIST
        for (int i = 0; i < nMacchine; i++) {
            Random random = new Random();
            contatore1 = i+1;
            System.out.print("\nMacchina n" + contatore1 + ": " );
            System.out.print("\n[Giudice] Inserisci la marca dell'auto: ");
            String marca = scanner.nextLine();
            System.out.print("[Giudice] Inserisci il modello dell'auto: ");
            String modello = scanner.nextLine();
            System.out.print("[Giudice] Inserisci l'anno di produzione dell'auto: ");
            int anno = scanner.nextInt();
            
            //LE MACCHINE INSERITE OTTENGONO UNA VELOCITA' RANDOM
            int velocita = 1 + random.nextInt(250);        
            scanner.nextLine();

            autoList.add(new car(marca, modello, anno, velocita));
        }

        //STAMPA TUTTE LE MACCHINE INSERITE
        System.out.println("\n[Giudice] Le auto aggiunte sono: ");
        for (car car : autoList) {
            contatore2 = contatore2 + 1;
            System.out.println("Macchina n" + contatore2 + "| Marca: " + car.getMarca() + ", Modello: " + car.getModello() + ", Anno: " + car.getAnno());
        }
          
        //RICHIESTA SE SI VUOLE TRUCCARE UNA MACCHINA - BISOGNA FAR SI CHE LA VELOCITA' DELLA MACCHINA TRUCCATA AUMENTI
        System.out.println("\n[Giudice] Vuoi truccare una macchina? (0: Si) (1: No) ");
        int risposta = scanner.nextInt();
        if(risposta == 0){
            do {
                System.out.println("\n[Giudice] Che macchina vuoi truccare? ");
                nMacchinaTruccata = scanner.nextInt();
                    if(nMacchinaTruccata == 0){
                        System.out.println("[Giudice] Devi inserire un numero maggiore di 0!! ");
                    }
                    if(nMacchinaTruccata > nMacchine){
                           System.out.println("[Giudice] Devi inserire un numero compreso da 1 a " + nMacchine + "!! ");
                    }
            } while (nMacchinaTruccata <= 0 || nMacchinaTruccata > 3);
        }
        System.out.print("\n[Giudice] Ottimo! hai truccato la macchina numero: " + nMacchinaTruccata + "!!");
                
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
        System.out.println("\n");
        System.out.println("\n[Giudice] I circuiti sono:");
        circuito[] circuitoArray = new circuito[3];
        circuitoArray[0] = new circuito("Monza", 1 , 700);
        circuitoArray[1] = new circuito("Milano", 2 , 600);
        circuitoArray[2] = new circuito("Montecarlo", 3 , 800);        
        //si potrebbe pensare ad un'array dinamico di circuiti dove far inserire agli utenti nuovi circuiti
        
        //STAMPARE LA LISTA DEI CIURCUITI
        for (int i = 0; i < 3; i++) {
            contatore3 = contatore3 + 1;
            System.out.println("Circuito n" + contatore3 + "| Nome Circuito: " + circuitoArray[i].getNomeCircuito() + ", Numero Circuito: " + circuitoArray[i].getNumCircuito() + ", Lunghezza: " + circuitoArray[i].getLunghezza()); //da sistemare
        }
        
        //L'UTENTE SCEGLIE IL CIRCUITO SU CUI FAR CORRERE LE SUE MACCHINE
        do {
            System.out.print("\n[Giudice] Inserisci il numero del circuito su cui vuoi gareggiare (il numero deve andare da 1 a 3): ");
            numeroCircuito = scanner.nextInt();
            if(numeroCircuito == 0){
                System.out.println("[Giudice] Devi inserire un numero maggiore di 0!! ");
            }
            if(numeroCircuito > 3){
                System.out.println("[Giudice] Devi inserire un numero compreso da 1 a 3!! ");
            }
        } while (numeroCircuito <= 0 || numeroCircuito > 3); 
        System.out.print("\n[Giudice] Ottimo! hai scelto il circuito di " + circuitoArray[numeroCircuito-1].getNomeCircuito() + "!!");
        
        //L'UTENTE SCEGLIE I NUMERI DEI GIRI NECESSARI PER TERMINARE LA GARA
        System.out.println("\n");
        do {
            System.out.println("[Giudice] Quanti numeri di giri sono necessari per terminare la gara? ");
            nGiri = scanner.nextInt();
            if(nGiri == 0){
                System.out.println("[Giudice] Devi inserire un numero maggiore di 0!!");
            }
        } while (nGiri <= 0);
        System.out.println("\n[Giudice] Servono " + nGiri + " giri per terminare la gara!!");
        
        giudice giud1 = new giudice();
        giudice.inizioGara();
        
    }
}
