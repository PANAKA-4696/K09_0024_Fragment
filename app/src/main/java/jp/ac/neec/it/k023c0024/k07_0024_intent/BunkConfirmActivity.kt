package jp.ac.neec.it.k023c0024.k07_0024_intent

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BunkConfirmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bunk_confirm)

        val all_money = intent.getIntExtra("all_money", 0)
        val name = intent.getStringExtra("name")
        val mo_push = intent.getIntExtra("mo_push", 0)

        val puMoney = findViewById<TextView>(R.id.BunkPushAll)
        puMoney.setText(all_money.toString())

        val msg = findViewById<TextView>(R.id.msgBunk)
        var msg_text = "${mo_push}円引き出しました。"
        msg.setText(msg_text)

        val btSubBank = findViewById<Button>(R.id.btSubBank)
        btSubBank.setOnClickListener(ClickBtBunkListinere())
    }

    private inner class ClickBtBunkListinere : View.OnClickListener{
        override fun onClick(view: View?) {
            // MainActivity に戻るための Intent を作成
            val intent = Intent(this@BunkConfirmActivity, MainActivity::class.java)

            // MainActivity 以外のすべてのアクティビティをスタックからクリアするフラグを設定
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP

            startActivity(intent)
            finish() // 現在の BunkConfirmActivity を終了（任意だが推奨）
        }
    }
}