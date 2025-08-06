package jp.ac.neec.it.k023c0024.k07_0024_intent

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GEOShopActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_geoshop)

        //リスト画面から渡されたデータを取得
        val name = intent.getStringExtra("name")//キーとなるものの名前が一致していればOK
        val money = intent.getIntExtra("money", 0)

        val etMoney = findViewById<TextView>(R.id.puMoney)
        etMoney.setText(money.toString())

        val lvGEO = findViewById<ListView>(R.id.lvGEO)
        val gameList:MutableList<MutableMap<String, Any>> = mutableListOf()

        val games1:MutableList<String> = mutableListOf(
            "モンスターハンターrise", "スプラトゥーン", "スプラトゥーン2", "スプラトゥーン3", "マリオカート7",
            "マリオカート8","マリオカート8DX", "みんなのリズム天国", "みんなのリズム天国ゴールド", "スーパーマリオブラザーズU"
        )

        val prices1:MutableList<Int> = mutableListOf(
            5000, 3000, 4000, 5000, 500,
            3000, 6000, 300, 100, 2000
        )

        //辞書型(game1とprice1を紐づけて格納)
        for(i in games1.indices){
            var game1 = mutableMapOf<String, Any>(
                "game1" to games1[i],
                "price1" to prices1[i]
            )
            gameList.add(game1)
        }

        val from = arrayOf("game1", "price1")
        val to = intArrayOf(android.R.id.text1, android.R.id.text2)
        val adapter = SimpleAdapter(
            this@GEOShopActivity, gameList,
            android.R.layout.simple_list_item_2, from, to
        )

        lvGEO.adapter = adapter
        lvGEO.onItemClickListener = GEOListItemClickListener()
    }

    private inner class GEOListItemClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
            val GEOitem = parent.getItemAtPosition(position) as MutableMap<String, Any>

            val money = intent.getIntExtra("money", 0)
            val price1 = GEOitem["price1"] as Int
            val game1 = GEOitem["game1"] as String

            val intentGEOShopConfirmActivity = Intent(this@GEOShopActivity, GEOShopConfirmActivity::class.java)

            intentGEOShopConfirmActivity.putExtra("money", money)
            intentGEOShopConfirmActivity.putExtra("price1", price1)
            intentGEOShopConfirmActivity.putExtra("game1", game1)

            startActivity(intentGEOShopConfirmActivity)
        }
    }
}