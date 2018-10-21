package com.example.user.lolascupcakes;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.lolascupcakes.Controlers.DatabaseHelper;
import com.example.user.lolascupcakes.Controlers.DatePickerFragment;
import com.example.user.lolascupcakes.Models.Order;

import java.text.DateFormat;
import java.util.Calendar;

public class placingOrder extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    EditText type;
    EditText qty;
    TextView dateview;
    Button add_order;
    Button set_date;
    DatabaseHelper dbase;
    Order order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placing_order);
        type = (EditText) findViewById(R.id.type);
        qty = (EditText) findViewById(R.id.qty);
        dateview =(TextView) findViewById(R.id.tvdate);
        add_order =(Button) findViewById(R.id.btnaddOrder);
        set_date =(Button) findViewById(R.id.btnsetDate);
        dbase = new DatabaseHelper(this);
        order = new Order();
        set_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(),"date picker");
            }
        });
        add_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (type.getText().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Order Type is Empty", Toast.LENGTH_LONG).show();
                } else if (qty.getText().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Quantity is Empty", Toast.LENGTH_LONG).show(); }
                else if (dateview.getText().length() == 0) {
                    Toast.makeText(getApplicationContext(), "The date is required", Toast.LENGTH_LONG).show(); }

                else{
                    String tpe = type.getText().toString();
                    String qt = qty.getText().toString();
                    String date = dateview.getText().toString();
                    order.setType(tpe);
                    order.setQty(qt);
                    order.setDate(date);
                    dbase.createOrder(order);
                    Toast.makeText(getApplicationContext(), "Your Placing Order is Success", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR,year);
        c.set(Calendar.MONTH,month);
        c.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        String curDate = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
        dateview.setText(curDate);
    }
}
