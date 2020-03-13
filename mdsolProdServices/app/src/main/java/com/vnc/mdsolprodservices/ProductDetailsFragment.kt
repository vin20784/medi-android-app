package com.vnc.mdsolprodservices

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProductDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProductDetailsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {



        }
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_product_details, container, false)
        val productModel = arguments?.getSerializable("Product_Model") as ProductModel
        val productName = view.findViewById<TextView>(R.id.productNameT)
        val productDetails = view.findViewById<TextView>(R.id.productDetailsT)
        val productUrl = view.findViewById<TextView>(R.id.productUrlT)

        val addSign = view.findViewById<Button>(R.id.signBtn)
        addSign.setOnClickListener {

        }

        productName.setText(productModel.productName)
        productDetails.setText(productModel.productdetails)
        productUrl.setText(productModel.url)

        productUrl.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW)
            browserIntent.data = Uri.parse("https://www.medidata.com/en/products/ecoa/")
            startActivity(browserIntent)
        }
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(productModel: ProductModel?): ProductDetailsFragment? {
            val fragment = ProductDetailsFragment()
            val bundle = Bundle()
            bundle.putSerializable("Product_Model", productModel)
            fragment.setArguments(bundle)
            return fragment
        }
    }
}
