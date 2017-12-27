package com.example.android.pets;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.android.pets.Data.PetContract;
import com.example.android.pets.Data.PetDbHelper;


public class filter extends AppCompatActivity{

    PetDbHelper mDbHelper;
    Cursor cursor;
    filtercursorAdapter mCursorAdapter;
    Bundle b1;
    int so;
    String gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filter);

         b1 = getIntent().getExtras();
         so = b1.getInt("sortorder");

        String[] projection={
                PetContract.PetEntry._ID,
                PetContract.PetEntry.COLUMN_PET_NAME,
                PetContract.PetEntry.COLUMN_PET_BREED,
                PetContract.PetEntry.COLUMN_PET_GENDER,
                PetContract.PetEntry.COLUMN_PET_WEIGHT
        };

        ListView petListView = (ListView) findViewById(R.id.lv1_item);


        mDbHelper = new PetDbHelper(filter.this);
        SQLiteDatabase database=mDbHelper.getReadableDatabase();

        if(so==1) {

            cursor = database.query(PetContract.PetEntry.TABLE_NAME, projection,
                    null, null, null, null, PetContract.PetEntry.COLUMN_PET_NAME);
        }
        else if(so==2) {

            cursor = database.query(PetContract.PetEntry.TABLE_NAME, projection,
                    null, null, null, null, PetContract.PetEntry.COLUMN_PET_NAME + " DESC");
        }
        else if(so==3) {

            cursor = database.query(PetContract.PetEntry.TABLE_NAME, projection,
                    null, null, null, null, PetContract.PetEntry.COLUMN_PET_BREED);
        }
        else if(so==4) {

            cursor = database.query(PetContract.PetEntry.TABLE_NAME, projection,
                    null, null, null, null, PetContract.PetEntry.COLUMN_PET_BREED + " DESC");
        }
        else if(so==5) {

            cursor = database.query(PetContract.PetEntry.TABLE_NAME, projection,
                    null, null, null, null, PetContract.PetEntry.COLUMN_PET_WEIGHT);
        }
        else if(so==6) {

            cursor = database.query(PetContract.PetEntry.TABLE_NAME, projection,
                    null, null, null, null, PetContract.PetEntry.COLUMN_PET_WEIGHT + " DESC");
        }
        //query with MALE Pets
        else if(so==11) {

            cursor = database.query(PetContract.PetEntry.TABLE_NAME, projection,
                    PetContract.PetEntry.COLUMN_PET_GENDER +"="+"1", null, null, null, PetContract.PetEntry.COLUMN_PET_NAME);
        }
        else if(so==21) {

            cursor = database.query(PetContract.PetEntry.TABLE_NAME, projection,
                    PetContract.PetEntry.COLUMN_PET_GENDER +"="+"1", null, null, null, PetContract.PetEntry.COLUMN_PET_NAME + " DESC");
        }
        else if(so==31) {

            cursor = database.query(PetContract.PetEntry.TABLE_NAME, projection,
                    PetContract.PetEntry.COLUMN_PET_GENDER +"="+"1", null, null, null, PetContract.PetEntry.COLUMN_PET_BREED);
        }
        else if(so==41) {

            cursor = database.query(PetContract.PetEntry.TABLE_NAME, projection,
                    PetContract.PetEntry.COLUMN_PET_GENDER +"="+"1", null, null, null, PetContract.PetEntry.COLUMN_PET_BREED + " DESC");
        }
        else if(so==51) {

            cursor = database.query(PetContract.PetEntry.TABLE_NAME, projection,
                    PetContract.PetEntry.COLUMN_PET_GENDER +"="+"1", null, null, null, PetContract.PetEntry.COLUMN_PET_WEIGHT);
        }
        else if(so==61) {

            cursor = database.query(PetContract.PetEntry.TABLE_NAME, projection,
                    PetContract.PetEntry.COLUMN_PET_GENDER +"="+"1", null, null, null, PetContract.PetEntry.COLUMN_PET_WEIGHT + " DESC");
        }
        //Query with Female Pets

        else if(so==12) {

            cursor = database.query(PetContract.PetEntry.TABLE_NAME, projection,
                    PetContract.PetEntry.COLUMN_PET_GENDER +"="+"2", null, null, null, PetContract.PetEntry.COLUMN_PET_NAME);
        }
        else if(so==22) {

            cursor = database.query(PetContract.PetEntry.TABLE_NAME, projection,
                    PetContract.PetEntry.COLUMN_PET_GENDER +"="+"2", null, null, null, PetContract.PetEntry.COLUMN_PET_NAME + " DESC");
        }
        else if(so==32) {

            cursor = database.query(PetContract.PetEntry.TABLE_NAME, projection,
                    PetContract.PetEntry.COLUMN_PET_GENDER +"="+"2", null, null, null, PetContract.PetEntry.COLUMN_PET_BREED);
        }
        else if(so==42) {

            cursor = database.query(PetContract.PetEntry.TABLE_NAME, projection,
                    PetContract.PetEntry.COLUMN_PET_GENDER +"="+"2", null, null, null, PetContract.PetEntry.COLUMN_PET_BREED + " DESC");
        }
        else if(so==52) {

            cursor = database.query(PetContract.PetEntry.TABLE_NAME, projection,
                    PetContract.PetEntry.COLUMN_PET_GENDER +"="+"2", null, null, null, PetContract.PetEntry.COLUMN_PET_WEIGHT);
        }
        else if(so==62) {

            cursor = database.query(PetContract.PetEntry.TABLE_NAME, projection,
                    PetContract.PetEntry.COLUMN_PET_GENDER +"="+"2", null, null, null, PetContract.PetEntry.COLUMN_PET_WEIGHT + " DESC");
        }
        else if(so==7) {

            cursor = database.query(PetContract.PetEntry.TABLE_NAME, projection,
                    PetContract.PetEntry.COLUMN_PET_GENDER +"="+"1", null, null, null, null);
        }
        else if(so==8) {

            cursor = database.query(PetContract.PetEntry.TABLE_NAME, projection,
                    PetContract.PetEntry.COLUMN_PET_GENDER +"="+"2", null, null, null, null);
        }




                mCursorAdapter = new filtercursorAdapter(filter.this,cursor);
                 petListView.setAdapter(mCursorAdapter);


    }



}