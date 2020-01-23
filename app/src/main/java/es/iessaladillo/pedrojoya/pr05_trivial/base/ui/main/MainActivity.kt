package com.example.myapplication.es.iessaladillo.pedrojoya.pr05_trivial.base.ui.main

import ConfirmationDialogFragment
import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.commit
import androidx.preference.PreferenceManager
import es.iessaladillo.pedrojoya.pr05_trivial.R
import es.iessaladillo.pedrojoya.pr05_trivial.base.ui.title.TitleFragment
import kotlinx.android.synthetic.main.activity_main.*

fun settings(context: Context): SharedPreferences {

   return PreferenceManager.getDefaultSharedPreferences(context)

}


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupAppBar()
        if (savedInstanceState == null) {

            navigateToInitialDestination()

        }
    }

    private fun navigateToInitialDestination() {
        supportFragmentManager.commit {

            replace(R.id.fcContent, TitleFragment.newInstance())

        }

    }

    private fun setupAppBar() {

        setSupportActionBar(toolbar)

    }

    override fun onSupportNavigateUp(): Boolean {

        if (settings(this).getBoolean("2", false)) {

            showConfirmationDialog()

        }

        else {

            onBackPressed()

        }
        return true
    }

    private fun showConfirmationDialog() {

        ConfirmationDialogFragment()

            .show(supportFragmentManager.findFragmentById(R.id.fcContent)!!.requireFragmentManager(), "ConfirmationDialog")

    }


}