package com.websarva.wings.android.intentsample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.SimpleAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //画面部品ListViewを取得
        val lvMenu = findViewById<ListView>(R.id.lvMenu)
        //SimpleAdapterで使用数rMutableListオブジェクトを用意
        val menuList: MutableList<MutableMap<String, String>> = mutableListOf()
        // 「唐揚げ定食」のデータを格納するMapオブジェクトの用意とmenuListへのデータ登録
        var menu = mutableMapOf("name" to "唐揚げ定食", "price" to "850円")
        menuList.add(menu)
        // 「ハンバーグ定食」のデータを格納するMapオブジェクトの用意とmenuListへのデータ登録
        menu = mutableMapOf("name" to "ハンバーグ定食", "price" to "850円")
        menuList.add(menu)
        // 「生姜焼き」のデータを格納するMapオブジェクトの用意とmenuListへのデータ登録
        menu = mutableMapOf("name" to "生姜焼き", "price" to "850円")
        menuList.add(menu)
        //SimpleAdapter 第4引き数from用データの用意
        val from = arrayOf("name", "price")
        //SimpleAdapter 第5引数 to 用データの用意
        val to = intArrayOf(android.R.id.text1, android.R.id.text2)
        //SimpleAdapterを生成
        val adapter = SimpleAdapter(
            this@MainActivity,
            menuList,
            android.R.layout.simple_list_item_2,
            from,
            to
        )
        //アダプタの登録
        lvMenu.adapter = adapter
        lvMenu.onItemClickListener = ListItemClickListener()

    }

    private inner class ListItemClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
            //タップされた行のデータを取得
            val item = parent.getItemAtPosition(position) as MutableMap<String, String>
            //定食名と金額取得
            val menuName = item["name"]
            val menuPrice = item["price"]
//            //インテントオブジェクトを生成
//            val intent2MenuThanks = Intent(this@MainActivity, MenuThanksActivity::class.java)
//            //第２画面におくる
//            intent2MenuThanks.putExtra("menuName", menuName)
//            intent2MenuThanks.putExtra("menuPrice", menuPrice)

            //kotlinらしく書くと...
            val intent2MenuThanks = Intent(this@MainActivity, MenuThanksActivity::class.java).apply {
                putExtra("menuName", menuName)
                putExtra("menuPrice", menuPrice)
            }


            //第２画面の起動
            startActivity(intent2MenuThanks)
        }
    }

}