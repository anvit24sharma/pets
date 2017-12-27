package com.example.android.pets.Data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

public class PetProvider extends ContentProvider {


    private PetDbHelper mDbHelper;
    private static final int PETS = 100;
    private static final int PETS_ID=101;
   // Intent intent;


    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        sUriMatcher.addURI(PetContract.CONTENT_AUTHORITY,PetContract.PATH_PETS,PETS);
        sUriMatcher.addURI(PetContract.CONTENT_AUTHORITY,PetContract.PATH_PETS+ "/#",PETS_ID);
    }


    @Override
    public boolean onCreate() {
        mDbHelper = new PetDbHelper(getContext());


        return true;
    }

    @Nullable
    @Override
    public  Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionargs, @Nullable String sortorder) {
        SQLiteDatabase database=mDbHelper.getReadableDatabase();

        Cursor cursor;

        int match =sUriMatcher.match(uri);

        switch (match){
            case PETS:

                cursor=database.query(PetContract.PetEntry.TABLE_NAME,projection,selection,selectionargs,null,null,sortorder);
                break;

            case PETS_ID:
                selection = PetContract.PetEntry._ID + "=?";
                selectionargs = new String[]{
                        String.valueOf(ContentUris.parseId(uri))
                };
                cursor = database.query(PetContract.PetEntry.TABLE_NAME,projection,selection,selectionargs,null,null,sortorder);
                break;
            default:
                throw  new IllegalArgumentException("Cannot query unknown URI "+ uri);

        }


        cursor.setNotificationUri(getContext().getContentResolver(),uri);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
     final int match = sUriMatcher.match(uri);
        switch(match){
            case PETS:
                return insertPet(uri,contentValues);
            default:
                throw new IllegalArgumentException("Insertion is not supported");
        }

    }
    private Uri insertPet(Uri uri ,ContentValues values){
        SQLiteDatabase database=mDbHelper.getWritableDatabase();


        long id=database.insert(PetContract.PetEntry.TABLE_NAME,null,values);
        if (id == -1) {
            Log.v("CatalogActivity","Failed To Insert New pet "+uri);
            return null;
        }
        getContext().getContentResolver().notifyChange(uri,null);
        return ContentUris.withAppendedId(uri,id);
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        final int match = sUriMatcher.match(uri);
        switch (match) {
            case PETS:
                return deletePet(uri,selection,selectionArgs);
            case PETS_ID:

                selection = PetContract.PetEntry._ID + "=?";
                selectionArgs = new String[] { String.valueOf(ContentUris.parseId(uri)) };
                return deletePet(uri, selection, selectionArgs);
            default:
                throw new IllegalArgumentException("Update is not supported for " + uri);
        }
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String selection, @Nullable String[] selectionArgs) {

        final int match = sUriMatcher.match(uri);
        switch (match) {
            case PETS:
                return updatePet(uri, contentValues, selection, selectionArgs);
            case PETS_ID:

                selection = PetContract.PetEntry._ID + "=?";
                selectionArgs = new String[] { String.valueOf(ContentUris.parseId(uri)) };
                return updatePet(uri, contentValues, selection, selectionArgs);
            default:
                throw new IllegalArgumentException("Delete is not supported for " + uri);
        }
    }


    private int updatePet(Uri uri, ContentValues values, String selection, String[] selectionArgs) {

        if (values.size() == 0) {
            return 0;
        }

        // Otherwise, get writeable database to update the data
        SQLiteDatabase database = mDbHelper.getWritableDatabase();

        // Returns the number of database rows affected by the update statement
       int rowupdateId= database.update(PetContract.PetEntry.TABLE_NAME, values, selection, selectionArgs);
        getContext().getContentResolver().notifyChange(uri,null);
        return rowupdateId;
    }
    private int deletePet(Uri uri, String selection, String[] selectionArgs) {

        SQLiteDatabase database = mDbHelper.getWritableDatabase();
        int rowdeleteId= database.delete(PetContract.PetEntry.TABLE_NAME,selection, selectionArgs);
        getContext().getContentResolver().notifyChange(uri,null);
        return rowdeleteId;

    }

    }
