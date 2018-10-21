package com.example.user.lolascupcakes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.lolascupcakes.Controlers.DatabaseHelper;
import com.example.user.lolascupcakes.Models.Cupcakes;
import com.example.user.lolascupcakes.Models.User;

public class addCupCakes extends AppCompatActivity {
    EditText cakename;
    EditText ocation;

    EditText price;
    EditText offer;
    EditText descrip;
    Button addcake;
    Cupcakes cupcakes;


    DatabaseHelper dbase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cup_cakes);
        cakename = (EditText) findViewById(R.id.cake_name);
        ocation = (EditText) findViewById(R.id.ocation);

        price = (EditText) findViewById(R.id.Price);
        descrip = (EditText) findViewById(R.id.desription);
        offer = (EditText) findViewById(R.id.offer);
        addcake = (Button) findViewById(R.id.btnAddcake);


        dbase = new DatabaseHelper(this);
        cupcakes = new Cupcakes();
        addcake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = price.getText().toString().trim();
                if (cakename.getText().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Cupcake Name is Empty", Toast.LENGTH_LONG).show();
                } else if (price.getText().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Price is not added", Toast.LENGTH_LONG).show();
                }
                else if (!pricevalidate(value)) {
                    Toast.makeText(getApplicationContext(), "Not Valid Price", Toast.LENGTH_LONG).show();
                }
                else{
                    String cupname = cakename.getText().toString();
                    String ocaton = ocation.getText().toString();
                    String pric = value;
                    String ofer = offer.getText().toString();
                    String desc = descrip.getText().toString();

                    cupcakes.setName(cupname);
                    cupcakes.setPrice(pric);
                    cupcakes.setOcation(ocaton);
                    cupcakes.setOffer(ofer);
                    cupcakes.setDescription(desc);

                    dbase.createCupcakes(cupcakes);
                    Toast.makeText(getApplicationContext(), "Successfully added", Toast.LENGTH_LONG).show();

                }
            }
        });


    }




    public boolean pricevalidate(String str){ //to check the price
        //String testString = "1.2345";
        double result;
        try {
            result = Double.parseDouble(str);
            return true;
        }
        catch (NumberFormatException nfe) {
             return false;
        }
    }
}
