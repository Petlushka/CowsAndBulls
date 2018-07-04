package com.example.user.cowsandbulls.views

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.example.user.cowsandbulls.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.players -> {
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.content, PlayersFragment.Companion.newInstance(),"players")
                        .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.game -> {
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.content, GameFragment.Companion.newInstance(), "game")
                        .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.statistics -> {
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.content, StatisticsFragment.Companion.newInstance(), "statistics")
                        .commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        supportFragmentManager.beginTransaction()
                .replace(R.id.content, PlayersFragment.Companion.newInstance(), "players")
                .commit()

    }
}
