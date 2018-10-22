package com.example.user.lolascupcakes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class memberHome extends AppCompatActivity {
    CardView addOrder;
    CardView viewCupcakes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_home);
        addOrder = (CardView) findViewById(R.id.placingOrder);
        viewCupcakes = (CardView) findViewById(R.id.viewcupcake);
        addOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddOrderpg();
            }
        });
        viewCupcakes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openviewcakepg();
            }
        });
    }

    private void openviewcakepg() {
        Intent intent = new Intent(this,viewCakeList.class);
        startActivity(intent);
    }

    private void openAddOrderpg() {
        Intent intent = new Intent(this,placingOrder.class);
        startActivity(intent);
    }
}
