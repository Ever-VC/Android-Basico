package com.example.proyecto001;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Instanciando los objetos (Hacinendo referencia a los elementos visuales)
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        tvResultado = findViewById(R.id.tvResultado);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void calcularSuma(View view) {
        // Capturando los valores ingresados por el usuario en los EditText
        String s1 = et1.getText().toString();
        String s2 = et2.getText().toString();

        // Validando que los campos no estén vacíos
        if (s1.isEmpty() || s2.isEmpty()) {
            Toast.makeText(this, "Por favor, ingrese los dos números", Toast.LENGTH_SHORT).show();
            return;
        }

        // Convirtiendo los valores de String a int
        int n1 = Integer.parseInt(s1);
        int n2 = Integer.parseInt(s2);

        // Realizando la suma
        int suma = n1 + n2;

        // Mostrando el resultado en el TextView
        tvResultado.setText("Resultado: " + suma);
    }
}