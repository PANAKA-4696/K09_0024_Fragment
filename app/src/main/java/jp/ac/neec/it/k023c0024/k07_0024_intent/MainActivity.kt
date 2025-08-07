package jp.ac.neec.it.k023c0024.k07_0024_intent

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = findViewById<EditText>(R.id.etTvName).text.toString()
        val money_pre = findViewById<EditText>(R.id.etMoney).text.toString()
        val money = money_pre.toIntOrNull()

        val GEO = findViewById<Button>(R.id.btMainShop1)
        val BigCamera = findViewById<Button>(R.id.btMainShop2)
        val Bunk = findViewById<Button>(R.id.btBunk)

        GEO.setOnClickListener(ClickGEOListnener())
        BigCamera.setOnClickListener(ClickBigCameraListnener())
        Bunk.setOnClickListener(ClickBunkListnener())


    }

    private inner class ClickGEOListnener : View.OnClickListener{
        override fun onClick(view: View?) {
            val name = findViewById<EditText>(R.id.etTvName).text.toString()
            val money_pre = findViewById<EditText>(R.id.etMoney).text.toString()
            val money = money_pre.toIntOrNull()

            //インテントオブジェクトを生成
            val GEOshop = Intent(this@MainActivity, GEOShopHostActivity::class.java)
            //第二画面に送るデータを格納。(Bundle)
            GEOshop.putExtra("name", name)
            GEOshop.putExtra("money", money)

            //第二画面の起動
            startActivity(GEOshop)
        }

    }
    private inner class ClickBigCameraListnener : View.OnClickListener{
        override fun onClick(view: View?) {
            val name = findViewById<EditText>(R.id.etTvName).text.toString()
            val money_pre = findViewById<EditText>(R.id.etMoney).text.toString()
            val money = money_pre.toIntOrNull()

            val BigCamera = Intent(this@MainActivity, BigCameraShopActivity::class.java)
            BigCamera.putExtra("name", name)
            BigCamera.putExtra("money", money)

            startActivity(BigCamera)
        }
    }
    private inner class ClickBunkListnener : View.OnClickListener{
        override fun onClick(view: View?) {
            val name = findViewById<EditText>(R.id.etTvName).text.toString()
            val money_pre = findViewById<EditText>(R.id.etMoney).text.toString()
            val money = money_pre.toIntOrNull()

            val Bunk = Intent(this@MainActivity, BunkActivity::class.java)
            Bunk.putExtra("name", name)
            Bunk.putExtra("money", money)

            startActivity(Bunk)
        }
    }
}