package com.bliitz.app.main_ui.fragment.menu.home

import android.os.Bundle
import android.os.Handler
import android.view.*
import android.widget.FrameLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.bliitz.app.R
import com.bliitz.app.global_ui.components.CircleRecyclerViewDecoration
import com.bliitz.app.global_ui.config_fragment.BaseFragment
import com.bliitz.app.main_ui.adapter.*
import com.bliitz.app.util.RecyclerItemListener
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : BaseFragment() {

    override var toolbarVisibility: Boolean = true
    override var bottomNavigationVisibility: Boolean = true

    override var title: String = "Home"

    private val handler = Handler()
    private var imageRunnable = Runnable { showAnimate() }
    private var fragmentList = ArrayList<Fragment>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        loadCarrousel()
//        loadCarrouselSales()

        val list = ArrayList<Any>()

        list.add(Any())
        list.add(Any())
        list.add(Any())
        list.add(Any())
        list.add(Any())


        val adapter = ProductAdapter(requireActivity(), list, object : RecyclerItemListener {
            override fun onClickListenerItem(item: Any?) {
                super.onClickListenerItem(item)

                navigation.navigate(R.id.action_homeFragment_to_productDetailFragment)
            }

        })
        val layoutManagerRv: RecyclerView.LayoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        products_rv.layoutManager = layoutManagerRv
        products_rv.adapter = adapter

        val categoryAdapter = CategoryAdapter(requireActivity(), list, object : RecyclerItemListener {
            override fun onClickListenerItem(item: Any?) {
                super.onClickListenerItem(item)

            }

        })
        val layoutManagerRvHorizontal: RecyclerView.LayoutManager = (object : LinearLayoutManager(requireContext(), HORIZONTAL, false) {
            override fun checkLayoutParams(lp: RecyclerView.LayoutParams): Boolean {
                // force height of viewHolder here, this will override layout_height from xml
//                lp.width = (width / 2.6).toInt()
                return true
            }
        })

        categories_rv.layoutManager = layoutManagerRvHorizontal
        categories_rv.adapter = categoryAdapter

        val adapterGrid = ProductGridAdapter(requireActivity(), list, object : RecyclerItemListener {
            override fun onClickListenerItem(item: Any?) {
                super.onClickListenerItem(item)

                navigation.navigate(R.id.action_homeFragment_to_productDetailFragment)
            }

        })


        productsGrid_rv.layoutManager = GridLayoutManager(requireContext(), 2)
        productsGrid_rv.adapter = adapterGrid
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(imageRunnable)
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(imageRunnable)
    }

    override fun onStop() {
        super.onStop()
        handler.removeCallbacks(imageRunnable)
    }

    private fun showAnimate() {

        if (containerPhotosPager.currentItem == fragmentList.size - 1) {

            containerPhotosPager.currentItem = 0
        } else {

            containerPhotosPager.currentItem++
        }

        handler.postDelayed(imageRunnable, (7 * 1000).toLong())

    }

    private fun loadCarrousel() {


        fragmentList.clear()
        fragmentList.add(PhotoContainerFrag(""))
        fragmentList.add(PhotoContainerFrag(""))
        fragmentList.add(PhotoContainerFrag(""))

        val adapter = ViewPagerFragmentAdapter(requireActivity().supportFragmentManager, lifecycle, fragmentList)

        containerPhotosPager.adapter = adapter

//        indicator.setViewPager(containerPhotosPager)

        containerPhotosPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {

            }

            override fun onPageScrollStateChanged(state: Int) {}
        })

        handler.postDelayed(imageRunnable, (7 * 1000).toLong())
    }

    private fun loadCarrouselSales() {

        val photoList = ArrayList<Int>()

        photoList.add(R.drawable.main_logo1)
        photoList.add(R.drawable.main_logo2)

        val adapter = CarrouselItemAdapter(photoList)

//
//        carrousel_rv.layoutManager = (object : LinearLayoutManager(requireContext(), HORIZONTAL, false) {
//            override fun checkLayoutParams(lp: RecyclerView.LayoutParams): Boolean {
//                // force height of viewHolder here, this will override layout_height from xml
//                lp.width = (width / 1.34).toInt()
//                return true
//            }
//        })
//
//        carrousel_rv.adapter = adapter
//
//
//        carrousel_rv.addItemDecoration(CircleRecyclerViewDecoration(requireActivity()))
    }
}