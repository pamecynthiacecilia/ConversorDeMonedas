package com.nombreempresa.pamelacynthia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

   private EditText dolares,euros;
   private RadioButton rbDolar,rbEuro;
   private Button conversor;
   private TextView resultado;
   private MainActivityViewModel objetoVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objetoVM= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        inicializarComponentes();

        objetoVM.getResultadoMutable().observe(this, new Observer<String>() {
            @Override
            //cuando haya cambios el metodo onChange lo mostrara
            public void onChanged(String s) {
                resultado.setText(s);
            }
        });

    }

    private void inicializarComponentes(){
            dolares=findViewById(R.id.etDolares);
            euros=findViewById(R.id.etEuros);
            resultado=findViewById(R.id.tvResultado);
            rbDolar=findViewById(R.id.rbDolar);
            rbEuro=findViewById(R.id.rbEuro);
            conversor= findViewById(R.id.btConvertir);
            conversor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    objetoVM.convertir(dolares.getText().toString(),euros.getText().toString(),rbEuro.isChecked());
                }
            });
        }
    }
