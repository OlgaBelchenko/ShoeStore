package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {

    private val _shoes = MutableLiveData<MutableList<Shoe>>()
    val shoes: LiveData<MutableList<Shoe>> = _shoes
    private var _shoesCount = MutableLiveData(0)
    val shoesCount: LiveData<Int>
        get() = _shoesCount

    private fun addShoe(shoe: Shoe) {
        _shoes.value?.add(shoe)
    }

    private fun addTextView() {
        // TODO()
    }


}