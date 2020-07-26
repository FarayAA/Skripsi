package com.example.skripsi.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.skirpsi.Detail_Event
import com.example.skirpsi.R
import com.example.skirpsi.model.DataEvent
import com.example.skirpsi.model.ResponseEvent
import retrofit2.Callback


class EventListAdapter (val mainActivity: Callback<ResponseEvent>, val mData: List<DataEvent> ): RecyclerView.Adapter<EventListAdapter.MyHolder>() {

    override fun getItemCount(): Int =mData.size


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyHolder {
        val view: View = LayoutInflater.from(p0.context)
            .inflate(R.layout.item_event_list, p0, false)
        return MyHolder(view)
    }


    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvEvent: TextView = itemView.findViewById(R.id.txevent)
        fun bind(mData: DataEvent){
            tvEvent.text = mData.namaEvent

            itemView.setOnClickListener{
                var intent= Intent(itemView.context, Detail_Event::class.java)
                 intent.putExtra(Detail_Event.EXTRA_MOVIE, mData)
                intent.putExtra("id",mData!!.idEvent)
                itemView.context.startActivity(intent)
            }
//
        }
    }

    override fun onBindViewHolder(holder: EventListAdapter.MyHolder, position: Int) = holder.bind(mData.get(position))

}