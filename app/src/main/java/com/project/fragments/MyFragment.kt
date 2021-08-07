package com.project.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MyFragment : Fragment() {


    private lateinit var caller: OnRemoveFragmentButtonClickListener

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_my, container, false)

        val removeButton = view.findViewById<Button>(R.id.remove_btn)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(activity as Context)

        val items = arrayOf("New Delhi", "Mumbai", "Bangalore", "Chennai", "Gujarat", "Punjab", "Hyderabad", "Kolkata")

        recyclerView.adapter = ListAdapter(items)

        removeButton.setOnClickListener {

            caller.onRemoveFragmentClicked()

        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is OnRemoveFragmentButtonClickListener) caller = context
    }

    companion object {
        fun newInstance(): Fragment
        {
            return MyFragment()
        }
    }
}