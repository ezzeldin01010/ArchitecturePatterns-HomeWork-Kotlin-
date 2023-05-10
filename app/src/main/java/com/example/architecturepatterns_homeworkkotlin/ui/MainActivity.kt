package com.example.architecturepatterns_homeworkkotlin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.architecturepatterns_homeworkkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ModelInterface {

    private lateinit var binding: ActivityMainBinding

    private var presenter = ModelPresenter(this)
    private lateinit var numberViewModel: NumberViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        observeOnMutableLiveData()
        setListeners()
    }

    //MVC Architecture Pattern
    private fun addNumbers(): Int {
        return binding.firstTextView.text.toString()
            .toInt() + binding.secondTextView.text.toString().toInt()
    }

    //MVP Architecture Pattern
    override fun onGetData(num: Int) {
        binding.divResultTextView.text = num.toString()
    }

    //MVVM Architecture Pattern
    private fun observeOnMutableLiveData(){
        numberViewModel = ViewModelProvider(this)[NumberViewModel::class.java]
        numberViewModel.numMutableLiveData.observe(this, object : Observer<Int> {
            override fun onChanged(t: Int?) {
                binding.mulResultTextView.text = t.toString()
            }
        })
    }

    private fun setListeners(){
        //MVC Architecture Pattern
        binding.plusButton.setOnClickListener {
            binding.plusResultTextView.text = addNumbers().toString()
        }
        //MVP Architecture Pattern
        binding.divButton.setOnClickListener {
            presenter.getResult()
        }
        //MVVM Architecture Pattern
        binding.mulButton.setOnClickListener {
            numberViewModel.getResult()

        }

    }


}