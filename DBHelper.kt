package com.example.libroturnos
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context): SQLiteOpenHelper(context, DB_NAME, null,
DB_VERSION) {

    override fun onCreate(sqLiteDatabase: SQLiteDatabase) {
        sqLiteDatabase.execSQL(
            "CREATE TABLE " + CONDUCTOR +
                    " (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " LEGAJO INTEGER," +
                    " NOMBRE TEXT," +
                    " DIAGRAMA TEXT," +
                    " FRANCO TEXT," +
                    " EMAIL TEXT," +
                    " TELEFONO TEXT "
        )
        sqLiteDatabase.execSQL(
            "CREATE TABLE " + TREN +
                    " (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " NUMERO INTEGER," +
                    " PROCEDENCIA TEXT," +
                    " DESTINO TEXT," +
                    " PARTIDA INTEGER," +
                    " LLEGADA INTEGER," +
                    " TURNO TEXT "
        )
        sqLiteDatabase.execSQL(
            "CREATE TABLE " + TURNO +
                    " (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " DIAGRAMA TEXT," +
                    " JORNADA INTEGER," +
                    " TOMADA INTEGER," +
                    " DEJADA INTEGER "
        )

    }
    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase, i:Int, i1:Int) {

    }

    companion object{
        private val DB_NAME = "librodeturnos.db"
        private val DB_VERSION = 1
        private val CONDUCTOR = "Conductor"
        private val TREN = "Tren"
        private val TURNO = "Turno"
    }
}