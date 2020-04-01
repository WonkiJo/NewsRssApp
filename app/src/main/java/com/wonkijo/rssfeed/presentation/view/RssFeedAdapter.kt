package com.wonkijo.rssfeed.presentation.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wonkijo.rssfeed.R
import com.wonkijo.rssfeed.presentation.model.RssFeed
import kotlinx.android.synthetic.main.item_rss_feed.view.*
import kotlinx.android.synthetic.main.layout_keywords.view.*

class RssFeedAdapter(
    private val items: MutableList<RssFeed>,
    private val onClickListener: OnClickFeedListener? = null
) : RecyclerView.Adapter<RssFeedAdapter.RssFeedViewHolder>() {

    fun setItems(newItems: List<RssFeed>? = null) {
        if (newItems == null) return
        val diffCallback = RssFeedDiffCallback(this.items, newItems)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.items.clear()
        this.items.addAll(newItems)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RssFeedViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_rss_feed,
                parent,
                false
            )
        return RssFeedViewHolder(view)
    }

    override fun onBindViewHolder(holder: RssFeedViewHolder, position: Int) {
        holder.bind(items[position], onClickListener)
    }

    class RssFeedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvKeywords: List<AppCompatTextView> = listOf(
            itemView.tv_keyword_0, itemView.tv_keyword_1, itemView.tv_keyword_2
        )

        fun bind(data: RssFeed, onClickListener: OnClickFeedListener? = null) {
            with(itemView) {
                Glide.with(this)
                    .load(data.thumbnail)
                    .into(iv_thumbnail)

                tv_title?.text = data.title
                tv_summary?.text = data.summary

                data.keywords?.let {
                    tvKeywords.forEachIndexed { index, view ->
                        if (index < data.keywords.size) {
                            view.visibility = View.VISIBLE
                            view.text = data.keywords[index]
                        } else {
                            view.visibility = View.GONE
                        }
                    }
                }

                setOnClickListener {
                    onClickListener?.onClickFeed(data)
                }
            }
        }
    }

    interface OnClickFeedListener {
        fun onClickFeed(feed: RssFeed)
    }

    class RssFeedDiffCallback(private val oldList: List<RssFeed>,
                              private val newList: List<RssFeed>) : DiffUtil.Callback() {

        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].link === newList.get(newItemPosition).link
        }

        override fun areContentsTheSame(oldPosition: Int, newPosition: Int): Boolean {
            val (_, value, name) = oldList[oldPosition]
            val (_, value1, name1) = newList[newPosition]

            return name == name1 && value == value1
        }

        override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
            return super.getChangePayload(oldItemPosition, newItemPosition)
        }
    }
}