package com.android.personalproject2_login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)



        var btn_login = findViewById<Button>(R.id.btn_login)
        var edit_id = findViewById<EditText>(R.id.editTextText)
        var edit_pwd = findViewById<EditText>(R.id.editTextTextPassword)

        // 답장 처리
        val getSubActivityResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result -> if(result.resultCode == RESULT_OK){
                        edit_id.setText(result.data!!.getStringExtra("id"))
                        edit_pwd.setText(result.data!!.getStringExtra("pwd"))
                     }
            }



        // 얘는 그냥 보내는 거고
        btn_login.setOnClickListener {
            var edit_text = findViewById<EditText>(R.id.editTextText)
            var passwordText = findViewById<EditText>(R.id.editTextTextPassword)
            val strData = edit_text.text.toString()
            var passTextStr = passwordText.text.toString()

            if(strData.isNotEmpty()  &&  passTextStr.isNotEmpty()){
                Toast.makeText(this,"로그인 성공!",Toast.LENGTH_SHORT).show()
                var intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("loginId",strData)
                startActivity(intent)
            }else{
                Toast.makeText(this,"아이디/비밀번호를 확인해주세요.",Toast.LENGTH_SHORT).show()
            }

    }
        // 얘는 보내는거 + 답장을 기다리는 모드 답장이 오면 getSubActivityResult 에서 처리
        var btn_signup = findViewById<Button>(R.id.btn_signup)
        btn_signup.setOnClickListener {
            var intent = Intent(this, SignUpActivity::class.java)
            getSubActivityResult.launch(intent)
//            startActivity(intent)
        }
    }
}