/*
 * Demo di test code
 */
package testcoda;
import java.util.Scanner;
import model.Coda;
/**
 * Main class di test di una coda
 * Il main istanzia una coda e gestisce un main loop di manipolazione
 * @author peroni
 */
public class Testcoda {
    /**
     * main loop:
     * Le operazioni previste sono:
     * - inserimento in fondo
     * - verifica coda vuota
     * - estrazione in testa
     * - consultazione in testa
     * - stampa del contenuto
     * - uscita 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //variabili applicative
        Coda coda;
        Scanner lettore;
        boolean continua;
        String ingresso;
        int scelta;
        Integer uscita;
        //inizializzazione
        coda=new Coda();
        lettore=new Scanner(System.in);
        continua=true;
        System.out.println("Demo gestione coda");
        //main loop di gestione della coda
        while(continua){
            //lettura della stringa di comando
            System.out.print("1=inserisci,2=verifica,3=estrai,4=consulta,5=stamp,6=esci:");
            ingresso=lettore.nextLine();
            try { //prova a convertire in un intero
                scelta=Integer.parseInt(ingresso);
            }
            catch(Exception e){ //comando non valido
                scelta=0;
            }
            //selezione del comando
            switch(scelta){
                    case 1: //inserimento in testa
                        System.out.print("Inserire un numero:");
                        ingresso=lettore.nextLine();
                        try { //prova ad inserire in fondo
                            coda.add(ingresso);
                            System.out.println("Dato inserito");
                        }
                        catch (Exception e) { //inserimento fallito
                            System.out.println(e.toString());
                        }
                        break;
                    case 2: //verifica coda vuota
                        if(coda.isEmpty()){ //coda vuota
                            System.out.println("Coda vuota");                            
                        }
                        else { //coda non vuota
                            System.out.println("Coda non vuota");                          
                        }
                        break;
                    case 3: //estrazione dalla testa
                        try{ //prova ad estrarre dalla testa
                            uscita=coda.remove();
                            System.out.println("Estratto:"+uscita);
                        }
                        catch(Exception e){ //coda vuota
                            System.out.println("Coda vuota");                                                        
                        }
                        break;
                    case 4: //consultazione in testa
                        try{ //prova a consultare la testa
                            uscita=coda.element();
                            System.out.println("Consultato:"+uscita);
                        }
                        catch(Exception e){ //coda vuota
                            System.out.println("Coda vuota");                                                        
                        }                        
                        break;
                    case 5: //stampa il contenuto
                        System.out.println(coda.toString());
                        break;
                    case 6: //termina
                        continua=false;
                        break;
                    default:
                        System.out.println("Opzione non valida");                
                }
        }
        System.out.println("Fine Demo gestione coda");
    }
}
