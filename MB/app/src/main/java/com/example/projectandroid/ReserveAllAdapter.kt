package com.example.projectandroid

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.allreserve.view.*
import java.text.SimpleDateFormat


class ReserveAllAdapter: RecyclerView.Adapter<ReserveAllAdapter.ViewHolder> {
    var reserve: List<Reserve>
    var context: Context
    constructor(reserve: List<Reserve>, context: Context){
        this.reserve = reserve
        this.context = context
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        val rev_id2 = view.Rev_ID2all
        val cussid2 = view.Cuss_ID2all
        val resdt2 = view.Res_DT2all
        val indt2 = view.In_DT2all
        val outdt2 = view.Out_DT2all
        val totalpc2 = view.Total_PC2all
        val roomtype2 = view.Room_Type2all

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.allreserve, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.rev_id2.text = reserve[position].Reserve_ID.toString()
        holder.cussid2.text = reserve[position].Cus_ID.toString()
        val formatDate = SimpleDateFormat("dd/MM/YYY HH:mm")
        val Date = formatDate.format(reserve[position].Reserve_Date)
        holder.resdt2.text = Date.toString()
        holder.indt2.text = reserve[position].Check_In_Date
        holder.outdt2.text = reserve[position].Check_Out_Date
        holder.totalpc2.text = reserve[position].Total_Price.toString()
        holder.roomtype2.text = reserve[position].Room_Type.toString()
    }

    override fun getItemCount(): Int {
        return reserve.size
    }
}