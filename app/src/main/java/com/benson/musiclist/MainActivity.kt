package com.benson.musiclist

import android.content.Intent
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row_function.view.*

class MainActivity : AppCompatActivity() {
    val Tag = MainActivity::class.java.simpleName
    val functions = listOf<String>(
        "English",
        "Chinese",
        "Japanese",
        "Italian",
        "Others")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //RecyclyerView

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.setHasFixedSize(true)
        recycler.adapter = FunctionAdapter()
    }

    inner class FunctionAdapter() : RecyclerView.Adapter<FunctionHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FunctionHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.row_function,parent,false)
            val holder = FunctionHolder(view)
            return holder
        }

        override fun getItemCount(): Int {
            return functions.size
        }

        override fun onBindViewHolder(holder: FunctionHolder, position: Int) {
            holder.englishText.text = functions.get(position)
            holder.itemView.setOnClickListener {
                functionClicked(position)
            }
        }
    }

    private fun functionClicked(position: Int) {
        when(position) {
            1 -> startActivity(Intent(this,MaterialActivty::class.java))
            else -> return
        }
    }


    class FunctionHolder(view : View) : RecyclerView.ViewHolder(view) {
       var  englishText: TextView = view.english
    }

}
