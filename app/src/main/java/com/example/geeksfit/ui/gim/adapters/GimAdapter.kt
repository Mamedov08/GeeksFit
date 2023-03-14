package com.example.geeksfit.ui.gim.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.geeksfit.databinding.ItemGimBinding
import com.example.geeksfit.ui.gim.model.GimModel

class GimAdapter(

    private val data: ArrayList<GimModel>,
    private val onClick: (model: GimModel) -> Unit

) :
    RecyclerView.Adapter<GimAdapter.GimViewHolder>() {

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
        fun bind(gimModel: GimModel) {
            binding.titleTV.text=gimModel.title.toString()
            gimModel.imageA?.let { binding.fitImageA.setImageResource(it) }
            binding.playlistTvA.text = gimModel.titleA.toString()
            gimModel.imageB?.let { binding.fitImageB.setImageResource(it) }
            binding.playlistTvB.text = gimModel.titleB.toString()
            gimModel.imageC?.let { binding.fitImageC.setImageResource(it) }
            binding.playlistTvC.text = gimModel.titleC
            gimModel.imageD?.let { binding.fitImageD.setImageResource(it) }
            binding.playlistTvD.text = gimModel.titleD
            gimModel.imageE?.let { binding.fitImageE.setImageResource(it) }
            binding.playlistTvE.text = gimModel.titleE


            itemView.setOnClickListener {
                onClick(gimModel)
            }
        }
    }

}
