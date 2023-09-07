package com.example.medzapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class ClassForDB extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 3;
    private static final String DATABASE_NAME = "MedZapp";

    public ClassForDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE USER(Id integer primary key autoincrement, Name text,Email text,Phno text,Address text,District text,LandMark text,PinNo integer, UName text, PassW text,UType integer)");
        sqLiteDatabase.execSQL("CREATE TABLE DOCTOR(Doc_Id integer primary key autoincrement, Doc_Name text,Doc_HospAddress text,Experience text,Mobile text,Fees integer,Doc_type integer,Specialization text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS USER");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS DOCTOR");
        onCreate(sqLiteDatabase);
    }

    public void onUserRegister(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues cv = new ContentValues();
            cv.put("name", user.Name);
            cv.put("email", user.Email);
            cv.put("phno", user.Phno);
            cv.putNull("address");
            cv.putNull("district");
            cv.putNull("landmark");
            cv.putNull("pinno");
            cv.put("uName", user.UName);
            cv.put("passW", user.PassW);
            cv.put("uType", user.UType);
            db.insert("USER", null, cv);
        } catch (Exception e) {
            System.out.println("DatabaseError,Error inserting user data" + e.getMessage());
        } finally {
            if (db != null) {
                db.close();
            }
        }
    }

    public void onDocRegister() {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues cv = new ContentValues();
            cv.put("Doc_Name", "Dr Kripa");
            cv.put("Doc_HospAddress", "Medical trust Hospital, Ernakulam, Kochi.");
            cv.put("Experience", "10yrs");
//            cv.putNull("address");
//            cv.putNull("district");
//            cv.putNull("landmark");
//            cv.putNull("pinno");
            cv.put("Mobile", "8596454652");
            cv.put("Fees", 1000);
            cv.put("Doc_type", 6);
            cv.put("Specialization", "Orthopedic");

            db.insert("DOCTOR", null, cv);
            System.out.println("DB insert Success");
        } catch (Exception e) {
            System.out.println("DatabaseError,Error inserting user data" + e.getMessage());
        } finally {
            if (db != null) {
                db.close();
            }
        }
    }

    public int getUserName(String Uname) {

        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String[] columns = {"UName"};
            String selection = "UName" + "=?";
            String[] selectionArgs = {Uname};
            Cursor cursor = db.query("USER", columns, selection, selectionArgs, null, null, null);
            System.out.println(cursor);
            if (cursor != null && cursor.getCount() != 0) {
                cursor.close();
                db.close();
                return 1;
            } else {
                cursor.close();
                db.close();
                return 0;
            }

        } catch (Exception e) {
            System.out.println("DatabaseError,Error fetching user data" + e.getMessage());
        }
        return -1;
    }

    public String[] getUserDetails(String UNAME) {
        String a[] = new String[5];
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String[] columns = {"Id", "Name", "UName", "PassW","UType"};
            String selection = "UName" + "=?";
            String[] selectionArgs = {UNAME};
            Cursor cursor = db.query("USER", columns, selection, selectionArgs, null, null, null);
            System.out.println(cursor);
            if (cursor != null && cursor.getCount() != 0) {
                cursor.moveToFirst();
                a[0] = String.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("Id")));
                a[1] = cursor.getString(cursor.getColumnIndexOrThrow("Name"));
                a[2] = cursor.getString(cursor.getColumnIndexOrThrow("UName"));
                a[3] = cursor.getString(cursor.getColumnIndexOrThrow("PassW"));
                a[4] = cursor.getString(cursor.getColumnIndexOrThrow("UType"));
            } else {
                a[0] = "";
                a[1] = "";
                a[2] = "";
                a[3] = "";
                a[4] = "";
            }
            cursor.close();
            db.close();
        } catch (Exception e1) {
            System.out.println(e1);
        }

        return a;
    }

    public Doctor[] getDoctorDetails(String spec) {
        Doctor a[] = new Doctor[5];
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String[] columns = {"Doc_Id", "Doc_Name", "Doc_HospAddress", "Experience","Mobile","Fees","Doc_type","Specialization"};
            String selection = "Specialization" + "=?";
            String[] selectionArgs = {spec};
            Cursor cursor = db.query("DOCTOR", columns, selection, selectionArgs, null, null, null);
            System.out.println(cursor);
            int count=cursor.getCount();
            if (cursor != null && cursor.getCount() != 0) {
                int i = 0; // Initialize i outside of the loop
                while (cursor.moveToNext() && i < count) { // Use a while loop to iterate through the cursor
                    a[i].Doc_Id = cursor.getInt(cursor.getColumnIndexOrThrow("Doc_Id"));
                    a[i].Doc_Name = cursor.getString(cursor.getColumnIndexOrThrow("Doc_Name"));
                    a[i].Doc_HospAddress = cursor.getString(cursor.getColumnIndexOrThrow("Doc_HospAddress"));
                    a[i].Experience = cursor.getString(cursor.getColumnIndexOrThrow("Experience"));
                    a[i].Mobile = cursor.getString(cursor.getColumnIndexOrThrow("Mobile"));
                    a[i].Fees = cursor.getInt(cursor.getColumnIndexOrThrow("Fees"));
                    a[i].Doc_type = cursor.getInt(cursor.getColumnIndexOrThrow("Doc_type"));
                    a[i].Specialization = cursor.getString(cursor.getColumnIndexOrThrow("Specialization"));
                    i++; // Increment i for each valid result
                }
            }

            cursor.close();
            db.close();
        } catch (Exception e1) {
            System.out.println(e1);
        }
        return a;
    }
}
