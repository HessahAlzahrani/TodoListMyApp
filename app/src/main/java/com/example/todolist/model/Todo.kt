package com.example.todolist.model

data class Todo (val title:String

                 , var describtion:String

                 , var w_date:String

                 , val c_date:String = "",

                 var comletd: Boolean = false
)