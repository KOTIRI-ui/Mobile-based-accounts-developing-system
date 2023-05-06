package com.example.myapplication

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.text.toByte as textToByte

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // initdatabase()

     Sign_in.setOnClickListener{
          val mydbHelper = MyDatabaseHelper(this, "t_user.db", 1)
            var corrector = false
            val name = Username.text.toString()
            val word = Password.text.toString()
            val db1 = mydbHelper.readableDatabase
            val cursor =db1.rawQuery("select * from user",null)

            while(cursor.moveToNext()){
                val login = cursor.getString(cursor.getColumnIndex("user_login"))
                val passwd = cursor.getString(cursor.getColumnIndex("user_passwd"))
                 val passwd1=String(Base64.decode(passwd.toByteArray(),Base64.NO_WRAP))
               // Log.d("MainActivity", "book name is $login  +$passwd1")
                if( name.equals(login) && word.equals(passwd1) ){
                    //如果账号密码正确的话
                    Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show()
                    corrector = true
                    val intent = Intent(this,homeActivity::class.java)
                    startActivity(intent)
                    this.finish()
                }
            }

            if(!corrector){
                Toast.makeText(this,"账号或密码错误请重新登录！ ",Toast.LENGTH_SHORT).show()
             Username.setText("")
                Password.setText("")
            }

        }
        quit.setOnClickListener {
            ActivityCollector.finishAll()
        }

    }

    fun initdatabase(){

        val dbHelper = MyDatabaseHelper(this, "t_user.db", 1)
       val db= dbHelper.writableDatabase
        db.execSQL("delete from user")
        val values1 = ContentValues().apply {
            // 开始组装第一条数据

            put("user_department", "计算机1902")
            put("user_login", "20191548")
            put("user_name", "张三")
            put("user_passwd",Base64.encodeToString(("123").toByteArray(),Base64.NO_WRAP).toString())
            put("user_tel","12312312313")
        }
        db.insert("user", null, values1) // 插入第一条数据

    }


    }

