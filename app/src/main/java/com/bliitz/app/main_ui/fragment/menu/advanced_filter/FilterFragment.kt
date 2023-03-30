package com.bliitz.app.main_ui.fragment.menu.advanced_filter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bliitz.app.R
import com.bliitz.app.global_ui.config_fragment.BaseFragment
import com.bliitz.app.main_ui.adapter.CategoryAdapter
import com.bliitz.app.main_ui.adapter.StaggeredCategoryAdapter
import com.bliitz.app.util.RecyclerItemListener
import kotlinx.android.synthetic.main.fragment_filter.*


/**
 * A simple [Fragment] subclass.
 */
class FilterFragment : BaseFragment() {

    override var toolbarVisibility: Boolean = true
    override var bottomNavigationVisibility: Boolean = true

    override var title: String = "Filtro de ofertas"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_filter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        rangeSlider.valueFrom = 0f
        rangeSlider.valueTo = 1000f

        var currency = " R$"

        val valueList = ArrayList<Float>()

        valueList.add(0f)
        valueList.add(1000f)


        rangeSlider.values = valueList

        rangeSlider.setLabelFormatter { value: Float ->
            String.format("%.2f $currency", value)
        }

        filter_bt.setOnClickListener {
            navigation.navigate(R.id.action_filterFragment_to_filterResultsFragment)
        }

        val list = ArrayList<Any>()
        list.add(Any())
        list.add(Any())
        list.add(Any())
        list.add(Any())
        list.add(Any())
        list.add(Any())
        list.add(Any())


        val categoryAdapter = StaggeredCategoryAdapter(requireActivity(), list, object : RecyclerItemListener {
            override fun onClickListenerItem(item: Any?) {
                super.onClickListenerItem(item)

            }

        })
        val staggeredGridLayoutManager = StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL)

        categories_rv.layoutManager = staggeredGridLayoutManager
        categories_rv.adapter = categoryAdapter

    }

}