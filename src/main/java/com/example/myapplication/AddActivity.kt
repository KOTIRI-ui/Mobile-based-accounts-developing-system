package com.example.myapplication

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.logistics.LocalDatabase
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        saveButton.setOnClickListener{

            val rCity = r_city.text.toString()
            val sName = s_name.text.toString()
            val sTel = s_tel.text.toString()
            val rName = r_name.text.toString()
            val rTel = r_tel.text.toString()
            val Kind = kind.text.toString()
            val Num = num.text.toString().toInt()
            val sCost = s_cost.text.toString().toInt()
            val rCost = r_cost.text.toString().toInt()

            val addHelper = LocalDatabase(this, "ExpressBill", 1)
            val db = addHelper.writableDatabase
            val newBill = ContentValues().apply{
                put("r_city",rCity)
                put("s_name",sName)
                put("s_tel",sTel)
                put("r_name",rName)
                put("r_tel",rTel)
                put("kind",Kind)
                put("num",Num)
                put("s_cost",sCost)
                put("r_cost",rCost)
            }
            db.insert("ExpressBill",null,newBill)
            Toast.makeText(this,"保存成功！", Toast.LENGTH_SHORT).show()
            val intent = Intent(this,homeActivity::class.java)
            startActivity(intent)
            this.finish()

        }
    }
}
