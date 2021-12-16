package com.example.todolist.data

import com.example.todolist.model.Todo

 class DataSource {

fun loadList():MutableList<Todo>{ return myList }



    fun addTask(task:Todo){
        myList.add(task)
    }
    fun deleteTask(index:Int){
        myList.removeAt(index)
    }

     fun updateTask(task: Todo, index: Int){
         myList[index] = task
     }
}



var myList :MutableList<Todo> = mutableListOf(

    Todo("amal","you are beautiful ", "28-10-2021","19-11-2021",false),
    Todo("list","todo list for today","20-11-2021","20-11-2021",true),
    Todo("kotlin","kotlin make developers happy","11-11-2021","20-20-2021",true)
)