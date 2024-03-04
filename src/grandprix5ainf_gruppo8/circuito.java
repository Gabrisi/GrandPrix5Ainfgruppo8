/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grandprix5ainf_gruppo8;

/**
 *
 * @author gabri
 */

public class circuito {
    public String nomeCircuito;
    public int nCircuito;
    public int lunghezza;
    
    public circuito(String nomeCircuito, int nCircuito, int lunghezza) {
        this.nomeCircuito = nomeCircuito;
        this.nCircuito = nCircuito;
        this.lunghezza = lunghezza;
    }
    
    public String getNomeCircuito() {
        return nomeCircuito;
    }

    public void setNomeCircuito(String nomeCircuito) {
        this.nomeCircuito = nomeCircuito;
    }

    public int getNumCircuito() {
        return nCircuito;
    }

    public void setNumCircuito(int nCircuito) {
        this.nCircuito = nCircuito;
    }

    public int getLunghezza() {
        return lunghezza;
    }

    public void setLunghezza(int lunghezza) {
        this.lunghezza = lunghezza;
    }
    
}    
