package it.polito.tdp.alien.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Model {
    
    Map<String, List<String>> dizionario= new TreeMap<>();
    
    public String traduzione(String aliena) {
        if (this.dizionario.containsKey(aliena)) {
            return this.dizionario.get(aliena) + "\n";
        }
        return "Parola non presente";
    }
    
    public String traduzione(String aliena, String umana) {
        if (!this.dizionario.containsKey(aliena)) {
            this.dizionario.put(aliena, new ArrayList<String>());
        }
        this.dizionario.get(aliena).add(umana);
        return null;
    }
}
