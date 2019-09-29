package com.one.russell.stimulus

import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation

class Utils {

    companion object {
        fun getNavController(activity: FragmentActivity?): NavController? {
            return if (activity != null) {
                Navigation.findNavController(activity, R.id.nav_host_fragment)
            } else {
                null
            }
        }


    }
}