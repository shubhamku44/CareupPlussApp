package com.example.pc.careuppluss;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;


public class finalpage extends AppCompatActivity implements
            NavigationView.OnNavigationItemSelectedListener {
        Button btnnext;
        Button btnheart,btnskin,btnkidney,btnliver,btncancer,btneyes;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_finalpage);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            btnnext = (Button) findViewById(R.id.btnnext);
            btnheart = (Button) findViewById(R.id.btnheart);
            btnkidney = (Button) findViewById(R.id.btnkidney);
            btnliver = (Button) findViewById(R.id.btnliver);
            btncancer = (Button) findViewById(R.id.btncancer);
            btneyes = (Button) findViewById(R.id.btneyes);
            btnskin = (Button) findViewById(R.id.btnskin);
            btnnext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(finalpage.this, discription.class);
                    startActivity(intent);
                }
            });
            btnheart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(finalpage.this, querypage.class);
                    startActivity(intent);
                }
            });


            btnkidney.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(finalpage.this, querypage.class);
                    startActivity(intent);
                }
            });


            btnliver.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(finalpage.this, querypage.class);
                    startActivity(intent);
                }
            });


            btncancer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(finalpage.this, querypage.class);
                    startActivity(intent);
                }
            });


            btneyes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(finalpage.this, querypage.class);
                    startActivity(intent);
                }
            });


            btnskin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(finalpage.this,querypage.class);
                    startActivity(intent);
                }
            });




            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);
            toggle.syncState();

            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);


        }
        @Override
        public void onBackPressed() {
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.activity_finalpage_drawer, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            if (id == R.id.action_rating) {
                Intent intent=new Intent(finalpage.this,rateus.class);
                startActivity(intent);
                return true;
            }
            if (id == R.id.action_notify) {
                Intent intent=new Intent(finalpage.this,notification.class);
                startActivity(intent);
                return true;
            }

            return super.onOptionsItemSelected(item);
        }

        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            // Handle navigation view item clicks here.
            int id = item.getItemId();

            if (id == R.id.nav_profile) {
                Intent intent=new Intent(finalpage.this,profile.class);
                startActivity(intent);
            } else if (id == R.id.nav_help) {
                Intent intent=new Intent(finalpage.this,helps.class);
                startActivity(intent);
            } else if (id == R.id.nav_TandC) {
                Intent intent=new Intent(finalpage.this,tand_c.class);
                startActivity(intent);
                startActivity(intent);
            } else if (id == R.id.nav_invite) {
                if (id == R.id.nav_invite) {
                    Intent  intent=new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    String sharebody="CareupPlus";
                    String sharesubject="CareupPlus";
                    intent.putExtra(Intent.EXTRA_SUBJECT,sharebody);
                    intent.putExtra(Intent.EXTRA_SUBJECT,sharesubject);
                    startActivity(Intent.createChooser(intent,"Share using"));
                    return true;
                }

            } else if (id == R.id.nav_logout) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(finalpage.this, welcome.class));
                finalpage.this.finish();
            }

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
    }
