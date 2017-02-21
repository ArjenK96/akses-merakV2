package kumpul.akses_merakv2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import java.util.ArrayList;
import java.util.Arrays;

import kumpul.akses_merakv2.MainActivity;
import kumpul.akses_merakv2.R;
import kumpul.akses_merakv2.adapter.MembersAdapter;
import kumpul.akses_merakv2.databaseobject.SpaceMember;

/**
 * Created by Arjen on 21-2-2017.
 */

public class SignInActivity extends AppCompatActivity {
    private com.google.firebase.auth.FirebaseAuth FirebaseAuth;
    private com.google.firebase.auth.FirebaseAuth.AuthStateListener AuthStatelistener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch_view);

        FirebaseAuth = FirebaseAuth.getInstance();

        AuthStatelistener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // login succesfull
                    startActivity(new Intent(SignInActivity.this, MainActivity.class));
                } else {
                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setIsSmartLockEnabled(false)
                                    .setProviders(Arrays.asList(new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build()))
                                    .build(),
                            1);
                }
            }
        };
    }

    @Override
    public void onPause() {
        super.onPause();
        if (AuthStatelistener != null) {
            FirebaseAuth.removeAuthStateListener(AuthStatelistener);
        }
    }

    @Override
    public void onResume(){
        super.onResume();
        FirebaseAuth.addAuthStateListener(AuthStatelistener);
    }
}
