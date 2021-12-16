package com.example.todolist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.todolist.data.DataSource
import com.example.todolist.databinding.FragmentDetailsBinding
import com.example.todolist.model.Todo


class DetailsFragment : Fragment() {
    var binding: FragmentDetailsBinding? = null



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding!!.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var index: Int? = 0

        super.onViewCreated(view, savedInstanceState)

        arguments.let {
            binding?.apply {
                index = it?.getInt("postion")
                textViewtitelId.setText(it?.getString("titel"))
                textViewdate1Id.setText(it?.getString("date1"))
                textViewdescriptionId.setText(it?.getString("description"))
                textViewdate2Id.text=it?.getString("date2")


            }

        }

        binding?.button?.setOnClickListener {
            DataSource().updateTask(Todo(binding?.textViewtitelId?.text.toString(),
                binding?.textViewdescriptionId?.text.toString(),
            binding?.textViewdate1Id?.text.toString()), index!!)
            ////
            findNavController().navigate(R.id.action_details_to_start2)
        }
    }



    override fun onDestroy() {
        super.onDestroy()
    }
}