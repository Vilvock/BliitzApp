package com.bliitz.app.main_ui.fragment.menu.favorites

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bliitz.app.R
import com.bliitz.app.global_ui.config_fragment.BaseFragment
import com.bliitz.app.util.RecyclerItemListener

/**
 * A simple [Fragment] subclass.
 */
class FavoritesFragment : BaseFragment() {

    override var toolbarVisibility: Boolean = true
    override var bottomNavigationVisibility: Boolean = true


    override var title: String = "Meus Favoritos"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val list = ArrayList<Any>()
//
//        list.add(Any())
//        list.add(Any())
//        list.add(Any())
//        list.add(Any())
//        list.add(Any())
//
//        val adapter = FavoriteAdapter(requireActivity(), list, object : RecyclerItemListener {
//            override fun onClickListenerItem(item: Any?) {
//                super.onClickListenerItem(item)
//
//                navigation.navigate(R.id.action_favoritesFragment_to_productDetailFragment)
//            }
//
//        })
//        val layoutManagerRv: RecyclerView.LayoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
//
//        favorites_rv.layoutManager = layoutManagerRv
//        favorites_rv.adapter = adapter
    }


}