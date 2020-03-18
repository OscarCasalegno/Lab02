package it.polito.tdp.alien.model;

import java.util.Map;
import java.util.TreeMap;

public class Model {
    
    Map<String, String> dizionario= new TreeMap<>();
    
    public String traduzione(String aliena) {
        if (this.dizionario.containsKey(aliena)) {
            return this.dizionario.get(aliena) + "\n";
        }
        return "Parola non presente";
    }
    
    public String traduzione(String aliena, String umana) {
        this.dizionario.put(aliena,umana);
        return null;
    }
}
