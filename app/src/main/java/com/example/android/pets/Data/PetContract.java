package com.example.android.pets.Data;


import android.net.Uri;
import android.provider.BaseColumns;

public class PetContract {

    public static final String CONTENT_AUTHORITY = "com.example.android.pets";
    public static final String PATH_PETS = "pets";
    public static final String BASE_CONTENT_URI="content://"+CONTENT_AUTHORITY;


    private PetContract(){}

    public static final  class PetEntry implements BaseColumns{

        public static final Uri CONTENT_URI = Uri.withAppendedPath(Uri.parse(BASE_CONTENT_URI),PATH_PETS);

        public final static String TABLE_NAME="pets";

        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_PET_NAME="name";
        public final static String COLUMN_PET_BREED="breed";
        public final static String COLUMN_PET_GENDER="gender";
        public final static String COLUMN_PET_WEIGHT="weight";

        public final static int GENDER_UNKNOWN=0;
        public final static int GENDER_MALE=1;
        public final static int GENDER_FEMALE=2;



    }



}
