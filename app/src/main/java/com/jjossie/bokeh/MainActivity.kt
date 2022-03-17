package com.jjossie.bokeh

import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.jjossie.bokeh.data.Repository
import com.jjossie.bokeh.data.model.CompletionConditionType
import com.jjossie.bokeh.data.model.GoalList
import com.jjossie.bokeh.data.model.Todo
import com.jjossie.bokeh.data.model.TodoList
import com.jjossie.bokeh.ui.todo.TodoViewModel

class MainActivity : AppCompatActivity() {

    val repo = Repository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Set up ViewModel // Not necessary
//        val viewModel: TodoViewModel by viewModels()

        // Set Up Navigation (code provided by Android Studio Template)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


    }


}