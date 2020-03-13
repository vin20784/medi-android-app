package com.vnc.mdsolprodservices

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.layout_adapter.*


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

        var infview =  inflater.inflate(R.layout.fragment_product_details, container, false)
        var productModel = arguments?.getSerializable("Product_Model") as ProductModel
        productName.text   // = productModel.productName
        productDetails.text //= productModel.productdetails
        return infview
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProductDetailsFragment.
         */

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
