package com.example.moocows_food_app.Model

data class FoodModel(
    var title: String = "",
    var picUrl: String = "",
    var description: String = "",
    var price: Double = 0.0,
    var categoryId: String = "",
    var numberInCart: Int = 0
)
