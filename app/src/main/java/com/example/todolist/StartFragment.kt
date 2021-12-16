package com.example.todolist

import android.database.DatabaseUtils
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

import com.example.todolist.adapter.TodoAdapter
import com.example.todolist.data.DataSource
import com.example.todolist.databinding.FragmentStartBinding


class StartFragment : Fragment() {

    var binding: FragmentStartBinding? = null



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentStartBinding.inflate(inflater, container, false)
        return  binding?.root!!

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.rid?.adapter = TodoAdapter(requireContext(), DataSource().loadList(), view)




        // navigate to add fragment (Button)

        binding?.buttonId?.setOnClickListener {
            findNavController().navigate(R.id.action_start2_to_add2)
        }
    }



    override fun onDestroy() {
        super.onDestroy()
    }

}









