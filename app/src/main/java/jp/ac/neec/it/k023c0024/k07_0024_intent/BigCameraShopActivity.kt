package jp.ac.neec.it.k023c0024.k07_0024_intent

import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import jp.ac.neec.it.k023c0024.k07_0024_intent.R.id.lvBig


class BigCameraShopActivity : AppCompatActivity() {

    private var _merchandiseList: MutableList<MutableMap<String, Any>> = mutableListOf()
    private val _from = arrayOf("menu", "price")
    private val _to = intArrayOf(R.id.tvMenuNameRow, R.id.tvMenuPriceRow)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_big_camera_shop)

        //リスト画面から渡されたデータを取得
        //キーとなるものの名前が一致していればOK
        val money = intent.getIntExtra("money", 0)

        val etMoney = findViewById<TextView>(R.id.puMoney)
        etMoney.setText(money.toString())

        _merchandiseList = createElectronicsList()
        val lvBig = findViewById<ListView>(R.id.lvBig)

        val adapter = SimpleAdapter(
            this@BigCameraShopActivity,
            _merchandiseList,
            R.layout.row,
            _from,_to)

        lvBig.adapter = adapter
        lvBig.onItemClickListener = BigListItemClickListener()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        registerForContextMenu(lvBig)
    }
    //全部が文字列じゃないためAny型
    private fun createElectronicsList() : MutableList<MutableMap<String, Any>> {
        //SimpleAdapterで使用するMutableListオブジェクトを用意
        val merchandiseList: MutableList<MutableMap<String, Any>> = mutableListOf()

        //「電化製品」のデータを格納するMapオブジェクトの用意とelectronicsへのデータ登録
        val merchandise: MutableList<String> = mutableListOf(
            "WindowsPC", "iPhone12", "iPhone16", "MacbookPro13", "MacbookPro16",
            "イヤホン","USB", "NintendoSwitch", "NintendoSwitch2", "ヘッドホン"
        )

        val prices: MutableList<Int> = mutableListOf(
            200000, 100000, 160000, 200000, 500000,
            10000, 500, 40000, 50000, 20000
        )

        val descs: MutableList<String> = mutableListOf(
            "最新型windowsPCです。", "安いiPhoneです。", "最新型iPhoneです。", "安いMacbookです。", "最新型Macbookです。",
            "重低音対応イヤホン", "32ギガデータ保存可能", "初代スイッチ", "最新スイッチ2", "ハイレゾヘッドホン"
        )

        //辞書型(nameとpriceキーになる)
        for (i in merchandise.indices) {
            var menu = mutableMapOf<String, Any>(
                "menu" to merchandise[i],
                "price" to prices[i],
                "desc" to descs[i]
            )
            merchandiseList.add(menu)
        }

        return merchandiseList

    }

    private fun createGameList() : MutableList<MutableMap<String, Any>> {
        val merchandiseList: MutableList<MutableMap<String, Any>> = mutableListOf()

        val merchandise: MutableList<String> = mutableListOf(
            "スーパーマリオブラザーズ", "ドンキーコング", "スプラ3", "マリオカートworld", "カービーのエアライダー",
            "マリオパーティジャンボリー", "ポケットモンスターバイオレット,スカーレット", "グランドセフトオート", "ストリートファイター6", "モンスターハンターワイルズ"
        )

        val prices: MutableList<Int> = mutableListOf(
            1000, 7000, 5000, 8000, 5000,
            5000, 6000, 3000, 6000, 10000
        )

        val descs: MutableList<String> = mutableListOf(
            "初代マリオブラザーズの復刻版！！", "ドンキーコング最新作！！", "ぬってぬってぬりまくれ！！スプラトゥーン！", "マリオカート最新作！！", "１０年ぶりの復刻！！",
            "みんなに人気のパーティーゲーム！！", "仲間とともに大冒険！ポケットモンスター！", "暴れまくれ！！グラセフ！！", "真の強者は誰だ！ストリートファイターの最新作！！", "ひと狩り行こうぜ！！モンハン！！"
        )

        //辞書型(nameとpriceキーになる)
        for (i in merchandise.indices) {
            var menu = mutableMapOf<String, Any>(
                "menu" to merchandise[i],
                "price" to prices[i],
                "desc" to descs[i]
            )
            merchandiseList.add(menu)
        }

        return merchandiseList
    }

    private fun createCDList() : MutableList<MutableMap<String, Any>> {
        val merchandiseList: MutableList<MutableMap<String, Any>> = mutableListOf()

        val merchandise: MutableList<String> = mutableListOf(
            "breakfast", "ORDER", "プロポーズ", "BOW AND ARROW", "DUA・RHYTHM",
            "火星人", "feel like", "なくしもの", "Dang Ding Dong", "初恋"
        )

        val prices: MutableList<Int> = mutableListOf(
            3600, 2700, 2000, 4700, 2700,
            3000, 3400, 1800, 1600, 1500
        )

        val descs: MutableList<String> = mutableListOf(
            "Mrs.GreenAppleの最新曲", "CLAN QUEENの最新曲", "なとりの最新曲", "米津玄帥の最新曲", "Chevonの最新曲",
            "ヨルシカの最新曲", "Eveの最新曲","キタニタツヤの最新曲", "sumikaの最新曲", "TOOBOEの最新曲"
        )

        //辞書型(nameとpriceキーになる)
        for (i in merchandise.indices) {
            var menu = mutableMapOf<String, Any>(
                "menu" to merchandise[i],
                "price" to prices[i],
                "desc" to descs[i]
            )
            merchandiseList.add(menu)
        }

        return merchandiseList
    }

    private inner class BigListItemClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
            //タップされた行のデータを取得
            val item = parent.getItemAtPosition(position) as MutableMap<String, Any>
            //ちゅうもんしょり
            order(item)
        }
    }

    //表示させるやつ
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //オプションメニュー用xmlファイルをインフレ―ト(表示させる)inflateは膨らませるの意
        menuInflater.inflate(R.menu.menu_options_menu_list, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //戻り値用の変数を初期値trueで用意
        var returnVal = true
        when(item.itemId){
            R.id.menuListOptionElectrics -> {
                _merchandiseList = createElectronicsList()
            }
            R.id.menuListOption_game -> {
                _merchandiseList = createGameList()
            }
            R.id.menuListOption_CD -> {
                _merchandiseList = createCDList()
            }
            //選択されたメニューが「戻る」の場合、アクティビティを終了
            android.R.id.home -> {
                finish()
            }
            //それ以外
            else -> {
                //親クラスの同名メソッドを呼び出し、その戻り値をreturnValとする
                returnVal = super.onOptionsItemSelected(item)
            }
        }
        //画面部品ListViewを取得
        val lvBig = findViewById<ListView>(R.id.lvBig)
        //SimpleAdapterを選択されたメニューデータで生成
        val adapter = SimpleAdapter(
            this@BigCameraShopActivity,
            _merchandiseList,
            R.layout.row,
            _from,_to)
        //アダプタの登録
        lvBig.adapter = adapter
        return returnVal
    }

    override fun onCreateContextMenu(
        menu: ContextMenu,
        v: View,
        menuInfo: ContextMenu.ContextMenuInfo
    ) {
        //親クラスの同名メソッドの呼び出し
        super.onCreateContextMenu(menu, v, menuInfo)
        //コンテキストメニュー用xmlファイルをインフレ―ト
        menuInflater.inflate(R.menu.menu_context_menu_list, menu)
        menu.setHeaderTitle(R.string.menu_list_context_header)
    }

    private fun order(menu: MutableMap<String, Any>){
        //商品名と金額を取得。Mapの値部分がAny型なのでキャストが必要
        val money = intent.getIntExtra("money", 0)
        val electrics = menu["menu"] as String
        val price2 = menu["price"] as Int

        val intentBigCameraShopConfirmActivity = Intent(this@BigCameraShopActivity, BigCameraShopConfirmActivity::class.java)

        intentBigCameraShopConfirmActivity.putExtra("money", money)
        intentBigCameraShopConfirmActivity.putExtra("price2", price2)
        intentBigCameraShopConfirmActivity.putExtra("electrics", electrics)

        startActivity(intentBigCameraShopConfirmActivity)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        //戻り値用の変数を初期値trueで用意
        var returnVal = true
        //長押しされtビューに関する情報が格納されたオブジェクトを取得
        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        //長押しされたリストポジションを取得
        val listPosition = info.position
        //ポジションから長押しされたメニュー情報Mapオブジェクトを取得
        val menu = _merchandiseList[listPosition]

        //選択されたメニューのIDのR値による処理の分岐
        when(item.itemId){
            //「説明を表示」メニューが選択されたときの処理
            R.id.menuListContextDesc -> {
                //メニューの説明文字列を取得
                val desc = menu["desc"] as String
                //Toastで表示
                Toast.makeText(this@BigCameraShopActivity, desc, Toast.LENGTH_LONG).show()
            }
            //「購入」メニューが選択されたときの処理
            R.id.menuListContextBuy -> {
                //購入処理
                order(menu)
            }
            //それ以外
            else -> {
                //親クラスの同名メソッドを呼び出し、その戻り値をreturnValとする
                returnVal = super.onContextItemSelected(item)
            }
        }
        return returnVal
    }
}