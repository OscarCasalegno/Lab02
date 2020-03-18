package it.polito.tdp.alien.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Model {

    Map<String, List<String>> dizionario = new TreeMap<>();

    public String traduzione(String stringa) {

        boolean puntoDiDomanda = false;
        for (char c : stringa.toCharArray()) {
            if (!Character.isAlphabetic(c) && !Character.isSpaceChar(c)) {
                if (c == '?') {
                    if (puntoDiDomanda) {
                        return "INSERISCI SOLO UN '?'\n";
                    }
                    c = '.';
                    puntoDiDomanda = true;
                }
                return "RIMUOVERE I CARATTERI NON ALFABETICI\n";
            }
            
        }

        StringTokenizer st = new StringTokenizer(stringa);
        String aliena = st.nextToken();
        String umana = null;
        try {
            umana = st.nextToken();
        } catch (Exception e) {

        }

        if (umana != null) {
            if (this.add(aliena, umana)) {
                return "Parola aggiunta\n";
            }
            return "Parola Duplicata\n";
        }

        if (this.dizionario.containsKey(aliena)) {
            return this.dizionario.get(aliena) + "\n";
        }

        return "Parola non presente";

    }

    public boolean add(String aliena, String umana) {
        if (!this.dizionario.containsKey(aliena)) {
            this.dizionario.put(aliena, new ArrayList<String>());
        }
        if (!this.dizionario.get(aliena).contains(umana)) {
            this.dizionario.get(aliena).add(umana);
            return true;
        }
        return false;
    }
}
