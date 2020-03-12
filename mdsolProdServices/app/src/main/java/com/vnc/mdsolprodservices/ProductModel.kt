package com.vnc.mdsolprodservices

import java.io.Serializable
import java.util.*

data class ProductModel(val productName: String = "",
                        val productdetails: String = "",
                        val productIcon: Double = 0.0) : Serializable