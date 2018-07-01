package tomaszkopacz.meetbam.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_map.*
import tomaszkopacz.meetbam.R

class MapActivity
    : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        setSupportActionBar(map_toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }
}
