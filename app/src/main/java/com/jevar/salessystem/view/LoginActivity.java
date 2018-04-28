package com.jevar.salessystem.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.jevar.salessystem.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    /*-------------------------FIREBASE-------------------------*/
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;

    /*-----------------------LOGIN NORMAL-----------------------*/
    private EditText txtUser, txtPass;
    private Button btnLogin;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        /*-----------------------LOGIN NORMAL-----------------------*/
        txtUser = (EditText)findViewById(R.id.txtUserLogin);
        txtPass = (EditText)findViewById(R.id.txtPassLogin);
        btnLogin = (Button) findViewById(R.id.btnLogInLogin);

        btnLogin.setOnClickListener(this);

        /*-------------------------FIREBASE-------------------------*/
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    goMainScreen();
                }
            }
        };
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogInLogin:
                String gmail = txtUser.getText().toString();
                String pass = txtPass.getText().toString();
                /*Toast.makeText(getApplicationContext(), pass, Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), gmail, Toast.LENGTH_SHORT).show();*/

                startSession(gmail, pass);
                break;
        }
    }

    private void startSession(String gmail,String pass){
        FirebaseAuth.getInstance().signInWithEmailAndPassword(gmail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Log.i("SESSION","Usuario LOGUEADO correctamente");
                    goMainScreen();
                }else{
                    Log.i("SESSION",task.getException().getMessage()+"");
                }
            }
        });
    }

    private void goMainScreen() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
