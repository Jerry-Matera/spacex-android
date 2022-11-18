package io.github.jerrymatera.spacex.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import io.github.jerrymatera.spacex.data.models.SpaceShip
import io.github.jerrymatera.spacex.databinding.SpaceShipItemBinding

class SpaceShipAdapter :
    ListAdapter<SpaceShip, SpaceShipAdapter.SpaceShipViewHolder>(DiffCallback()) {

    class SpaceShipViewHolder(private val binding: SpaceShipItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SpaceShip?) = with(binding) {
            Glide.with(root.context)
                .load(item?.image)
                .into(binding.shipImage)
            shipName.text = item!!.ship_name
            shipType.text = item.ship_type
            shipStatus.text = item.status
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpaceShipViewHolder {
        val binding =
            SpaceShipItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SpaceShipViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SpaceShipViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


}

class DiffCallback : DiffUtil.ItemCallback<SpaceShip>() {
    override fun areItemsTheSame(oldItem: SpaceShip, newItem: SpaceShip): Boolean {
        return oldItem.ship_id == newItem.ship_id
    }

    override fun areContentsTheSame(oldItem: SpaceShip, newItem: SpaceShip): Boolean {
        return oldItem == newItem
    }

}
