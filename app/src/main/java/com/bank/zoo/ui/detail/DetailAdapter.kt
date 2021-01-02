package com.bank.zoo.ui.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bank.zoo.R
import com.bank.zoo.model.api.vo.ZooItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_detail.view.*

class DetailAdapter(
    private val item: ZooItem,
    private val detailFuncListener: DetailFuncListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val VIEW_TYPE_DETAIL = 0
        const val VIEW_TYPE_PLANT_TITLE = 1
        const val VIEW_TYPE_PLANTS = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_DETAIL -> {
                val mView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_detail, parent, false)
                DetailViewHolder(mView)
            }
            VIEW_TYPE_PLANT_TITLE -> {
                val mView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_plant_title, parent, false)
                PlantTitleViewHolder(mView)
            }
            else -> {
                val mView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_plants, parent, false)
                PlantsViewHolder(mView)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> VIEW_TYPE_DETAIL
            1 -> VIEW_TYPE_PLANT_TITLE
            else -> VIEW_TYPE_PLANTS
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is DetailViewHolder -> {
                Glide.with(holder.categoryImg.context)
                    .load(item.picUrl)
                    .error(R.mipmap.ic_launcher)
                    .into(holder.categoryImg)

                holder.categoryInfo.text = item.info
                holder.categoryMemo.text = item.memo
                holder.categoryArea.text = item.category
                holder.categoryOpenWeb.setOnClickListener {
                    detailFuncListener.onOpenWeb(item.url)
                }
            }
            is PlantTitleViewHolder -> {

            }
            is PlantsViewHolder -> {

            }
        }
    }

    override fun getItemCount(): Int {
        return 3
    }

    class DetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var categoryImg: ImageView = itemView.iv_detail
        var categoryInfo: TextView = itemView.tv_info
        var categoryMemo: TextView = itemView.tv_memo
        var categoryArea: TextView = itemView.tv_area
        var categoryOpenWeb: TextView = itemView.tv_open_web
    }

    class PlantTitleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    class PlantsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}