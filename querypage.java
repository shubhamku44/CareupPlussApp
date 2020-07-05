package com.example.pc.careuppluss;

import android.annotation.SuppressLint;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class querypage extends AppCompatActivity {
    Button ask;
    Button next;
    RecyclerView recyclerView;
    Admin_Adapter adapter;
    List<Doctor> registerList;

    EditText queryEditText;
    private Query searchQuery;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_querypage);

        ask = (Button) findViewById(R.id.ask);
        next = (Button) findViewById(R.id.next);

        registerList=new ArrayList<>();
        recyclerView=findViewById(R.id.doctorList);
        recyclerView.setLayoutManager(new LinearLayoutManager(querypage.this));
        adapter = new Admin_Adapter(querypage.this,registerList);
        queryEditText = findViewById(R.id.txt1);
        ask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchQueryString = queryEditText.getText().toString().trim();
                searchQuery = FirebaseDatabase.getInstance().getReference().child("Doctor").orderByChild("specialist").equalTo(searchQueryString);
                searchQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            registerList.clear();
                            for (DataSnapshot data : dataSnapshot.getChildren()) {
                                Doctor doctorDetails = data.getValue(Doctor.class);
                                registerList.add(doctorDetails);
                                adapter.notifyDataSetChanged();
                            }
                            recyclerView.setAdapter(adapter);

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(querypage.this, finalpage.class));
            }
        });
    }
}