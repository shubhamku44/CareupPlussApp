package com.example.pc.careuppluss;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

import java.util.List;

public class Admin_Adapter extends RecyclerView.Adapter<Admin_Adapter.AdminviewHolder> {
        private Context mctx;//It provides access to things such as databases
        private List<Doctor> registerList;
        private static final String TAG = "AdminAdapter";
        DatabaseReference reference;

        public Admin_Adapter(Context mctx, List<Doctor> registerList) {
            this.mctx = mctx;
            this.registerList = registerList;
        }

        @NonNull
        @Override
        // Implementations should assume that individual item views will hold strong references to ViewHolder objects and that RecyclerView
        public AdminviewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            //LayoutInflater class is used to instantiate layout XML file into its corresponding View objects.
            LayoutInflater inflater=LayoutInflater.from(mctx);
            View view=inflater.inflate(android.R.layout.simple_selectable_list_,viewGroup,false);
            AdminviewHolder holder=new AdminviewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull final AdminviewHolder holder, int i) {


            final Doctor register=registerList.get(i);
            holder.t1.setText(register.getName());
            holder.t2.setText(register.getAdd());
            holder.t3.setText(register.getClinic());
            holder.t4.setText(register.getContact());
            holder.t5.setText(register.getSpecialist());
            holder.t6.setText(register.getMail());




        }


        @Override
        public int getItemCount() {
            return registerList.size();
        }

        class AdminviewHolder extends RecyclerView.ViewHolder
        {
            TextView t1,t2,t3,t4,t5,t6;
            EditText ed1;
            Button b1;
            public View clickedItemView;

            public AdminviewHolder(@NonNull final View itemView) {
                super(itemView);
                clickedItemView = itemView;
//            t1=itemView.findViewById(R.id.t1);
//            t2=itemView.findViewById(R.id.t2);
//            t3=itemView.findViewById(R.id.t3);
//            t4=itemView.findViewById(R.id.t4);
//            t5=itemView.findViewById(R.id.t5);
//            t6=itemView.findViewById(R.id.t6);



            }



        }
    }

