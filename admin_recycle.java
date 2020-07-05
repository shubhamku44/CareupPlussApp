package com.example.pc.careuppluss;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class admin_recycle extends AppCompatActivity {
    RecyclerView recyclerview;//RecyclerView in Android uses an adapter to represent the information we want to show as list
    Admin_Adapter adapter;
    List<Doctor> registerList;
    DatabaseReference databaseReference;//A Firebase reference represents a particular location in your Database and can be used for reading or writing data to that Database location.
    private static final String TAG = "admin_recycle";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_recycle);
        registerList=new ArrayList<>();
        adapter=new Admin_Adapter(this,registerList);
        recyclerview=findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(adapter);
        // The entry point for accessing a Firebase Database. You can get an instance by calling getInstance(). To access a location in the database and read or write data, use getReference()
        databaseReference= FirebaseDatabase.getInstance().getReference("Merchant");
        databaseReference.addListenerForSingleValueEvent(valueEventListener);
    }

    //Classes implementing this interface can be used to receive events about data changes at a location. Attach the listener to a location user addValueEventListener(ValueEventListener)
    ValueEventListener valueEventListener=new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            for (DataSnapshot snap : dataSnapshot.getChildren()) {
                Doctor register = snap.getValue(Doctor.class);
                registerList.add(register);
                Log.e(TAG, "onDataChange: "+ dataSnapshot.getChildren().iterator() );
            }
            adapter.notifyDataSetChanged();
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };
}

