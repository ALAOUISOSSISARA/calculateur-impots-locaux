package com.example.calculateurdimptslocaux;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Déclaration des éléments de l'interface
    private EditText surfaceInput, piecesInput;
    private CheckBox piscineCheckbox;
    private TextView resultView;
    private Button calculButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Liaison XML <-> Java
        surfaceInput = findViewById(R.id.input_surface);
        piecesInput = findViewById(R.id.input_pieces);
        piscineCheckbox = findViewById(R.id.checkbox_piscine);
        resultView = findViewById(R.id.result);
        calculButton = findViewById(R.id.button_calcul);

        // Écouteur du bouton "Calculer"
        calculButton.setOnClickListener(v -> calculer());
    }

    private void calculer() {

        // Vérification champs vides
        if (surfaceInput.getText().toString().isEmpty() ||
                piecesInput.getText().toString().isEmpty()) {

            Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
            return;
        }

        // Lecture des valeurs saisies
        double surface = Double.parseDouble(surfaceInput.getText().toString());
        int pieces = Integer.parseInt(piecesInput.getText().toString());
        boolean piscine = piscineCheckbox.isChecked();

        // Calcul des impôts
        double impotBase = surface * 2;
        double supplement = pieces * 50 + (piscine ? 100 : 0);
        double total = impotBase + supplement;

        // Affichage du résultat
        resultView.setText("Impôt total : " + total + " DH");
    }
}