package com.example.moocows_food_app.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.moocows_food_app.Model.CategoryModel
import com.example.moocows_food_app.Model.FoodModel
import com.example.moocows_food_app.Repository.MainRepository

class MainViewModel: ViewModel() {
    private val repository = MainRepository()

    fun loadCategory(): LiveData<MutableList<CategoryModel>> {
        return repository.loadCategory()
    }

    fun loadPopular(): LiveData<MutableList<FoodModel>> {
        return repository.loadPopular()
    }
}