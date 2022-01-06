package aplikasi.mobile.cafeapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import aplikasi.mobile.cafeapp.R;

public class ForgotPasswordActivity extends AppCompatActivity {

    private EditText emailEditText;
    private Button resetPasswordButton;
    private ProgressBar progressBar;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setTitle("Forgot Password");
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_forgot_password );

        emailEditText = (EditText ) findViewById( R.id.email_text );
        resetPasswordButton = (Button ) findViewById( R.id.reset_button );

        progressBar = (ProgressBar ) findViewById( R.id.progressBar );

        auth = FirebaseAuth.getInstance();

        resetPasswordButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetPassword();
            }
        } );
    }

    private void resetPassword() {
        String email = emailEditText.getText().toString().trim();

        if(email.isEmpty()) {
            emailEditText.setError( "Email diperlukan!" );
            emailEditText.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher( email ).matches()) {
            emailEditText.setError( "Harap berikan email yang valid!" );
            emailEditText.requestFocus();
            return;
        }

        auth.sendPasswordResetEmail( email ).addOnCompleteListener( new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if(task.isSuccessful()) {
                    progressBar.setVisibility( View.VISIBLE);
                    Toast.makeText( ForgotPasswordActivity.this, "Cek email anda untuk reset password!", Toast.LENGTH_LONG ).show();
                    Intent intent = new Intent(ForgotPasswordActivity.this, LoginActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText( ForgotPasswordActivity.this, "Email tidak terdaftar! Coba lagi!", Toast.LENGTH_LONG ).show();
                }
            }
        } );
    }
}