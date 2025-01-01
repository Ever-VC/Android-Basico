package com.example.proyecto001;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
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
    private RadioButton rbtnSuma, rbtnResta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Instanciando los objetos (Hacinendo referencia a los elementos visuales)
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        tvResultado = findViewById(R.id.tvResultado);
        rbtnSuma = findViewById(R.id.rbtnSuma);
        rbtnResta = findViewById(R.id.rbtnResta);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void calcular(View view) {
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

        // Variable que almacenará el resultado de la suma
        int resultado = 0;

        // Validando si el RadioButton de la suma está seleccionado o no
        if (rbtnSuma.isChecked()) {
            sumar(n1, n2); // Llamando al método sumar
        } else if (rbtnResta.isChecked()) {
            restar(n1, n2); // Llamando al método restar
        } else {
            Toast.makeText(this, "Por favor, seleccione una operación", Toast.LENGTH_SHORT).show();
        }
    }

    private void sumar(int n1, int n2) {
        // Realizando la suma
        int suma = n1 + n2;

        // Mostrando el resultado en el TextView
        tvResultado.setText("El resultado es: " + suma);
    }

    private void restar(int n1, int n2) {
        // Realizando la resta
        int resta = n1 - n2;

        // Mostrando el resultado en el TextView
        tvResultado.setText("El resultado es: " + resta);
    }
}