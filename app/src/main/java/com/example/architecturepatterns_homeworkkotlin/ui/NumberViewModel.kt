package com.example.architecturepatterns_homeworkkotlin.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.architecturepatterns_homeworkkotlin.pojo.NumberModel

class NumberViewModel : ViewModel() {
    var numMutableLiveData = MutableLiveData<Int>()

    private fun getNumbersFromDataBase() = NumberModel(4, 2)

    private fun multiplyNumbers() =
        getNumbersFromDataBase().firstNum * getNumbersFromDataBase().secondNum

    fun getResult() {
        numMutableLiveData.value = multiplyNumbers()
    }

}