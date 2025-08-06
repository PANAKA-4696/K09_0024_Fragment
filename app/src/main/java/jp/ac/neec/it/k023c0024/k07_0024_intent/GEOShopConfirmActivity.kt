package jp.ac.neec.it.k023c0024.k07_0024_intent

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GEOShopConfirmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_geoshop_confirm)

        val money = intent.getIntExtra("money", 0)
        val price1 = intent.getIntExtra("price1", 0)
        val game1 = intent.getStringExtra("game1")

        val btGEO = findViewById<Button>(R.id.btSubShop1)
        btGEO.setOnClickListener(ClickBtGEOListinere())

        val puMoney = findViewById<TextView>(R.id.puMoney)
        puMoney.setText(money.toString())

        val GEOmsg = findViewById<TextView>(R.id.Shop1Msg)
        var msg = ""

        if (money >= price1) {
            msg = "ご購入ありがとうございます。\n ${game1} ${price1}"
        }
        else{
            msg = "所持金が足りません。"
        }

        GEOmsg.setText(msg)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private inner class ClickBtGEOListinere : View.OnClickListener{
        override fun onClick(view: View?) {
            // MainActivity に戻るための Intent を作成
            val intent = Intent(this@GEOShopConfirmActivity, MainActivity::class.java)

            // MainActivity 以外のすべてのアクティビティをスタックからクリアするフラグを設定
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP

            startActivity(intent)
            finish() // 現在の GEOShopConfirmActivity を終了（任意だが推奨）
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //戻り値用の変数を初期値trueで用意
        var returnVal = true
        //選択されたメニューが「戻る」の場合、アクティビティを終了
        if (item.itemId == android.R.id.home) {
            finish()
        } else {
            //親クラスの同名メソッドを呼び出し、その戻り値をreturnValとする
            returnVal = super.onOptionsItemSelected(item)
        }
        return returnVal
    }
}