package com.islamistudio.gamedb.core.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.islamistudio.gamedb.core.domain.model.Game
import com.islamistudio.gamedb.databinding.AdapterGameItemBinding

class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding = AdapterGameItemBinding.bind(itemView)

    fun setData(
        data: MutableList<Game>,
        position: Int,
        delegate: RecyclerViewAdapterDelegate<Game>?
    ) {
        with(binding) {
            Glide.with(itemView.context)
                .load(data[position].backgroundImage)
                .into(ivGameBanner)
            tvGameTitle.text = data[position].name
            tvRating.text = data[position].rating.toString()

            root.setOnClickListener {
                delegate?.onClick(data[position])
            }
        }
    }

}