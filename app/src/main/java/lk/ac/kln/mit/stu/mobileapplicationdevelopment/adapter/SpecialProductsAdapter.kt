package lk.ac.kln.mit.stu.mobileapplicationdevelopment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import lk.ac.kln.mit.stu.mobileapplicationdevelopment.data.Product
import lk.ac.kln.mit.stu.mobileapplicationdevelopment.databinding.SpecialRvItemBinding

class SpecialProductsAdapter : RecyclerView.Adapter<SpecialProductsAdapter.SpecialProductsViewHolder>(){
    inner class SpecialProductsViewHolder(private val binding : SpecialRvItemBinding ): RecyclerView.ViewHolder(binding.root)

    val diffCallback = object: DiffUtil.ItemCallback<Product>(){
        override fun areItemsTheSame(oldItem: Product, newItem:Product): Boolean{
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem ==newItem
        }
    }
    
    val differ = AsyncListDiffer(this, diffCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecialProductsViewHolder {
        return SpecialProductsViewHolder(
            SpecialRvItemBinding.inflate(
                LayoutInflater.from(parent.context), parent,false
            )
        )
    }

    override fun onBindViewHolder(holder: SpecialProductsViewHolder, position: Int) {
//       val product = differ.currentList(position)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}