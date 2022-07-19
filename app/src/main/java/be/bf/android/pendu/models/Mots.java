package be.bf.android.pendu.models;

import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

import be.bf.android.pendu.MainActivity;

public class Mots {
    private static String[] mots;


    public void initialiserMots() {
        mots = new String[]{"tenue", "gamba", "enjeu", "natif", "liens", "motos", "bonus", "aveux", "match", "assez"};
    }

    public String chercherNouveauMot() {
        Random rand = new Random();
        int nrMots = mots.length;
        int index = rand.nextInt(nrMots);
        return mots[index].toUpperCase();
    }
}
