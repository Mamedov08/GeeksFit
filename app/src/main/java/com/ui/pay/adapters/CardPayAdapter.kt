package com.ui.pay.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.geeksfit.databinding.ItemCardPayBinding
import com.ui.pay.model.PayCard


class CardPayAdapter(

    private val array: ArrayList<PayCard>
) :
    RecyclerView.Adapter<CardPayAdapter.CardPayViewHolder>() {


    override fun onBindViewHolder(holder: CardPayViewHolder, position: Int) {
        holder.bind(array[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardPayViewHolder {
        return CardPayViewHolder(
            ItemCardPayBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = array.size

    inner class CardPayViewHolder(private val binding: ItemCardPayBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(cardpay: PayCard) {
            binding.tvCard.text = cardpay.title
            binding.tvCardOnS.text = cardpay.title
            binding.tvCardOS.text = cardpay.title
        }
    }
}