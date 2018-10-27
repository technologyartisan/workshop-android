package id.technologyartisan.workshopandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    protected Button btnLogin;
    protected TextView tvRegister;
    protected EditText etUsername,etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin=findViewById(R.id.btn_login);
        tvRegister=findViewById(R.id.tv_register);
        etUsername=findViewById(R.id.et_username);
        etPassword=findViewById(R.id.et_password);

        btnLogin.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login:
                startActivity(new Intent(this,MainActivity.class));
                break;
            case R.id.tv_register:
                break;
        }
    }
}
