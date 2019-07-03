/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smw.backend;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonBuilderFactory;

/**
 *  Generate JSON to publish over REST Service
 * @author giesler
 */
public class BuildJSON {
        
    public String initJSON(){
        JsonBuilderFactory factory = Json.createBuilderFactory(null);
        JsonArray array = factory.createArrayBuilder()
                .add(factory.createObjectBuilder()
                        .add("manualTitle", "Parallelschraubzwinge")
                        .add("manualInstructions", factory.createArrayBuilder()
                                .add(factory.createObjectBuilder()
                                        .add("instructionTitle", "Schritt1")
                                        .add("instructionVisualization", "./Bild_Schritt_1.jpg")
                                        .add("instructionDescription", "Schritt 1 ")
                                        .add("instructionItems",  factory.createArrayBuilder()
                                                .add(factory.createObjectBuilder()
                                                        .add("Zwei Stahl Backen entnehmen","")
                                                        .add("Gegenüberliegend platzieren", "")
                                                )
                                        )
                                        
                                )
                                .add(factory.createObjectBuilder()
                                        .add("instructionTitle", "Schritt2")
                                        .add("instructionVisualization", "./GIF_Schritt_2.gif")
                                        .add("instructionDescription", "Schritt 2 ")
                                        .add("instructionItems", factory.createArrayBuilder()
                                                .add(factory.createObjectBuilder()
                                                        .add("Eine Schraube entnehmen","")
                                                        .add("An der vorderen Bohrung der linken Backe verschrauben", "")
                                                        .add("In der gegenüberliegenden Bohrung der linken Backe verschrauben", "")
                                                )
                                        )
                                )
                                .add(factory.createObjectBuilder()
                                        .add("instructionTitle", "Schritt3")
                                        .add("instructionViusalization", "./GIF_Schritt_3.gif")
                                        .add("instructionDescription", "Schritt 3")
                                        .add("instructionItems", factory.createArrayBuilder()
                                                .add(factory.createObjectBuilder()
                                                        .add("Eine Schraube entnehmen","")
                                                        .add("An der hinteren Bohrung der linken Backe ansetzen", "")
                                                        .add("In der gegenüberliegenden Bohrung der rechten Backe verschrauben", "")
                                                )
                                        )
                                )
                        )
                )
                .add(factory.createObjectBuilder()
                        .add("manualTitle", "Packanweisung Reisezahnbürste")
                        .add("manualInstructions", factory.createArrayBuilder()
                                .add(factory.createObjectBuilder()
                                        .add("instructionTitle", "Schritt1")
                                        .add("instructionVisualization", "./Bild_Schritt_1.jpg")
                                        .add("instructionDescription", "Schritt 1")
                                        .add("instructionItems", factory.createArrayBuilder()
                                                .add(factory.createObjectBuilder()
                                                        .add("Zahnbürste und Hülle entnehmen","")
                                                )
                                        )
                                )
                                .add(factory.createObjectBuilder()
                                        .add("instructionTitle", "Schritt2")
                                        .add("instructionVisualization", "./GIF_Schritt_2.gif")
                                        .add("instructionDescription", "Schritt 2")
                                        .add("instructionItems", factory.createArrayBuilder()
                                                .add(factory.createObjectBuilder()
                                                        .add("Zahnpasta entnehmen","")
                                                        .add("Mit roter Kappe Deckel der Hülle einlegen","")
                                                        .add("Hülle zusammenschieben und verschließen","")
                                                )
                                        )
                                )
                        )
                )
                .build();
        
        String return_array = array.toString();
        return return_array;
    }
}
