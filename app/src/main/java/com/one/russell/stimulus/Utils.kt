package com.one.russell.stimulus

import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.one.russell.stimulus.domain.Repository

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

        fun getRepository(activity: FragmentActivity?): Repository? {
            return if (activity != null) {
                (activity.application as App).getRepository()
            } else {
                null
            }
        }

    }
}