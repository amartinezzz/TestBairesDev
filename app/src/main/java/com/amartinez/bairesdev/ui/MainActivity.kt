package com.amartinez.bairesdev.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.amartinez.bairesdev.R
import com.amartinez.bairesdev.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binder: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )
        setContentView(binder.root)

        binder.ivMenu.setOnClickListener {
            binder.drawerLayout.openDrawer(GravityCompat.START)
        }

        binder.tvGoogle.setOnClickListener {
            Navigation.findNavController(this,
                R.id.nav_host_fragment
            ).navigate(R.id.googleFragment)
            binder.drawerLayout.close()
        }

        binder.tvButtons.setOnClickListener {
            Navigation.findNavController(this,
                R.id.nav_host_fragment
            ).navigate(R.id.buttonFragment)
            binder.drawerLayout.close()
        }

        binder.tvGithub.setOnClickListener {
            Navigation.findNavController(this,
                R.id.nav_host_fragment
            ).navigate(R.id.githubFragment)
            binder.drawerLayout.close()
        }
    }
}