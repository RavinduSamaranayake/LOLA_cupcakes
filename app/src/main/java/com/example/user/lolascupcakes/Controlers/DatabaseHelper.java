package com.example.user.lolascupcakes.Controlers;




import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.user.lolascupcakes.Models.Cupcakes;
import com.example.user.lolascupcakes.Models.Order;
import com.example.user.lolascupcakes.Models.User;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Logcat tag
    private static final String LOG = DatabaseHelper.class.getName();

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "LOLAcupcake";

    // Table Names
    private static final String TABLE_USER = "user"; //todos
    private static final String TABLE_CUPCAKE ="cupcakes"; //"tags";
    private static final String TABLE_ORDER ="orders"; // "todo_tags";

    // Common column names
    private static final String KEY_ID = "id";
   // private static final String KEY_CREATED_AT = "created_at";

    // USER Table - column nmaes
    private static final String KEY_EMAIL = "email";
    private static final String KEY_FNAME = "fname";
    private static final String KEY_LNAME = "lname";
    private static final String KEY_PASWD = "password";
    private static final String KEY_LEVELID = "userlevel";

    // cupcakes Table - column names
    private static final String KEY_NAME = "name";
    private static final String KEY_OCATION = "ocation";
    private static final String KEY_PRICE = "price";
    private static final String KEY_OFFER = "offer";
    private static final String KEY_DES = "description";

    // ORDER Table - column names
    private static final String KEY_TYPE = "type";
    private static final String KEY_DATE = "date";

    // Table Create Statements
    // user table create statement
    private static final String CREATE_TABLE_USER = "CREATE TABLE "
            + TABLE_USER + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_EMAIL
            + " TEXT UNIQUE," + KEY_FNAME + " TEXT," + KEY_LNAME + " TEXT,"+ KEY_PASWD + " TEXT,"+ KEY_LEVELID
            + " INTEGER" + ")";

    // cupcake table create statement
    private static final String CREATE_TABLE_CUPCAKE = "CREATE TABLE "
            + TABLE_CUPCAKE + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME
            + " TEXT UNIQUE," + KEY_OCATION + " TEXT," + KEY_PRICE + " TEXT,"+ KEY_OFFER + " TEXT,"+ KEY_DES
            + " TEXT" + ")";
    // orders table create statement
    private static final String CREATE_TABLE_ORDER = "CREATE TABLE "
            + TABLE_ORDER + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_TYPE
            + " TEXT," + KEY_DATE + " DATE" + ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating required tables
        db.execSQL(CREATE_TABLE_USER);
        db.execSQL(CREATE_TABLE_CUPCAKE);
        db.execSQL(CREATE_TABLE_ORDER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CUPCAKE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ORDER);

        // create new tables
        onCreate(db);
    }

    // ------------------------ "USER" table methods ----------------//

    /**
     * Creating a user
     */
    public void createUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_EMAIL, user.getEmail());
        values.put(KEY_FNAME, user.getFname());
        values.put(KEY_LNAME, user.getLname());
        values.put(KEY_PASWD, user.getPasswrd());
        values.put(KEY_LEVELID, user.getLevelid());

        // insert row
        db.insert(TABLE_USER, null, values);




    }
    public void createCupcakes(Cupcakes cupcakes) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, cupcakes.getName());
        values.put(KEY_OCATION, cupcakes.getOcation());
        values.put(KEY_PRICE, cupcakes.getPrice());
        values.put(KEY_OFFER, cupcakes.getOffer());
        values.put(KEY_DES, cupcakes.getDescription());
        // insert row
        db.insert(TABLE_CUPCAKE, null, values);




    }
    public void createOrder(Order order) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TYPE, order.getType());
        values.put(KEY_DATE, order.getDate());

        // insert row
        db.insert(TABLE_ORDER, null, values);




    }



}