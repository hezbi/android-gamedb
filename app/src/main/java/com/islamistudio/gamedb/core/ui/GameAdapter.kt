package com.islamistudio.gamedb.core.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.islamistudio.gamedb.R
import com.islamistudio.gamedb.core.domain.model.Game

class GameAdapter: RecyclerView.Adapter<GameViewHolder>() {

    var list = mutableListOf<Game>()
    var delegate: RecyclerViewAdapterDelegate<Game>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_game_item, parent, false)
        return GameViewHolder(view)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.setData(
            list,
            position,
            delegate
        )
//        notifyDataSetChanged()
    }

    override fun getItemCount() = list.size
}