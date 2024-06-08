package com.store.controllers

import com.store.models.*
import com.store.repository.ProductRepository
import com.store.service.ProductService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.validation.Valid

@RestController
class ProductsController {

    private val productService: ProductService = ProductService();

    @GetMapping("/products")
    fun getProducts(@RequestParam(required = false) type: ProductType?): ResponseEntity<List<Product>> {
        return ResponseEntity.ok(productService.getProductBasedOnType(type))
    }

    @PostMapping("/products")
    fun addProducts(@RequestBody @Valid productDetails: ProductDetails): ResponseEntity<Any> {
        if (productService.validateProductDetails(productDetails) != null) {
            val errorResponse = ErrorResponseBody(
                timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                status = HttpStatus.BAD_REQUEST.value(),
                error = "Invalid product details provided",
                path = "/products"
            )
            return ResponseEntity.badRequest().body(errorResponse)
        }
        val id = productService.add(productDetails)
        return ResponseEntity(ProductId(id), HttpStatus.CREATED)
    }

}
