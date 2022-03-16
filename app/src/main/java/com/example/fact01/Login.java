package com.example.fact01;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    private EditText etClave, etUsuario;
    private CheckBox checkBox;
    Button btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnIngresar = (Button) findViewById(R.id.btnIngresar);
        etClave = (EditText) findViewById(R.id.etClave);
        etUsuario = (EditText) findViewById(R.id.etUsuario);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        verClave();
        btnIngresar.setOnClickListener(v -> {
            startActivity(new Intent(Login.this, MainActivity.class));
            finish();
        });
    }


    /*MOSTRAR CLAVE*/
    public void verClave() {
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // depende del estado que se encuentre el checlox para que funcione el metodo checked.
                if (!isChecked) {  //mostrar contrasenia
                    etClave.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else { // ocultar contrasenia
                    etClave.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });
    }

    /*se controla la pulsacion del boton atras y cierra la aplicacion*/
    @Override
    public void onBackPressed() {
        AlertDialog.Builder myBulid = new AlertDialog.Builder(this);
        myBulid.setMessage("¿Deseas salir de la aplicacion?");
        myBulid.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        myBulid.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog dialog = myBulid.create();
        dialog.show();
    }
}