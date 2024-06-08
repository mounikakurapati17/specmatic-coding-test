package com.store.models
import com.fasterxml.jackson.annotation.JsonProperty
import io.micrometer.core.lang.NonNull
import javax.validation.constraints.NotNull

data class Product(
    @JsonProperty("id") @NonNull val id: Int,
    @JsonProperty("type") @NonNull val type: ProductType,
    @JsonProperty("name") @NonNull val name: String,
    @JsonProperty("inventory") @NonNull val inventory: Int,
    @JsonProperty("cost") val cost: Int
)

enum class ProductType {
    book, food, gadget, other
}

data class ProductDetails(
    @JsonProperty("name") val name: String,
    @JsonProperty("type") val type: ProductType,
    @JsonProperty("inventory") val inventory: Int?,
    @JsonProperty("cost") val cost: Int?
)

data class ProductId(
    @JsonProperty("id") val id: Int
)

data class ErrorResponseBody(
    @JsonProperty("timestamp") val timestamp: String,
    @JsonProperty("status") val status: Int,
    @JsonProperty("error") val error: String,
    @JsonProperty("path") val path: String
)
