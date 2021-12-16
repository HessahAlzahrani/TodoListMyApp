package com.example.todolist.adapter

import android.content.Context
import android.content.Intent
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.StartFragmentDirections
import com.example.todolist.model.Todo
import com.google.android.material.dialog.MaterialAlertDialogBuilder


// create parent class adapter
// datasurs111 it's = mian it is mutablelist <data class modea data >


class TodoAdapter (private var context :Context,
                private var dataset: MutableList<Todo>, private val view: View ) :RecyclerView.Adapter<TodoAdapter.viewHolder1>() {


//create sup class

    class viewHolder1(private var view: View) : RecyclerView.ViewHolder(view) {
        //inside sup class, find view by Id from itemxml
        val textView: TextView = view.findViewById(R.id.titelid)
        val textView_d: TextView = view.findViewById(R.id.dateid)
        val shekbooks: CheckBox = view.findViewById(R.id.checkBoxid)
       // val editTextdate: TextView = view.findViewById(R.id.date2id)
        // for create click on item (like one item = button ) :
        val itemLayout: ConstraintLayout = view.findViewById(R.id.itemid)
    }// end sup class


    // implement methode for adapter inside parent class
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder1 {

        //need return : inflate layout for sup class (viewHolder1)
        return viewHolder1(
            LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        )

    }   //end fun onCreateViewHolder


    // this fun for edit any info on recyclerview and item
    //    and link textview and value item :

    override fun onBindViewHolder(holder: viewHolder1, position: Int) {

        // inflate data in model on var
        val item = dataset[position]


        // link a views on sup class with data model

        holder.textView.text = item.title
        holder.textView_d.text = item.w_date
        holder.shekbooks.isChecked = item.comletd

      //  holder.editTextdate.setText(item.c_date)

        if (item.comletd) {
            holder.shekbooks.isChecked = true
            holder.textView.paintFlags =
                holder.textView.paintFlags.or(Paint.STRIKE_THRU_TEXT_FLAG)
        }

        holder.shekbooks.setOnClickListener {
            if (holder.shekbooks.isChecked) {
                item.comletd = true
                holder.textView.paintFlags =
                    holder.textView.paintFlags.or(Paint.STRIKE_THRU_TEXT_FLAG)
              //  notifyItemMoved(position, dataset.size - 1)

            } else {
                item.comletd = false
                holder.textView.paintFlags = 0
             //   notifyItemMoved(position, 0)
            }

        }
        //// link item in
        holder.itemLayout.setOnClickListener {
            // #############
            var actionForNafigatArgument = StartFragmentDirections.actionStart2ToDetails(

                titel = item.title, description = item.describtion,date1 = item.c_date,date2 = item.w_date, postion = position)
            ///#####
            view.findNavController().navigate(actionForNafigatArgument)

           // R.id.action_start2_to_details xxxxxx
        }


        ///line 2 = the cod for card delete ( yas - no )
        //// line 1 = make item like button wine long click item

        holder.itemLayout.setOnLongClickListener {
            MaterialAlertDialogBuilder(context)
                .setTitle(context.getString(android.R.string.dialog_alert_title))
                .setMessage(context.getString(R.string.delete_question))
                .setCancelable(false)
                .setNegativeButton(context.getString(R.string.no)) { _, _ -> }
                .setPositiveButton(context.getString(R.string.yes)) { _, _ ->}

                ////  using function deleteItem() on Dialog #####
                .setPositiveButton(context.getString(R.string.yes)) { _, _ ->
                    dataset.removeAt(position)
                    notifyDataSetChanged()
                }
                .show()

            true
        }
    }


    override fun getItemCount(): Int {
        return dataset.size
    }



} // end print class
