package aplikasi.mobile.cafeapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import aplikasi.mobile.cafeapp.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView banner, Register;
    private EditText edtUsername, edtEmail, edtPassword;
    private ProgressBar progressBar;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setTitle("Daftar");
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_register );

        mAuth = FirebaseAuth.getInstance();

        banner = (TextView) findViewById( R.id.CafeApp );
        banner.setOnClickListener( this );

        Register = (Button) findViewById( R.id.Register );
        Register.setOnClickListener( this );

        edtUsername = (EditText) findViewById( R.id.username_text );
        edtEmail = (EditText) findViewById( R.id.email_text );
        edtPassword = (EditText) findViewById( R.id.password_text );

        progressBar = (ProgressBar ) findViewById( R.id.progressBar );
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.CafeApp:
                startActivity( new Intent(this, LoginActivity.class) );
                break;
            case R.id.Register:
                Register();
                break;
        }
    }

    private void Register() {
        String username = edtUsername.getText().toString().trim();
        String email = edtEmail.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();

        if(username.isEmpty()) {
            edtUsername.setError( "Nama lengkap diperlukan!" );
            edtUsername.requestFocus();
            return;
        }

        if(email.isEmpty()) {
            edtEmail.setError( "Email diperlukan!" );
            edtEmail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher( email ).matches()) {
            edtEmail.setError( "Mohon masukkan email yang valid!" );
            edtEmail.requestFocus();
            return;
        }

        if(password.isEmpty()) {
            edtPassword.setError( "Password diperlukan!" );
            edtPassword.requestFocus();
            return;
        }

        if(password.length() < 6) {
            edtPassword.setError( "Panjang kata sandi minimal adalah 6 karakter!" );
            edtPassword.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword( email, password )
                .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()) {
                            User user = new User( username, email );

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child( FirebaseAuth.getInstance().getCurrentUser().getUid() )
                                    .setValue( user ).addOnCompleteListener( new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    if(task.isSuccessful()) {
                                        // redirect to login
                                        progressBar.setVisibility( View.VISIBLE );
                                        Toast.makeText( RegisterActivity.this, "Pengguna telah berhasil didaftarkan!", Toast.LENGTH_LONG).show();
                                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                        startActivity(intent);
                                    } else {
                                        Toast.makeText( RegisterActivity.this, "Gagal mendaftar! Coba lagi!", Toast.LENGTH_LONG).show();
                                    }
                                }
                            } );

                        } else {
                            Toast.makeText( RegisterActivity.this, "Email telah terdaftar! Coba lagi!", Toast.LENGTH_LONG).show();
                        }
                    }
                } );
    }
}