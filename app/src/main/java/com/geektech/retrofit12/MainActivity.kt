package com.geektech.retrofit12

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.geektech.retrofit12.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: ActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.requestFragment,
                R.id.resultFragment,
                R.id.onBoardFragment,
                R.id.onBoardFirstFragment,
                R.id.historyFragment

            )
        )
        if(viewModel.getHaveSeenBoarding())
            navController.navigate(R.id.requestFragment)
        else
            navController.navigate(R.id.onBoardFirstFragment)

        navController.addOnDestinationChangedListener{ _,dest,_ ->

       navView.visibility=
           if(dest.id==R.id.onBoardFragment||dest.id==R.id.onBoardFirstFragment) View.GONE
            else View.VISIBLE
        }
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}