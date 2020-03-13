package com.vnc.mdsolprodservices

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProductListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProductListFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_product_list, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,false)

        val dataList = ArrayList<ProductModel>()
        dataList.add(ProductModel("eCOA ", "Patient Cloud","https://www.medidata.com/en/products/ecoa/",4.8))
        dataList.add(ProductModel("eConsent", "Patient Cloud", "https://www.medidata.com/en/products/econsent/",4.3))
        dataList.add(ProductModel("Virtual Trials", "Patient Cloud","https://www.medidata.com/en/products-virtual-trials/",4.1))
        dataList.add(ProductModel("eTMF", "Trial Management","https://www.medidata.com/en/products/etmf/",0.0))
        dataList.add(ProductModel("CTMS",  "Trial Management","https://www.medidata.com/en/products/ctms/" ,4.2))
        dataList.add(ProductModel("CSA",  "Trial Management" ,"https://www.medidata.com/en/products/centralized-statistical-analytics/",4.2))
        dataList.add(ProductModel("RBQM",  "Trial Management","https://www.medidata.com/en/products/rbm/" ,4.4))

        val rvAdapter = RcViewAdapter(container?.context!!,dataList)
        recyclerView.adapter = rvAdapter;

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProductListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                ProductListFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
