package com.example.skirpsi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.skirpsi.R
import com.example.skirpsi.model.DataGetDataEvent
import com.example.skirpsi.model.ResponseGetDaftarEvent
import retrofit2.Callback

class DaftarEventAdapter (val myEvent: Callback<ResponseGetDaftarEvent>, val mData: List<DataGetDataEvent> ): RecyclerView.Adapter<DaftarEventAdapter.MyHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, viewType: Int): DaftarEventAdapter.MyHolder {
        val view: View = LayoutInflater.from(p0.context)
            .inflate(R.layout.item_event_list, p0, false)
        return MyHolder(view)

    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvEvent: TextView = itemView.findViewById(R.id.txevent)
        fun bind(mData: DataGetDataEvent){
            tvEvent.text = mData.namaEvent

//            itemView.setOnClickListener{
//                var intent= Intent(itemView.context, Detail_Event::class.java)
//                intent.putExtra(Detail_Event.EXTRA_MOVIE, mData)
//                intent.putExtra("id",mData!!.idEvent)
//                itemView.context.startActivity(intent)
//            }
//
        }
    }

    override fun getItemCount(): Int =mData.size

    override fun onBindViewHolder(holder: DaftarEventAdapter.MyHolder, position: Int) = holder.bind(mData.get(position))
}