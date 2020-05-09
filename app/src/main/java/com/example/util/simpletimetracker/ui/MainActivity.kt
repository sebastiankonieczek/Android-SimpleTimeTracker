package com.example.util.simpletimetracker.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.util.simpletimetracker.R
import com.example.util.simpletimetracker.TimeTrackerApp
import com.example.util.simpletimetracker.navigation.Router
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var router: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        (application as TimeTrackerApp).appComponent?.inject(this)
        router.bind(this)
    }
}
