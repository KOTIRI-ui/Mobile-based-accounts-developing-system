package com.example.myapplication

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class MyDatabaseHelper(val context: Context, name: String, version: Int) :
        SQLiteOpenHelper(context, name, null, version) {
    private val createuser = "create table user (" +
            " user_id integer primary key autoincrement," +
            "user_department text," +
            "user_name text," +
            "user_login text," +
            "user_passwd text," +
            "user_tel text)"
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(createuser)
        Toast.makeText(context, "Create succeeded", Toast.LENGTH_SHORT).show()
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
    }
}