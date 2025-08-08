package jp.ac.neec.it.k023c0024.k07_0024_intent

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.TextView

class GEOShopActivityFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ここでFragmentがメニューを持つことを有効化する
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?   ,
        savedInstanceState: Bundle?
    ): View? {
        //Fragmentのレイアウトをここでインフレ―としてViewを生成する
        val view = inflater.inflate(R.layout.activity_geoshop, container, false)

        //ホスティングしているActivityのIntentからデータを受け取る
        val name = requireActivity().intent.getStringExtra("name")
        val money = requireActivity().intent.getIntExtra("money", 0)

        //生成したViewから各UIコンポーネントを取得する
        val etMoney = view.findViewById<TextView>(R.id.puMoney)
        etMoney.setText(money.toString())

        val lvGEO = view.findViewById<ListView>(R.id.lvGEO)

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
            requireContext(), gameList,
            android.R.layout.simple_list_item_2, from, to
        )

        lvGEO.adapter = adapter
        lvGEO.onItemClickListener = GEOListItemClickListener()

        //最後にインフレ―としたViewを返す
        return view
    }

    private inner class GEOListItemClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
            val GEOitem = parent.getItemAtPosition(position) as MutableMap<String, Any>

            val money = requireActivity().intent.getIntExtra("money", 0)
            val price1 = GEOitem["price1"] as Int
            val game1 = GEOitem["game1"] as String

            // 新しいFragmentのインスタンスを生成
            val nextFragment = GEOShopConfirmActivityFragment()

            //Fragemntにデータを渡すためのBundleを生成
            val bundle = Bundle()
            bundle.putInt("money", money)
            bundle.putInt("price1", price1)
            bundle.putString("game1", game1)
            nextFragment.arguments = bundle //BundleをFragmentに設定

            //Fragmentを置き換える処理
            //requireActivity().supportFragmentManagerを使って、Fragmentを管理
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, nextFragment)//fragmentContainerはレイアウトのID
                .addToBackStack(null) //戻るボタンで前のFragmentに戻れるようにする
                .commit()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //選択されたメニューが「戻る」の場合
        if (item.itemId == android.R.id.home) {
            //ホスティングしているActivityを終了する
            requireActivity().finish()
            return true
        }
        //親クラスの同名メソッドを呼び出す
        return super.onOptionsItemSelected(item)
    }
}