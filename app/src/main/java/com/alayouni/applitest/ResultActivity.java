package com.alayouni.applitest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
private TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvResult = (TextView) findViewById(R.id.tvResult);

        Intent intent = getIntent();
        String monRecap= "Bonjour" + intent.getStringExtra("nom");
        monRecap += "Votre mot de passe : " + intent.getStringExtra("pass");
        monRecap+="\nFormation : "+intent.getStringExtra("choix");

        tvResult.setText(monRecap);
    }


}