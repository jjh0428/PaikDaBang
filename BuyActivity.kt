package mypaikdabang.mypaikdabang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class BuyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy)

        val buyIntent = getIntent()
        val menu1 = buyIntent.getIntExtra("menu1", 0)
        val menu2 = buyIntent.getIntExtra("menu2", 0)
        val menu3 = buyIntent.getIntExtra("menu3", 0)
        val menu4 = buyIntent.getIntExtra("menu4", 0)
        val menu5 = buyIntent.getIntExtra("menu5", 0)
        val total = buyIntent.getStringExtra("total")

        val tv_result = findViewById<TextView>(R.id.tv_result)
        tv_result.text = "------------영수증------------\n" +
                "${MainActivity.menuTitle[0]} : ${menu1}개\n" +
                "${MainActivity.menuTitle[1]} : ${menu2}개\n" +
                "${MainActivity.menuTitle[2]} : ${menu3}개\n" +
                "${MainActivity.menuTitle[3]} : ${menu4}개\n" +
                "${MainActivity.menuTitle[4]} : ${menu5}개\n" +
                "${total}"
    }
}