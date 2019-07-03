/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smw.backend;

/**
 * @author giesler
 */
public class ZahnbuersteMontage {
    
    public static int stepcounter = 1;
    
    public ZahnbuersteMontage(){
        
    }
    
    public static void nextStep(){
        System.out.println("Schritt " + stepcounter + " für Zahnbuerste");
        stepcounter ++;
    }
}
