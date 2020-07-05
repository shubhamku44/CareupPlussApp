package com.example.pc.careuppluss;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class signup2 extends AppCompatActivity {

    EditText txtname,txtpass,txtadd,txtclinic,txtcontact,txtspecialist,txtmail;
    Button btnsignup2;
    FirebaseAuth mAuth;
    DatabaseReference userDBRef = FirebaseDatabase.getInstance().getReference().child("user");
    String name;
    String pass;
    String mail;
    String contact;
    String add;
    String specialist;
    String clinic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2);
        btnsignup2=findViewById(R.id.btnsignup2);
        txtname=findViewById(R.id.txtname);
        txtpass=findViewById(R.id.txtpass);
        txtmail=findViewById(R.id.txtmail);
        txtcontact=findViewById(R.id.txtcontact);
        txtadd=findViewById(R.id.txtadd);
        txtspecialist=findViewById(R.id.txtspecialist);
        txtclinic=findViewById(R.id.txtclinic);

        btnsignup2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateAccount();
                Intent i1=new Intent(getApplicationContext(),welcome.class);
                startActivity(i1);

            }
        });


    }

    private void CreateAccount()
    {
        final String name = txtname.getText().toString();
        final String pass = txtpass.getText().toString();
        final String mail = txtmail.getText().toString();
        final String contact = txtcontact.getText().toString();
        final String clinic= txtclinic.getText().toString();
        final String specialist = txtspecialist.getText().toString();
        final String add = txtadd.getText().toString();


        final  DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();
        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (!(dataSnapshot.child("Doctor").child(contact).exists()))
                {
                    HashMap<String,Object> userdataMap=new HashMap<>();
                    userdataMap.put("name",name);
                    userdataMap.put("pass",pass);
                    userdataMap.put("mail",mail);
                    userdataMap.put("contact",contact);
                    userdataMap.put("add",add);
                    userdataMap.put("clinic",clinic);
                    userdataMap.put("specialist",specialist);


                    RootRef.child("Doctor").child(contact).updateChildren(userdataMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful())
                            {
                                Toast.makeText(getApplicationContext(),"Congratulations you are Registerd !!!!", Toast.LENGTH_SHORT).show();

                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(),"Please register correctly!!!!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }



        });



    }
}
