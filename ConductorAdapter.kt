package com.example.libroturnos

import android.content.Context
import android.database.sqlite.SQLiteDatabase

class ConductorAdapter(private val context: Context) {
    private  var dbHelper: DBHelper? = null
    private var db: SQLiteDatabase? = null

    fun abrir() {
        dbHelper = DBHelper(context)
        db = dbHelper!!.writableDatabase
    }

    fun conductorPorLegajo(legajo: Int): String? {

        val c = db!!.query(
            "CONDUCTOR", arrayOf("LEGAJO", "NOMBRE","DIAGRAMA","FRANCO","TELEFONO"),
            "LEGAJO=?", arrayOf(legajo.toString()), null, null, "LEGAJO")
        if (c.moveToFirst()) {
            val colIndex = c.getColumnIndex("LEGAJO")
            return c.getString(colIndex)
        } else {
            return null
        }
    }
}