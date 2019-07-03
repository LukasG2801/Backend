/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smw.builds;

/**
 *
 * @author giesler
 */
public class Legohaus {
    private String manualTitle;
    private String manualInstruction;
    
    public String getManualTitle(){
        return manualTitle;
    }
    
    public void setManualTitle(String manualTitle){
        this.manualTitle = manualTitle;
    }
    
    public String getManualInstruction(){
        return manualInstruction;
    }
    
    public void setManualInstruction(String manualInstruction){
        this.manualInstruction = manualInstruction;
    }
    
    @Override
    public String toString(){
        return "test";
    }
}
