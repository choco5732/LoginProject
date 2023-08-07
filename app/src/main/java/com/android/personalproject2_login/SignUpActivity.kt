package com.android.personalproject2_login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        var edit_name = findViewById<EditText>(R.id.editTextText2)
        var edit_id = findViewById<EditText>(R.id.editTextText3)
        var edit_pwd = findViewById<EditText>(R.id.editTextTextPassword2)

        var btn_signup = findViewById<Button>(R.id.btn_signup)
        btn_signup.setOnClickListener {

            var strName = edit_name.text.toString()
            var strId = edit_id.text.toString()
            var strPwd = edit_pwd.text.toString()
            if(strName.isNotEmpty() && strId.isNotEmpty() && strPwd.isNotEmpty()){
                intent.putExtra("id",strId)
                intent.putExtra("pwd",strPwd)
                setResult(RESULT_OK, intent)
                finish()
            }else{
                Toast.makeText(this,"입력되지 않은 정보가 있습니다.",Toast.LENGTH_SHORT).show()
            }
        }
    }
}