package com.example.architecturepatterns_homeworkkotlin.ui

import com.example.architecturepatterns_homeworkkotlin.pojo.NumberModel

class ModelPresenter (private val view: ModelInterface){
    private fun getNumbersFromDataBase() = NumberModel(4, 2)

    private fun divideNumbers() =
         getNumbersFromDataBase().firstNum/getNumbersFromDataBase().secondNum

    fun getResult(){
        view.onGetData(divideNumbers())
    }
}