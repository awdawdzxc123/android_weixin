package com.example.android_weixin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.android_weixin.Fruit
import com.example.android_weixin.FruitAdapter
import com.example.android_weixin.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.weixin.*
import java.text.SimpleDateFormat
import java.util.*
import java.util.logging.SimpleFormatter
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    //    private val data= listOf("苹果","香蕉","哈密瓜","月饼","山竹","西瓜","榴莲","水蜜桃","葡萄","荔枝","火龙果","小可爱","芒果")
    private  val fruitList=ArrayList<Fruit>()

    private fun initFruits(){
        repeat(8){
            fruitList.add(Fruit("白云学院","泡妞群", R.drawable.ic_launcher_background))
            fruitList.add(Fruit("C8-601","撩妹群",R.drawable.ic_launcher_background))


        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()//标题弃掉



        initFruits()

        //上下文,列表子视图,数据源
//        val adapter =ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,data)

        val fruitAdapter= FruitAdapter(this,R.layout.weixin,fruitList)
        //绑定到控件
//        listViewTest.adapter=adapter;

        listViewTest.adapter=fruitAdapter;


        listViewTest.setOnItemClickListener { _,_, i, _->
            val fruit =fruitList[i]
            Toast.makeText(this,fruit.name,Toast.LENGTH_SHORT).show()
        }
    }
}
