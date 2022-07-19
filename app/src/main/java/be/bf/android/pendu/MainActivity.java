package be.bf.android.pendu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.ParcelUuid;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;

import be.bf.android.pendu.models.Mots;

public class MainActivity extends AppCompatActivity {
    public Mots mots = new Mots();
    public TextView lettre1, lettre2, lettre3, lettre4, lettre5;
    public EditText lettreDevine;
    public Button bouton;
    public String mot;
    public TextView message;
    public int lettersLeft = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lettre1 = findViewById(R.id.lettre_1);
        lettre2 = findViewById(R.id.lettre_2);
        lettre3 = findViewById(R.id.lettre_3);
        lettre4 = findViewById(R.id.lettre_4);
        lettre5 = findViewById(R.id.lettre_5);
        lettreDevine = findViewById(R.id.lettreDevine);
        bouton = findViewById(R.id.button);
        message = findViewById(R.id.message);

        bouton.setOnClickListener(this::deviner);

        mots.initialiserMots();
        chercherNouveauMot();
    }

    public void chercherNouveauMot(){
        mot = mots.chercherNouveauMot();
        message.setText("");
        lettreDevine.requestFocus();
    }

    public void deviner(View view) {
        boolean guessed = false;
        if (mot.charAt(0) == (lettreDevine.getText().toString().charAt(0))) {
            lettre1.setText(mot.substring(0 ,1));
            guessed = true;
        }
        if (mot.charAt(1) == (lettreDevine.getText().toString().charAt(0))) {
            lettre2.setText(mot.substring(1 ,2));
            guessed = true;
        }
        if (mot.charAt(2) == (lettreDevine.getText().toString().charAt(0))) {
            lettre3.setText(mot.substring(2 ,3));
            guessed = true;
        }
        if (mot.charAt(3) == (lettreDevine.getText().toString().charAt(0))) {
            lettre4.setText(mot.substring(3 ,4));
            guessed = true;
        }
        if (mot.charAt(4) == (lettreDevine.getText().toString().charAt(0))) {
            lettre5.setText(mot.substring(4 ,5));
            guessed = true;
        }

        if (!guessed) {
            if (message.getText().toString().contains(lettreDevine.getText().toString())) {
                Toast.makeText(getApplicationContext(), "Lettre déjà choisie !",
                        Toast.LENGTH_LONG).show();
            } else {
                message.setText(message.getText() + lettreDevine.getText().toString());
            }
        }

        if (guessed) {
            lettersLeft--;
        }

        if (lettersLeft == 0) {
            message.setText("Félicitations !\nVous avez trouvé le mot !");
            lettreDevine.setEnabled(false);
            bouton.setEnabled(false);
        } else {
            lettreDevine.setText("");
            lettreDevine.hasFocus();
        }
    }
}