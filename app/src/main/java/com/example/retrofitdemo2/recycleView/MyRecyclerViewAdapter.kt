package com.example.retrofitdemo2.recycleView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import android.widget.TextView
import androidx.lifecycle.viewmodel.savedstate.R
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.retrofitdemo2.models.AlbumsItem

class MyRecyclerViewAdapter:androidx.recyclerview.widget.ListAdapter<AlbumsItem,MyRecyclerViewAdapter.MyViewHolder>(DiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view  = LayoutInflater.from(parent.context)
            .inflate(com.example.retrofitdemo2.R.layout.list_item,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class MyViewHolder(val view:View):ViewHolder(view){

        val id = view.findViewById<TextView>(com.example.retrofitdemo2.R.id.id_tv)
        val title = view.findViewById<TextView>(com.example.retrofitdemo2.R.id.title_tv)
        val userId = view.findViewById<TextView>(com.example.retrofitdemo2.R.id.userId_tv)
        fun bind(item:AlbumsItem){
            id.text = item.id.toString()
            title.text = item.title.toString()
            userId.text = item.userId.toString()
        }
    }
    class DiffUtil : androidx.recyclerview.widget.DiffUtil.ItemCallback<AlbumsItem>(){
        override fun areItemsTheSame(oldItem: AlbumsItem, newItem: AlbumsItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: AlbumsItem, newItem: AlbumsItem): Boolean {
            return oldItem == newItem
        }
    }

}