package kumpul.akses_merakv2;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase FirebaseDatabase;
    private DatabaseReference DatabaseReference;
    private FirebaseAuth FirebaseAuth;
    private FirebaseAuth.AuthStateListener AuthStatelistener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseDatabase = FirebaseDatabase.getInstance();
        FirebaseAuth = FirebaseAuth.getInstance();

        AuthStatelistener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null){
                    // logged in
                } else {
//                    startActivityForResult(
//                            AuthUI.getInstance()
//                                    .createSignInIntentBuilder()
//                                    .setIsSmartLockEnabled(false)
//                                    .setProviders(Arrays.asList(new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build()))
//                                    .build(),
//                            1);
                }
            }
        };
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (AuthStatelistener != null) {
            FirebaseAuth.removeAuthStateListener(AuthStatelistener);
        }
    }

    @Override
    protected void onResume(){
        super.onResume();
        FirebaseAuth.addAuthStateListener(AuthStatelistener);
    }
}
