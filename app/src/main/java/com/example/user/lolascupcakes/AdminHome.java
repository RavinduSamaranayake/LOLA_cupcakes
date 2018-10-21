package com.example.user.lolascupcakes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

public class AdminHome extends AppCompatActivity {
    CardView addCake;
   // Button addpg;
   // Button modifypg;
  //  Button orderpg;
   // Button profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
       // addpg = (Button)findViewById(R.id.Addcake);
       // modifypg=(Button)findViewById(R.id.modifycake
        addCake = (CardView) findViewById(R.id.Addcake);


        addCake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddcakepg();
            }
        });


    }

    private void openAddcakepg() {
        Intent intent = new Intent(this,addCupCakes.class);
        startActivity(intent);
    }

}
