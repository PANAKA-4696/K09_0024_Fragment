package jp.ac.neec.it.k023c0024.k07_0024_intent

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class BunkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bunk)

        //リスト画面から渡されたデータを取得
        val name = intent.getStringExtra("name")//キーとなるものの名前が一致していればOK
        val money = intent.getIntExtra("money", 0)

        val etMoney = findViewById<TextView>(R.id.puMoney)
        etMoney.setText(money.toString())
        val etName = findViewById<TextView>(R.id.puName)
        etName.setText(name)

        //toIntOrNull() は、文字列が有効な整数であればその Int 値を、そうでなければ null を返します。
        val money_push = findViewById<EditText>(R.id.PushMoney).text.toString()
        val mo_push = money_push.toIntOrNull()

        val btConfirm = findViewById<Button>(R.id.btConfirm)
        btConfirm.setOnClickListener(ConfirmClickListener())
    }

    private inner class ConfirmClickListener : View.OnClickListener{
        override fun onClick(view: View?) {
            //リスト画面から渡されたデータを取得
            val name = intent.getStringExtra("name")//キーとなるものの名前が一致していればOK
            val money = intent.getIntExtra("money", 0)

            //toIntOrNull() は、文字列が有効な整数であればその Int 値を、そうでなければ null を返します。
            val money_push = findViewById<EditText>(R.id.PushMoney).text.toString()
            val mo_push = money_push.toIntOrNull()


            if(mo_push != null){
                if(mo_push > 0){
                    val all_money = money + mo_push

                    val intentBunkConfirmActivity = Intent(this@BunkActivity, BunkConfirmActivity::class.java)

                    intentBunkConfirmActivity.putExtra("mo_push", mo_push)
                    intentBunkConfirmActivity.putExtra("all_money", all_money)
                    intentBunkConfirmActivity.putExtra("name", name)

                    startActivity(intentBunkConfirmActivity)
                }else{
                    //トーストで正の整数値を入力してくださいと表示
                    Toast.makeText(this@BunkActivity, "正の整数値を入力してください", Toast.LENGTH_SHORT).show()
                }
            }else{
                //トーストで正の整数値を入力してくださいと表示
                Toast.makeText(this@BunkActivity, "正の整数値を入力してください", Toast.LENGTH_SHORT).show()
            }
        }
    }
}