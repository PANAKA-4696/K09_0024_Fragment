package jp.ac.neec.it.k023c0024.k07_0024_intent

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class GEOShopConfirmActivityFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ここでFragmentがメニューを持つことを有効化する
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Fragmentのレイアウトをここでインフレ―としてViewを生成する
        val view = inflater.inflate(R.layout.activity_geoshop_confirm, container, false)

        //Bundleからデータを取得
        val money = arguments?.getInt("money", 0)
        val price1 = arguments?.getInt("price1", 0)
        val game1 = arguments?.getString("game1")

        val btGEO = view.findViewById<Button>(R.id.btSubShop1)
        btGEO.setOnClickListener(ClickBtGEOListinere())

        val puMoney = view.findViewById<TextView>(R.id.puMoney)
        puMoney.setText(money.toString())

        val GEOmsg = view.findViewById<TextView>(R.id.Shop1Msg)
        var msg = ""

        if (money != null && price1 != null && money >= price1) {
            msg = "ご購入ありがとうございます。\n ${game1} ${price1}"
        }
        else{
            msg = "所持金が足りません。"
        }

        GEOmsg.setText(msg)

        return view
    }

    private inner class ClickBtGEOListinere : View.OnClickListener{
        override fun onClick(view: View?) {
            //自分が所属するアクティビティがnullじゃないなら
            activity?.let { 
                //自分が所属するアクティビティからGEOShopConfirmActivityfragmentContainerを取得
                val GEOShopConfirmActivityfragmentContainer = it.findViewById<View>(R.id.GEOShopConfirmActivityfragmentContainer)
                //GEOShopConfirmActivityfragmentContainerがnullじゃないなら
                if (GEOShopConfirmActivityfragmentContainer != null) {
                    //フラグメントトランザクションの開始
                    val transaction = requireActivity().supportFragmentManager.beginTransaction()
                    //フラグメントトランザクションが正しく動作するように設定
                    transaction.setReorderingAllowed(true)
                    //自分自身を削除
                    transaction.remove(this@GEOShopConfirmActivityFragment)
                    //フラグメントトランザクションのコミット
                    transaction.commit()
                }
                //GEOShopConfirmActivityfragmentContainerがnullなら
                else {
                    //GEOShopConfirmActivityfragmentContainerを終了
                    requireActivity().supportFragmentManager.popBackStack()
                }
            }
            
//            //FragmentManagerのスタックから一つ戻る
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //選択されたメニューが「戻る」の場合、アクティビティを終了
        if (item.itemId == android.R.id.home) {
            requireActivity().finish()
            return true
        }
        //親クラスの同名メソッドを呼び出す
        return super.onOptionsItemSelected(item)
    }

}