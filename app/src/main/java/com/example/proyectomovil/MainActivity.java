package com.example.proyectomovil;
// En la rama de dev se trabajara
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    TextInputEditText edtUser;
    TextInputEditText edtPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtUser = findViewById(R.id.edtUser);
        edtPass = findViewById(R.id.edtPassword);
    }

    public String extractString(TextInputEditText edit){
        String valor = edit.getText().toString().trim();
        return valor;
    }
    public void getMessage(String m){
        Toast.makeText(this, m, Toast.LENGTH_SHORT).show();
    }

    public boolean logActive(String u,String p){
        if (u.equalsIgnoreCase("73589239") && p.equalsIgnoreCase("1234")){
            return true;
        }
        return false;
    }

    public void login(View v){
        String user = extractString(edtUser);
        String pass = extractString(edtPass);
        if (user.equals("") || pass.equals("")){
            getMessage("Complete los campos");
        }else{
            if (logActive(user,pass)){
                Intent intent = new Intent(MainActivity.this,Menu.class);
                startActivity(intent);
            }else{
                getMessage("Los datos son incorrectos");
            }
        }
    }
}