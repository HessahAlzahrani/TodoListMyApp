package com.example.todolist.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todolist.model.Todo

class viewModel :ViewModel(){


    /* link model(data class<Todo>) with viewModel for function */

    ///// -titel = privet val * title = liveData for -title
//

     val _title = MutableLiveData<String>()
    val title: LiveData<String> = _title

     val _describtion = MutableLiveData<String>()
    val describtion: LiveData<String> = _describtion

     val _w_date = MutableLiveData<String>()
    val w_date: LiveData<String> = _w_date


     val _c_date = MutableLiveData<String>()
    val c_date: LiveData<String> = _c_date


     val _comletd = MutableLiveData<Boolean>()
    val comletd: LiveData<Boolean> = _comletd



    //this function for get variable value on function , because you can use it as function

    fun f1title (fffTitle:String){
        _title.value=fffTitle
    }

    fun f1describtion(fffdescribtion:String){
    _describtion.value=fffdescribtion
    }

    fun f1w_date(fffw_date:String){
        _w_date.value=fffw_date
    }

    fun _f1c_date(fffc_date:String){
        _c_date.value=fffc_date
    }

    fun f1comletd(fffcomletd:Boolean){
        _comletd.value=fffcomletd
    }


}