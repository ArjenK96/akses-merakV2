package kumpul.akses_merakv2.firebase;

import android.content.Context;
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

import kumpul.akses_merakv2.R;
import kumpul.akses_merakv2.SubActivity;
import kumpul.akses_merakv2.adapter.MembersAdapter;
import kumpul.akses_merakv2.databaseobject.SpaceMember;

/**
 * Created by Arjen on 20-2-2017.
 */

public class FireBaseInstaller extends SubActivity {
    private com.google.firebase.database.FirebaseDatabase FirebaseDatabase;
    private com.google.firebase.database.DatabaseReference DatabaseReference;
    private com.google.firebase.database.ChildEventListener ChildEventListener;
    private MembersAdapter membersAdapter;
    private Context context;

    public void create(Context context){
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle   savedInstanceState) {
        View view =  inflater.inflate(R.layout.activity_main, container, false);
        FirebaseDatabase = FirebaseDatabase.getInstance();
        membersAdapter = new MembersAdapter(context, R.layout.memberlist_item, new ArrayList<SpaceMember>());

        ListView memberListView = (ListView) view.findViewById(R.id.memberListView);
        memberListView.setAdapter(membersAdapter);
        initializeView();
        return view;
    }

    private void initializeView(){
        DatabaseReference = FirebaseDatabase.getReference().child("spaceMembers").child("nx@0295922636");

        if (ChildEventListener == null) {
            ChildEventListener = new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    Log.d("INITIALIZEVIEW", dataSnapshot.toString());
                    SpaceMember spaceMember = dataSnapshot.getValue(SpaceMember.class);
                    Log.d("SPACEMEMBER", spaceMember.getName() + " " + spaceMember.getEmail());
                    membersAdapter.add(spaceMember);
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            };
            DatabaseReference.addChildEventListener(ChildEventListener);
        }
    }
}
