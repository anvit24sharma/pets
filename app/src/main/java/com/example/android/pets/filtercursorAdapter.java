package com.example.android.pets;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.android.pets.Data.PetContract;

public class filtercursorAdapter  extends CursorAdapter{


    public filtercursorAdapter(Context context, Cursor c) {
        super(context, c,0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.list_item,viewGroup,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView name = (TextView) view.findViewById(R.id.pet_name);
        TextView breed = (TextView) view.findViewById(R.id.pet_breed);
        TextView gender = (TextView) view.findViewById(R.id.pet_gender);
        TextView weight = (TextView) view.findViewById(R.id.pet_weight);



        String pet_name =cursor.getString(cursor.getColumnIndexOrThrow(PetContract.PetEntry.COLUMN_PET_NAME));
        String pet_breed =cursor.getString(cursor.getColumnIndexOrThrow(PetContract.PetEntry.COLUMN_PET_BREED));
        String pet_gender =cursor.getString(cursor.getColumnIndexOrThrow(PetContract.PetEntry.COLUMN_PET_GENDER));
        int pet_weight =cursor.getInt(cursor.getColumnIndexOrThrow(PetContract.PetEntry.COLUMN_PET_WEIGHT));

        if (TextUtils.isEmpty(pet_breed)) {
            pet_breed = "Unknown Breed";
        }


        name.setText(pet_name);
        breed.setText(pet_breed);

        if(pet_gender.equals("0"))
            gender.setText("UNKNOWN");
        else
        if(pet_gender.equals("1"))
            gender.setText("MALE");
        else
        if(pet_gender.equals("2"))
            gender.setText("FEMALE");

        weight.setText(String.valueOf(pet_weight));
    }
}
