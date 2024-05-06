package com.example.valyutakursi


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView





class MyAdapter(val context: Context, val list:ArrayList<KursX>, val rvClick: RvClick): RecyclerView.Adapter<MyAdapter.VH>() {
    inner class VH(var itemRv: View):RecyclerView.ViewHolder(itemRv){
        fun onBind(kurs: KursX){
            itemRv.findViewById<TextView>(R.id.itemCountryText).text=kurs.title
            itemRv.findViewById<TextView>(R.id.itemTextMoney).text =kurs.cb_price

            itemRv.setOnClickListener {
                rvClick.onClick(kurs)
            }



        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
    interface RvClick{
        fun onClick(kurs: KursX)
    }
}