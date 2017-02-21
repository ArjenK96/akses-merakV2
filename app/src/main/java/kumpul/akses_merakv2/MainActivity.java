package kumpul.akses_merakv2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {
    List<SubActivity> subActivities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        subActivities.add(new FireBaseInstaller());

        install();
    }

    public void onClickStartBtn(View v) {
        Intent intent = new Intent(this, MemberlistActivity.class);
        startActivity(intent);
        finish();
    }

    public void onClickTriggerCheckBtn(View v) {
        DatabaseReference = FirebaseDatabase.getReference().child("spaceMemberVisits").child("nx@0295922636");
        String spaceID = "nx@0295922636";
        String memberID = "nx@0295790783";
        TriggerCheck triggerCheck = new TriggerCheck(spaceID, memberID);
        DatabaseReference.child(memberID).push().setValue(triggerCheck);

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (AuthStatelistener != null) {
            FirebaseAuth.removeAuthStateListener(AuthStatelistener);
        }
    }
}

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.view.menu.SubMenuBuilder;
import android.util.Log;
import android.widget.ListView;
import android.view.View;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;
import java.util.List;

import kumpul.akses_merakv2.adapter.MembersAdapter;
import kumpul.akses_merakv2.databaseobject.SpaceMember;
import kumpul.akses_merakv2.firebase.FireBaseInstaller;

    private void install(){
        for (SubActivity sub : subActivities){
            sub.create(this);
    public void onClickStartBtn(View v) {
        Intent intent = new Intent(this, MemberlistActivity.class);
        startActivity(intent);
        finish();
    }

    public void onClickTriggerCheckBtn(View v) {
        DatabaseReference = FirebaseDatabase.getReference().child("spaceMemberVisits").child("nx@0295922636");
        String spaceID = "nx@0295922636";
        String memberID = "nx@0295790783";
        TriggerCheck triggerCheck = new TriggerCheck(spaceID, memberID);
        DatabaseReference.child(memberID).push().setValue(triggerCheck);

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (AuthStatelistener != null) {
            FirebaseAuth.removeAuthStateListener(AuthStatelistener);