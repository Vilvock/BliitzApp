package com.bliitz.app.main_ui.fragment.menu.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bliitz.app.R
import com.bliitz.app.global_ui.config_fragment.BaseFragment


/**
 * A simple [Fragment] subclass.
 */
class UserDataFragment : BaseFragment() {

    override var hasBackButton: Boolean = true
    override var toolbarVisibility: Boolean = true

    override var title: String = "Meu perfil"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_data, container, false)
    }

}