package com.example.zadanie6

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class NewsActivity : AppCompatActivity() {

    lateinit var nav: BottomNavigationView
    lateinit var buttonhead: ExtendedFloatingActionButton
    lateinit var buttonFilter: ImageView

    lateinit var sharedPreferences1: SharedPreferences
    lateinit var sharedPreferences2: SharedPreferences
    lateinit var sharedPreferences3: SharedPreferences
    lateinit var sharedPreferences4: SharedPreferences
    lateinit var boolean1: TextView
    lateinit var boolean2: TextView
    lateinit var boolean3: TextView
    lateinit var boolean4: TextView

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: NewsAdapter
    lateinit var spisokForAdapter: List<NewsData>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        buttonhead = findViewById(R.id.menuCategorii)
        nav = findViewById(R.id.BottomNavagation)
        buttonFilter = findViewById(R.id.filterButton)

//        boolean1 = findViewById(R.id.boolean1)
//        boolean2 = findViewById(R.id.boolean2)
//        boolean3 = findViewById(R.id.boolean3)
//        boolean4 = findViewById(R.id.boolean4)

        recyclerView = findViewById(R.id.RecyclerNovosti)
        recyclerView.layoutManager = LinearLayoutManager(this)

        spisokForAdapter = initSpisokNewsData()

        adapter = NewsAdapter(initSpisokNewsData())
        recyclerView.adapter = adapter  // передаем в адаптер наш список с данными

//        sharedPreferences1 = this.getSharedPreferences("hranilishe1", MODE_PRIVATE)
//        sharedPreferences2 = this.getSharedPreferences("hranilishe2", MODE_PRIVATE)
//        sharedPreferences3 = this.getSharedPreferences("hranilishe3", MODE_PRIVATE)
//        sharedPreferences4 = this.getSharedPreferences("hranilishe4", MODE_PRIVATE)
//        boolean1.text = sharedPreferences1.getBoolean("value1", true).toString()
//        boolean2.text = sharedPreferences2.getBoolean("value2", true).toString()
//        boolean3.text = sharedPreferences3.getBoolean("value3", true).toString()
//        boolean4.text = sharedPreferences4.getBoolean("value4", true).toString()



        // открытие меню Помочь
        buttonhead.setOnClickListener {
            val intent = Intent(this@NewsActivity, CategoriiPomoshi::class.java)
            startActivity(intent)
        }

        // открытие меню Фильтр
        buttonFilter.setOnClickListener {
            val intent = Intent(this@NewsActivity, FiltrActivity::class.java)
            startActivity(intent)
        }

        // открытие Новость1
//        novost1.setOnClickListener {
//            val intent = Intent(this@NewsActivity, SobutiePodrobno::class.java)
//            startActivity(intent)
//        }

        // менюшка BootomMenu
        nav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.profile -> {
                    val intent = Intent(this@NewsActivity, Profile::class.java)
                    startActivity(intent)
                }
                R.id.search -> {
                    val intent = Intent(this@NewsActivity, SearchActivity::class.java)
                    startActivity(intent)
                }
            }

            return@setOnItemSelectedListener true
        }
    }

    fun initSpisokNewsData() : List<NewsData> {

        var spisok = mutableListOf<NewsData>()
            spisok.add(NewsData(R.drawable.news1, "Заголовок1", "Описание события тут много текста и прочее", "здесь дата1"))
            spisok.add(NewsData(R.drawable.news2, "Заголовок2", "Описание события тут много текста и прочее", "здесь дата2"))

        return spisok
    }


//    override fun onResume() {
//        super.onResume()
//
//        sharedPreferences1 = this.getSharedPreferences("hranilishe1", MODE_PRIVATE)
//        sharedPreferences2 = this.getSharedPreferences("hranilishe2", MODE_PRIVATE)
//        sharedPreferences3 = this.getSharedPreferences("hranilishe3", MODE_PRIVATE)
//        sharedPreferences4 = this.getSharedPreferences("hranilishe4", MODE_PRIVATE)
//        boolean1.text = sharedPreferences1.getBoolean("value1", true).toString()
//        boolean2.text = sharedPreferences2.getBoolean("value2", true).toString()
//        boolean3.text = sharedPreferences3.getBoolean("value3", true).toString()
//        boolean4.text = sharedPreferences4.getBoolean("value4", true).toString()
//    }
}
