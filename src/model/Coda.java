/*
 * Demo di test code
 */
package model;
import java.util.NoSuchElementException;
//import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
/**
 * Classe di implementazione di una coda semplice di oggetti Integer
 * @author peroni
 */
public class Coda {
    private ConcurrentLinkedQueue<Integer> c;
//    private PriorityQueue<Integer> c;
    /**
     * costruttore di default
     */
    public Coda(){
        c=new ConcurrentLinkedQueue<>();
//        c=new PriorityQueue<>();
    }
    /**
     * inserimento in fondo
     * riceve una stringa, la converte in un Integer e la inserisce in fondo
     * @param ingresso stringa numerica intera
     * @throws Exception stringa non numerica, dato nullo
     */
    public void add(String ingresso) throws Exception {
        Integer i=null;
        try{ //prova a convertire in Integer e ad inserire in fondo
            i=Integer.valueOf(ingresso);
            c.add(i);
        }
        catch(NumberFormatException e){ //stringa non numerica
            throw new Exception("Dato non Integer");
        }
        catch(NullPointerException e){ //dato nullo
            throw new Exception("Dato nullo");         
        }
    }
    /**
     * verifica se la coda è vuota
     * @return true coda vuota, false coda non vuota
     */
    public boolean isEmpty() {
        return c.isEmpty();
    }
    /**
     * estrae un Integer dalla testa della coda e lo restituisce
     * @return un oggetto Integer estratto dalla testa
     * @throws Exception coda vuota
     */
    public Integer remove() throws Exception {
        Integer ris=null;
        try{ //prova ad estrarre
            ris=c.remove();
        }
        catch(NoSuchElementException e){ //coda vuota
            throw new Exception("Coda vuota");
        }
        return ris;
    }
    /**
     * legge un Integer dalla testa della coda senza estrarlo e lo restituisce
     * @return un oggetto Integer letto dalla testa
     * @throws Exception coda vuota
     */
    public Integer element() throws Exception {
        Integer ris=null;
        try{ //prova a leggere dalla testa della coda
            ris=c.element();
        }
        catch(NoSuchElementException e){ //coda vuota
            throw new Exception("Coda vuota");
        }
        return ris;
    }
    /**
     * scavalca il toString di default
     * stampa il contenuto della coda
     * @return 
     */
    @Override
    public String toString(){
        return c.toString();
    }
}
