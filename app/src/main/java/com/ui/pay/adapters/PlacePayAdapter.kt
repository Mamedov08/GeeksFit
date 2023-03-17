package com.ui.pay.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.geeksfit.databinding.ItemPlacePayBinding
import com.ui.pay.model.PayPal


class PlacePayAdapter(
    private val array: ArrayList<PayPal>,
    private val onClick: (model: PayPal) -> Unit
) :
    RecyclerView.Adapter<PlacePayAdapter.PlacePayViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlacePayViewHolder {
        return PlacePayViewHolder(
            ItemPlacePayBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: PlacePayViewHolder, position: Int) {
        holder.bind(array[position])
    }

    override fun getItemCount(): Int = array.size

    inner class PlacePayViewHolder(private val binding: ItemPlacePayBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(placepay: PayPal) {
            placepay.image?.let { binding.imageCardP.setImageResource(it) }
            binding.btnCardP.text = placepay.title

            itemView.setOnClickListener {
                onClick(placepay)

            }
        }
    }

}