package com.example.zadanie6

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class CategoriiPomoshi : AppCompatActivity() {

    lateinit var nav: BottomNavigationView
    lateinit var buttonhead: ExtendedFloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categorii_pomoshi)

        // вживляем фрагмент в активити
        replaceFragment(BlankFragment())

        // наши объекты для работы
        nav = findViewById(R.id.BottomNavagation)
        buttonhead = findViewById(R.id.extendedFloatingActionButton)

        // выбранный пункт
        nav.menu.getItem(2).setChecked(true)

        nav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.profile -> {
                    val intent = Intent(this@CategoriiPomoshi, Profile::class.java)
                    startActivity(intent)
                }
                R.id.search -> {
                    val intent = Intent(this@CategoriiPomoshi, SearchActivity::class.java)
                    startActivity(intent)
                }
                R.id.news -> {
                    val intent = Intent(this@CategoriiPomoshi, NewsActivity::class.java)
                    startActivity(intent)
                }
            }

            return@setOnItemSelectedListener true
        }
    }

    override fun onResume() {
        super.onResume()
        // выбранный пункт
        nav.menu.getItem(2).setChecked(true)
    }

    // фрагмент функция
    private fun replaceFragment(blankFragment: BlankFragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.place_holder, blankFragment)
        fragmentTransaction.commit()
    }
}
