package jp.ac.neec.it.k023c0024.k07_0024_intent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction

class GEOShopHostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_geoshop_host)

        // ActionBarにホームボタン（戻るボタン）を表示する
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Fragmentを動的に追加する処理
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, GEOShopActivityFragment())
        fragmentTransaction.commit()
    }
}