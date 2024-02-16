/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package grandprix5ainf_gruppo8;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
        String passwordGiocatore = null;
        //istanziamo gli oggetti
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
        
        scanner.close(); // chiudo lo scanner
        
        //COPIO IL NOME E LA PASSWORD NEL FILE "File.csv"
        try{
            // scrivo nel buffer
            BufferedWriter br = new BufferedWriter(new FileWriter(nomeFile1));
            br.write(username + ";" + passwordGiocatore); 
            br.write("\n\r");
            // svuoto il buffer e salvo nel file i dati
            br.flush();         
        } catch (IOException ex) {
            Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
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
