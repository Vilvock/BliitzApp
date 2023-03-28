package com.bliitz.app.main_ui.fragment.menu.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bliitz.app.R

class PhotoContainerFrag(private val url: String) : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_photo_container, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


//        if (url != "") {
//            Picasso.get()
//                .load(WSConstants.URL_AVATAR_TRUCKS + url).into(fragment_image)
//        } else {
//            fragment_image.setImageResource(R.drawable.icon_512)
//        }
    }
}