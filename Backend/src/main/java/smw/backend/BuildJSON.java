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
 * Generiert eine JSON die über den REST Websvice zur Verfügung gestellt wird
 * Generierung ist noch nicht dynamisch, da es sich noch um einen Prototyp handelt
 * In Zukunft soll die JSON aus einer Datenbank an Items generiert werden
 * @author giesler
 * Datum: 05.07.2019
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
                                        .add("instructionVisualization", "schraubzwinge/1.jpg")
                                        .add("instructionDescription", "Zwei Stahl Backen entnehmen \n"
                                                + "Gegenüberliegend platzieren")
                                        .add("instructionItems",  factory.createArrayBuilder()
                                                .add("Stahlbacken")
                                        )
                                        
                                )
                                .add(factory.createObjectBuilder()
                                        .add("instructionTitle", "Schritt2")
                                        .add("instructionVisualization", "schraubzwinge/2.gif")
                                        .add("instructionDescription", "Eine Schraube entnehmen \n"
                                                + "An der vorderen Bohrung der linken Backe verschrauben \n"
                                                + "In der gegenüberliegenden Bohrung der linken Backe verschrauben")
                                        .add("instructionItems", factory.createArrayBuilder()
                                                .add("Schraube")
                                        )
                                )
                                .add(factory.createObjectBuilder()
                                        .add("instructionTitle", "Schritt3")
                                        .add("instructionVisualization", "schraubzwinge/3.gif")
                                        .add("instructionDescription", "Eine Schraube entnehmen \n"
                                                + "An der hinteren Bohrung der linken Backe ansetzen \n"
                                                + "In der gegenüberliegenden Bohrung der rechten Backe verschrauben")
                                        .add("instructionItems", factory.createArrayBuilder()
                                                .add("Schraube")
                                        )
                                )
                        )
                )
                .add(factory.createObjectBuilder()
                        .add("manualTitle", "Rollbrett")
                        .add("manualInstructions", factory.createArrayBuilder()
                                .add(factory.createObjectBuilder()
                                        .add("instructionTitle", "Schritt1")
                                        .add("instructionVisualization", "rollbrett/1.jpg")
                                        .add("instructionDescription", "Kanten schleifen")
                                        .add("instructionItems", factory.createArrayBuilder()
                                                .add("Holzbrett")
                                        )
                                )
                                .add(factory.createObjectBuilder()
                                        .add("instructionTitle", "Schritt2")
                                        .add("instructionVisualization", "rollbrett/2.jpg")
                                        .add("instructionDescription", "4 Rollen und Halterungen entnehmen")
                                        .add("instructionItems", factory.createArrayBuilder()
                                                .add("Rollen")
                                                .add("Halterungen")
                                        )
                                )
                                .add(factory.createObjectBuilder()
                                        .add("instructionTitle", "Schritt3")
                                        .add("instructionVisualization", "rollbrett/3.jpg")
                                        .add("instructionDescription", "Schrauben entnehmen, anschließend Rollen und Halterungen auf dem Brett verschrauben")
                                        .add("instructionItems", factory.createArrayBuilder()
                                                .add("Schrauben")
                                        )
                                )                                
                        )
                )
                .build();
        
        String return_array = array.toString();
        return return_array;
    }
}
