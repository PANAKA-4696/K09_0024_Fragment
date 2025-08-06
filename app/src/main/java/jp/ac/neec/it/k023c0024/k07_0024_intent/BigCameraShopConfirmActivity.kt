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

class BigCameraShopConfirmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_big_camera_shop_confirm)

        val money = intent.getIntExtra("money", 0)
        val price2 = intent.getIntExtra("price2", 0)
        val electrics = intent.getStringExtra("electrics")

        val puMoney = findViewById<TextView>(R.id.puMoney)
        puMoney.setText(money.toString())

        val GEOmsg = findViewById<TextView>(R.id.Shop2Msg)
        var msg = ""

        if (money >= price2) {
            msg = "ご購入ありがとうございます。\n ${electrics} ${price2}"
        }
        else{
            msg = "所持金が足りません。"
        }

        GEOmsg.setText(msg)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
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