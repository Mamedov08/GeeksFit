package com.example.geeksfit.ui.pay.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.geeksfit.databinding.ItemPayBinding
import com.example.geeksfit.ui.pay.model.Pay



class PayAdapter (

    private val data: ArrayList<Pay>,
    private val onClick: (model: Pay) -> Unit
    ) :
    RecyclerView.Adapter<PayAdapter.PayViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PayViewHolder {
        return PayViewHolder(
            ItemPayBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: PayViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    inner class PayViewHolder(private val binding: ItemPayBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(pay: Pay) {
            binding.cardVO.text = pay.month
            binding.cardVS.text = pay.title
            binding.cardVT.text = pay.desc

            itemView.setOnClickListener {
                onClick(pay)
            }
        }
    }
}



