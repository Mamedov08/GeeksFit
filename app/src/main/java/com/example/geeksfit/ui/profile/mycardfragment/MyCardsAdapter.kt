package com.example.geeksfit.ui.profile.mycardfragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.geeksfit.data.remote.model.card.CardBody
import com.example.geeksfit.databinding.CardItemBinding

class MyCardsAdapter : RecyclerView.Adapter<MyCardsAdapter.CardViewHolder>() {

    private var myCards = arrayListOf<CardBody>()

    fun setCardList(list: List<CardBody> ) {
        myCards.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        return CardViewHolder(
            CardItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
       holder.onBind(myCards[position])
    }

    override fun getItemCount(): Int {
        return myCards.size
    }


    class CardViewHolder(private val binding: CardItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(cardBody: CardBody) {
           binding.cardNumber.text = cardBody.card_number

        }

    }
}