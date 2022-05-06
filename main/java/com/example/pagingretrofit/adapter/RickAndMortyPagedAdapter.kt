package com.example.pagingretrofit.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.pagingretrofit.activities.DetailActivity
import com.example.pagingretrofit.activities.DetailActivity.Companion.EXTRA_CHARACTER
import com.example.pagingretrofit.databinding.RickMortyLayoutBinding
import com.example.pagingretrofit.models.Character


class RickAndMortyPagedAdapter :
    PagingDataAdapter<Character, RickAndMortyPagedAdapter.RickMortyViewHolder>(diffCallback) {


    inner class RickMortyViewHolder(val binding: RickMortyLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)


    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<Character>() {
            override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onBindViewHolder(holder: RickMortyViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.binding.apply {
            nameTextView.text = "${currentItem?.name}"
            speciesTextView.text = "${currentItem?.species}"
            genderTextView.text = "${currentItem?.gender}"
            val imageUrl = currentItem?.image
            imageView.load(imageUrl) {
                crossfade(true)
                crossfade(1000)
            }
        }
        val context = holder.itemView.context
        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(EXTRA_CHARACTER, currentItem)
            context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RickMortyViewHolder {
        return RickMortyViewHolder(
            RickMortyLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


}