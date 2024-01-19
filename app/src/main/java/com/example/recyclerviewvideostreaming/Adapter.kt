package com.example.recyclerviewvideostreaming

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.squareup.picasso.Picasso

class Adapter(var datalist:List<dataList>,var context: Context,val clickListener:(dataList) ->Unit) : RecyclerView.Adapter<MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view=LayoutInflater.from(context).inflate(R.layout.view_item,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
       return datalist.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val video=datalist[position]

        holder.bind(video,clickListener)
    }
}
class MyViewHolder(var view: View):RecyclerView.ViewHolder(view){
  fun bind(video: dataList,clickListener:(dataList)->Unit) {
      val vName = view.findViewById<TextView>(R.id.vName)
      val bPlay =view.findViewById<ImageView>(R.id.bPlay)
      val image = view.findViewById<ImageView>(R.id.imageView)
      val duratin = view.findViewById<TextView>(R.id.tvDuration)
      vName.text = video.vName
      duratin.text=video.duration
      Picasso.get().load(video.image).into(image)
      bPlay.setOnClickListener(){
          clickListener(video)
      }


  }

}