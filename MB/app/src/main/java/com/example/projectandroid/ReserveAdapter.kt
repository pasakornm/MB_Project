package com.example.projectandroid

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.canclereserve.view.*
import java.text.SimpleDateFormat

class ReserveAdapter: RecyclerView.Adapter<ReserveAdapter.ViewHolder> {
    var reserve: List<Reserve>
    var context: Context
    var cancelOnClickListener: CancelOnClickListener
    constructor(reserve: List<Reserve>, context: Context, cancelOnClickListener: CancelOnClickListener){
        this.reserve = reserve
        this.context = context
        this.cancelOnClickListener = cancelOnClickListener
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        val rev_id2 = view.Rev_ID2
        val cussid2 = view.Cuss_ID2
        val resdt2 = view.Res_DT2
        val indt2 = view.In_DT2
        val outdt2 = view.Out_DT2
        val totalpc2 = view.Total_PC2
        val recancle = view.reservecancle
        val roomtype2 = view.Room_Type2

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.canclereserve, parent, false)
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

        holder.recancle.setOnClickListener(){
            cancelOnClickListener.onClickRemove(reserve[position])

        }
    }

    override fun getItemCount(): Int {
        return reserve.size
    }
}