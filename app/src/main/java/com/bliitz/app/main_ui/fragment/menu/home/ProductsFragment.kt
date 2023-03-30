package com.bliitz.app.main_ui.fragment.menu.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bliitz.app.R
import com.bliitz.app.global_ui.config_fragment.BaseFragment
import com.bliitz.app.main_ui.adapter.ProductAdapter
import com.bliitz.app.util.RecyclerItemListener
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class ProductsFragment : BaseFragment() {


    override var toolbarVisibility: Boolean = true
    override var hasBackButton: Boolean = true
    override var bottomNavigationVisibility: Boolean = false

    override var title: String = "Lista de ofertas"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_products, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = ArrayList<Any>()

        list.add(Any())
        list.add(Any())
        list.add(Any())
        list.add(Any())
        list.add(Any())


        val adapter = ProductAdapter(requireActivity(), list, object : RecyclerItemListener {
            override fun onClickListenerItem(item: Any?) {
                super.onClickListenerItem(item)

                navigation.navigate(R.id.action_productsFragment_to_productDetailFragment)
            }

        })
        val layoutManagerRv: RecyclerView.LayoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        products_rv.layoutManager = layoutManagerRv
        products_rv.adapter = adapter
    }

}