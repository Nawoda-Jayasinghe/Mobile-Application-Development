package lk.ac.kln.mit.stu.mobileapplicationdevelopment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import lk.ac.kln.mit.stu.mobileapplicationdevelopment.R

class DataAdapter(private val orderDetails : ArrayList<lk.ac.kln.mit.stu.mobileapplicationdevelopment.data.OrderDetail>) : RecyclerView.Adapter<DataAdapter.MyViewHolder>()  {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.order_details,parent,false)
        return MyViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentitem = orderDetails[position]

        holder.ProductName.text = currentitem.ProductName
        holder.ItemCode.text = currentitem.ItemCode
        holder.Color.text = currentitem.Color
        holder.Price.text = currentitem.Price
        holder.Address.text = currentitem.Address
        holder.Status.text = currentitem.Status
    }

    override fun getItemCount(): Int {

        return orderDetails.size
    }

    //constructor class MyViewHolder will take one arg 'itemView' and the type is 'View'
    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val ProductName : TextView = itemView.findViewById(R.id.tvProductName)
        val ItemCode : TextView = itemView.findViewById(R.id.tvItemCode)
        val Color : TextView = itemView.findViewById(R.id.tvColor)
        val Price : TextView = itemView.findViewById(R.id.tvPrice)
        val Address : TextView = itemView.findViewById(R.id.tvAddress)
        val Status : TextView = itemView.findViewById(R.id.tvStatus)

    }
}