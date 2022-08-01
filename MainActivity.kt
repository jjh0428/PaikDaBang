package mypaikdabang.mypaikdabang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import mypaikdabang.mypaikdabang.databinding.ActivityMainBinding
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val menuTitle = arrayOf("초코바나나빽스치노", "딸기바나나빽스치노", "앗!메리카노", "딸기라떼", "청포도플라워")
    private val menuPrice = arrayOf(4300, 4300, 2000, 3500, 3500)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initImages()
        initMenu1()
        initMenu2()
        initMenu3()
        initMenu4()
        initMenu5()
        
        binding.btBuy?.setOnClickListener {
//            Toast.makeText(this, "결제창 열기", Toast.LENGTH_SHORT).show()
            val buyIntent = Intent(this, BuyActivity::class.java)
            buyIntent.putExtra("menu1", binding.etOrderCount1?.text.toString().toInt())
            buyIntent.putExtra("menu2", binding.etOrderCount2?.text.toString().toInt())
            buyIntent.putExtra("menu3", binding.etOrderCount3?.text.toString().toInt())
            buyIntent.putExtra("menu4", binding.etOrderCount4?.text.toString().toInt())
            buyIntent.putExtra("menu5", binding.etOrderCount5?.text.toString().toInt())
            buyIntent.putExtra("total", binding.tvTotal?.text.toString())
            startActivity(buyIntent)
        }

    }

    private fun initMenu1() {
        binding.ivMenu1.setOnClickListener {
            addMenu(1)
            getMenuTotal()
        }
        binding.ivOrderAdd1.setOnClickListener {
            addMenu(1)
            getMenuTotal()
        }
        binding.ivOrderRemove1?.setOnClickListener {
            removeMenu(1)
            getMenuTotal()
        }
    }
    private fun initMenu2() {
        binding.ivMenu2.setOnClickListener {
            addMenu(2)
            getMenuTotal()
        }
        binding.ivOrderAdd2.setOnClickListener {
            addMenu(2)
            getMenuTotal()
        }
        binding.ivOrderRemove2?.setOnClickListener {
            removeMenu(2)
            getMenuTotal()
        }
    }
    private fun initMenu3() {
        binding.ivMenu3.setOnClickListener {
            addMenu(3)
            getMenuTotal()
        }
        binding.ivOrderAdd3.setOnClickListener {
            addMenu(3)
            getMenuTotal()
        }
        binding.ivOrderRemove3?.setOnClickListener {
            removeMenu(3)
            getMenuTotal()
        }
    }
    private fun initMenu4() {
        binding.ivMenu4.setOnClickListener {
            addMenu(4)
            getMenuTotal()
        }
        binding.ivOrderAdd4.setOnClickListener {
            addMenu(4)
            getMenuTotal()
        }
        binding.ivOrderRemove4?.setOnClickListener {
            removeMenu(4)
            getMenuTotal()
        }
    }
    private fun initMenu5() {
        binding.ivMenu5.setOnClickListener {
            addMenu(5)
            getMenuTotal()
        }
        binding.ivOrderAdd5.setOnClickListener {
            addMenu(5)
            getMenuTotal()
        }
        binding.ivOrderRemove5?.setOnClickListener {
            removeMenu(5)
            getMenuTotal()
        }
    }

    private fun getMenuTotal() {
        val nMenu1 = binding.etOrderCount1?.text.toString().toInt()
        val nMenu2 = binding.etOrderCount2?.text.toString().toInt()
        val nMenu3 = binding.etOrderCount3?.text.toString().toInt()
        val nMenu4 = binding.etOrderCount4?.text.toString().toInt()
        val nMenu5 = binding.etOrderCount5?.text.toString().toInt()
        val total = nMenu1 * menuPrice[0] + nMenu2 * menuPrice[1] + nMenu3 * menuPrice[2] + nMenu4 * menuPrice[3] + nMenu5 * menuPrice[4]
        val textTotal = DecimalFormat("#,###").format(total)
        binding.tvTotal?.text = "총합 : $textTotal 원"

    }

    private fun addMenu(item:Int) {
        if(item == 1) {
            val nMenu1 = binding.etOrderCount1?.text.toString().toInt()
            if(nMenu1 < 10) {
                val textMenu1: String = "%d".format(nMenu1 + 1)
                binding.etOrderCount1.setText(textMenu1)
            } else {
                Toast.makeText(this, "10개까지만" + " 주분할 수 있어요", Toast.LENGTH_SHORT).show()
            }
        }
        if(item == 2) {
            val nMenu2 = binding.etOrderCount2?.text.toString().toInt()
            if(nMenu2 < 10) {
                val textMenu2: String = "%d".format(nMenu2 + 1)
                binding.etOrderCount2.setText(textMenu2)
            } else {
                Toast.makeText(this, "10개까지만" + " 주분할 수 있어요", Toast.LENGTH_SHORT).show()
            }
        }
        if(item == 3) {
            val nMenu3 = binding.etOrderCount3?.text.toString().toInt()
            if(nMenu3 < 10) {
                val textMenu3: String = "%d".format(nMenu3 + 1)
                binding.etOrderCount3.setText(textMenu3)
            } else {
                Toast.makeText(this, "10개까지만" + " 주분할 수 있어요", Toast.LENGTH_SHORT).show()
            }
        }
        if(item == 4) {
            val nMenu4 = binding.etOrderCount4?.text.toString().toInt()
            if(nMenu4 < 10) {
                val textMenu4: String = "%d".format(nMenu4 + 1)
                binding.etOrderCount4.setText(textMenu4)
            } else {
                Toast.makeText(this, "10개까지만" + " 주분할 수 있어요", Toast.LENGTH_SHORT).show()
            }
        }
        if(item == 5) {
            val nMenu5 = binding.etOrderCount5?.text.toString().toInt()
            if(nMenu5 < 10) {
                val textMenu5: String = "%d".format(nMenu5 + 1)
                binding.etOrderCount5.setText(textMenu5)
            } else {
                Toast.makeText(this, "10개까지만" + " 주분할 수 있어요", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun removeMenu(item:Int) {
        when(item) {
            1 -> {
                val nMenu1 = binding.etOrderCount1?.text.toString().toInt()
                if(nMenu1 > 0) {
                    val textMenu1: String = "%d".format(nMenu1 - 1)
                    binding.etOrderCount1.setText(textMenu1)
                } else {
                    Toast.makeText(this, "에러", Toast.LENGTH_SHORT).show()
                }
            }
            2 -> {
                val nMenu2 = binding.etOrderCount2?.text.toString().toInt()
                if(nMenu2 > 0) {
                    val textMenu2: String = "%d".format(nMenu2 - 1)
                    binding.etOrderCount2.setText(textMenu2)
                } else {
                    Toast.makeText(this, "에러", Toast.LENGTH_SHORT).show()
                }
            }
            3 -> {
                val nMenu3 = binding.etOrderCount3?.text.toString().toInt()
                if(nMenu3 > 0) {
                    val textMenu3: String = "%d".format(nMenu3 - 1)
                    binding.etOrderCount3.setText(textMenu3)
                } else {
                    Toast.makeText(this, "에러", Toast.LENGTH_SHORT).show()
                }
            }
            4 -> {
                val nMenu4 = binding.etOrderCount4?.text.toString().toInt()
                if(nMenu4 > 0) {
                    val textMenu4: String = "%d".format(nMenu4 - 1)
                    binding.etOrderCount4.setText(textMenu4)
                } else {
                    Toast.makeText(this, "에러", Toast.LENGTH_SHORT).show()
                }
            }
            5 -> {
                val nMenu5 = binding.etOrderCount5?.text.toString().toInt()
                if(nMenu5 > 0) {
                    val textMenu5: String = "%d".format(nMenu5 - 1)
                    binding.etOrderCount5.setText(textMenu5)
                } else {
                    Toast.makeText(this, "에러", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


    private fun initImages() {
        Glide.with(this)// 뷰바인딩
            .load("https://paikdabang.com/wp-content/uploads/2018/05/%EC%99%84%EC%A0%84%EC%B4%88%EC%BD%94%EB%B0%94%EB%82%98%EB%82%98_%EB%B9%BD%EC%8A%A4%EC%B9%98%EB%85%B8-SOFT-450x588.png")
            .into(binding.ivMenu1)
        binding.tvMenuTitle1.text = menuTitle[0]
        binding.tvMenuPrice1.text = "${menuPrice[0]}원"
        Glide.with(this)// 뷰바인딩
            .load("https://paikdabang.com/wp-content/uploads/2018/05/%EC%99%84%EC%A0%84%EB%94%B8%EA%B8%B0%EB%B0%94%EB%82%98%EB%82%98-SOFT-450x588.png")
            .into(binding.ivMenu2)
        binding.tvMenuTitle2.text = menuTitle[1]
        binding.tvMenuPrice2.text = "${menuPrice[1]}원"
        Glide.with(this)// 뷰바인딩
            .load("https://paikdabang.com/wp-content/uploads/2018/05/ICED-%EC%95%97%EB%A9%94%EB%A6%AC%EC%B9%B4%EB%85%B8-450x588.png")
            .into(binding.ivMenu3)
        binding.tvMenuTitle3.text = menuTitle[2]
        binding.tvMenuPrice3.text = "${menuPrice[2]}원"
        Glide.with(this)// 뷰바인딩
            .load("https://paikdabang.com/wp-content/uploads/2022/02/%EB%94%B8%EA%B8%B0%EB%9D%BC%EB%96%BC-450x588.png")
            .into(binding.ivMenu4)
        binding.tvMenuTitle4.text = menuTitle[3]
        binding.tvMenuPrice4.text = "${menuPrice[3]}원"
        Glide.with(this)// 뷰바인딩
            .load("https://paikdabang.com/wp-content/uploads/2018/06/%EC%B2%AD%ED%8F%AC%EB%8F%84%EC%97%90%EC%9D%B4%EB%93%9C-450x588.png")
            .into(binding.ivMenu5)
        binding.tvMenuTitle5.text = menuTitle[4]
        binding.tvMenuPrice5.text = "${menuPrice[4]}원"

    }

    companion object {
        val menuTitle = arrayOf("초코바나나빽스치노", "딸기바나나빽스치노", "앗!메리카노", "딸기라떼", "청포도플라워")
        val menuPrice = arrayOf(4300, 4300, 2000, 3500, 3500)
    }

}