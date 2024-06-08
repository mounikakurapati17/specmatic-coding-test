package com.store.service

import com.store.models.Product
import com.store.models.ProductDetails
import com.store.models.ProductType
import com.store.repository.ProductRepository

class ProductService {

    private val productRepository: ProductRepository = ProductRepository();

    fun validateProductDetails(productDetails: ProductDetails): String? {
        if (productDetails.name.isEmpty() ||
            productDetails.name.toBooleanStrictOrNull() != null
            || productDetails.name.toDoubleOrNull() != null
        ) {
            return "Product name is required"
        }
        if (productDetails.inventory == null) {
            return "Inventory is required"
        }
        if (productDetails.inventory < 0) {
            return "Inventory cannot be negative"
        }
        if (productDetails.cost == null || productDetails.cost <= 0) {
            return "Cost should be greater than 0"
        }
        return null
    }

    fun add(productDetails: ProductDetails): Int {
        return productRepository.add(productDetails)
    }

    fun getProductBasedOnType(type: ProductType?): List<Product> {
    return productRepository.all.filter { it.type == type }
    }

}