package com.example.geeksfit.ui.gim.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.geeksfit.data.remote.model.trainings.ResponseTrainings
import com.example.geeksfit.databinding.ItemGimBinding


class GimAdapter(


   // private val onClick: (model: ResponseTrainings) -> Unit
) :
    RecyclerView.Adapter<GimAdapter.GimViewHolder>() {
    private val data= arrayListOf<ResponseTrainings>()
    private lateinit var listener: OnItemClick




    fun addList(list: List<ResponseTrainings>){
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()

    }

    fun setListener(onItemClick: OnItemClick) {
        listener = onItemClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GimViewHolder {
        return GimViewHolder(
            ItemGimBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }
    override fun onBindViewHolder(holder: GimViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    inner class GimViewHolder(private val binding: ItemGimBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(gimModel: ResponseTrainings) {
           binding.tvTitle.text = gimModel.title
            binding.fitImageA.load(gimModel.image)

            itemView.setOnClickListener {
                listener.onItemClick(gimModel)
            }

           /* itemView.setOnClickListener {
                onClick(gimModel)
            }*/
        }
    }

    interface OnItemClick{
        fun onItemClick(list: ResponseTrainings)
    }

}
