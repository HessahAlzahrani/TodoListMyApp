package com.example.todolist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.todolist.data.DataSource
import com.example.todolist.databinding.FragmentAddBinding
import com.example.todolist.model.Todo


class AddFragment : Fragment() {

    var binding: FragmentAddBinding? = null

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentAddBinding.inflate(inflater, container, false)
        return binding!!.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.button2id?.setOnClickListener {
           // DataSource().addTask(Todo1("hessah", "gdsak", "3e","yyue", true))

            DataSource().addTask(Todo(
                binding?.wTitelid?.text.toString(),binding?.describtionDi?.text.toString()
                , binding?.daydateid?.text.toString(),binding?.createdateid?.text.toString(), false))
            findNavController().navigate(R.id.action_add2_to_start2)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}