package com.alayouni.applitest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etnom;
    private EditText etpass;
    private Button btenvoye;
    private Spinner spliste;
    private String choix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etnom= (EditText) findViewById(R.id.etlogin);
        etpass= (EditText) findViewById(R.id.etpass);
        btenvoye=(Button) findViewById(R.id.btenvoye);
        spliste = (Spinner) findViewById(R.id.spnouveau);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.nouveau, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spliste.setAdapter(adapter);

        spliste.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                choix = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(adapterView.getContext(), choix,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btenvoye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToResult();

            }
        });
    }
    private void ToResult()
    {
        Intent intent = new Intent(this,ResultActivity.class);
        intent.putExtra("nom",etnom.getText().toString());
        intent.putExtra("pass",etpass.getText().toString());
        intent.putExtra("choix",choix);
        startActivity(intent);
    }
}
