package com.example.testaeon.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast
import com.example.testaeon.Tools.app


val DB_NAME = "DATABASE"
val DB_TABLE = "PHOTOS"
val COL_ID = "ID"
val COL_TITLE = "TITLE"
val COL_URL = "URL"

class DBLocal(context:Context) : SQLiteOpenHelper(context, DB_NAME,null,1){
    override fun onCreate(p0: SQLiteDatabase?) {
        val create = "CREATE TABLE "+ DB_TABLE + " ("+
                COL_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                COL_TITLE+" VARCHAR(256)," +
                COL_URL+" VARCHAR(256))"

        p0?.execSQL(create)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun insertData(title: String, URL:String){
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COL_TITLE, title)
        cv.put(COL_URL, URL)
        val result = db.insert(DB_TABLE,null,cv)
        if (result == -1.toLong()){
            Log.d("xxx result", "failed")
        }else{
            Log.d("xxx result", "sukses")
        }
    }

}