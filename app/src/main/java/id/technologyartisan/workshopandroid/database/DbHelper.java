package id.technologyartisan.workshopandroid.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import id.technologyartisan.workshopandroid.model.Contact;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="contact.sql";
    private static final int DATABASE_VERSION=2;
    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE="CREATE TABLE "+Contact.Entry.TABLE_NAME+" ( "+
                Contact.Entry._ID +" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                Contact.Entry.COLUMN_ID+" INTEGER,"+
                Contact.Entry.COLUMN_NAME+" TEXT,"+
                Contact.Entry.COLUMN_NUMBER+" TEXT,"+
                Contact.Entry.COLUMN_PICTURE+" TEXT );";
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String DROP_TABLE="DROP TABLE "+Contact.Entry.TABLE_NAME+";";
        sqLiteDatabase.execSQL(DROP_TABLE);
        onCreate(sqLiteDatabase);
    }

    public long insertContact(int id,String name,String number,String picture){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put(Contact.Entry.COLUMN_ID,id);
        contentValues.put(Contact.Entry.COLUMN_NAME,name);
        contentValues.put(Contact.Entry.COLUMN_NUMBER,number);
        contentValues.put(Contact.Entry.COLUMN_PICTURE,picture);

        long lastId=sqLiteDatabase.insert(Contact.Entry.TABLE_NAME,null,contentValues);

        return lastId;
    }

    public List<Contact> selectContact(){
        List<Contact> contacts=new ArrayList<>();

        SQLiteDatabase sqLiteDatabase=getReadableDatabase();

        Cursor cursor=sqLiteDatabase.query(Contact.Entry.TABLE_NAME,null,null,null,null,null,null);

        int count=cursor.getCount();

        if (count>0){
            cursor.moveToFirst();
            while (cursor.moveToNext()){
                int id=cursor.getInt(cursor.getColumnIndex(Contact.Entry.COLUMN_ID));
                String nama=cursor.getString(cursor.getColumnIndex(Contact.Entry.COLUMN_NAME));
                String number=cursor.getString(cursor.getColumnIndex(Contact.Entry.COLUMN_NUMBER));
                String picture=cursor.getString(cursor.getColumnIndex(Contact.Entry.COLUMN_PICTURE));

                Contact temp=new Contact(id,nama,number,picture);
                contacts.add(temp);
            }
        }

        cursor.close();
        sqLiteDatabase.close();

        return contacts;
    }

    public void deleteContact(){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        sqLiteDatabase.delete(Contact.Entry.TABLE_NAME,null,null);
    }
}
