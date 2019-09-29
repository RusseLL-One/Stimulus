package com.one.russell.stimulus

import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI

class Utils {

    companion object {
        fun getNavController(activity: FragmentActivity?): NavController? {
            return if (activity != null) {
                Navigation.findNavController(activity, R.id.nav_host_fragment)
            } else {
                null
            }
        }

        fun setupToolbar(toolbar: Toolbar?, navController: NavController?) {
            if (toolbar != null && navController != null) {
                NavigationUI.setupWithNavController(toolbar, navController)
            }
        }


    }
}