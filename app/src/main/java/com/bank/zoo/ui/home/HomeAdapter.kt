package com.bank.zoo.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bank.zoo.R
import com.bank.zoo.model.api.vo.ZooItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_home.view.*
import timber.log.Timber

class HomeAdapter(
    private val homeFuncListener: HomeFuncListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var zooItems = arrayListOf<ZooItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val mView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_home, parent, false)
        return HomeViewHolder(mView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as HomeViewHolder

        val item = zooItems[position]

        Glide.with(holder.categoryImg.context)
            .load(item.picUrl)
            .error(R.mipmap.ic_launcher)
            .into(holder.categoryImg)

        holder.categoryTitle.text = item.name
        holder.categoryDesc.text = item.info
        holder.categoryMemo.text = item.memo

        holder.categoryLayout.setOnClickListener {
            homeFuncListener.onItemClick()
        }
    }

    override fun getItemCount(): Int {
        return zooItems.size
    }

    class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var categoryImg: ImageView = itemView.iv_category
        var categoryTitle: TextView = itemView.tv_category_title
        var categoryDesc: TextView = itemView.tv_category_desc
        var categoryMemo: TextView = itemView.tv_category_memo
        var categoryLayout: ConstraintLayout = itemView.layout_item_category
    }

    fun updateData(data: ArrayList<ZooItem>) {
        zooItems = data
        notifyDataSetChanged()
    }
}