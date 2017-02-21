package kumpul.akses_merakv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MemberCheckIn extends AppCompatActivity {

    private FirebaseDatabase FirebaseDatabase;
    private DatabaseReference DatabaseReference;
    private FirebaseAuth FirebaseAuth;
    private FirebaseAuth.AuthStateListener AuthStatelistener;

    private Button triggerCheckBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_check_in);

        FirebaseDatabase = FirebaseDatabase.getInstance();
        FirebaseAuth = FirebaseAuth.getInstance();

        DatabaseReference = FirebaseDatabase.getReference().child("spaceMemberVisits").child("nx@0295922636");
    }

//    triggerCheckBtn.setOnClickListener(new View.OnClickListener) {
//        @Override
//        public void onClick(View view) {
//            TriggerCheck triggerCheck = new TriggerCheck(name, ID);
//            DatabaseReference.child(ID).push().setValue(triggerCheck);
//
//        }
//    }

}
