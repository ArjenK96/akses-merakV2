package kumpul.akses_merakv2.firebase;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import kumpul.akses_merakv2.R;
import kumpul.akses_merakv2.databaseobject.TriggerCheck;
import kumpul.akses_merakv2.adapter.MembersAdapter;
import kumpul.akses_merakv2.databaseobject.SpaceMember;

/**
 * Created by Arjen on 20-2-2017.
 */

public class FireBaseInstaller {
    private FirebaseDatabase FirebaseDatabase;
    private DatabaseReference DatabaseReference;
    private ChildEventListener ChildEventListener;
    private MembersAdapter membersAdapter;

    public FireBaseInstaller(Context context, ListView memberListView){
        FirebaseDatabase = FirebaseDatabase.getInstance();
        membersAdapter = new MembersAdapter(context, R.layout.memberlist_item, new ArrayList<SpaceMember>());

        memberListView.setAdapter(membersAdapter);
        initializeView();
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


    public void onClickTriggerCheckBtn(View v) {
        DatabaseReference = FirebaseDatabase.getReference().child("spaceMemberVisits").child("nx@0295922636");
        String spaceID = "nx@0295922636";
        String memberID = "nx@0295790783";
        TriggerCheck triggerCheck = new TriggerCheck(spaceID, memberID);
        DatabaseReference.child(memberID).push().setValue(triggerCheck);
    }
}
