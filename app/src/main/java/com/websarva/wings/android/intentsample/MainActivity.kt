package com.websarva.wings.android.intentsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

    }
}