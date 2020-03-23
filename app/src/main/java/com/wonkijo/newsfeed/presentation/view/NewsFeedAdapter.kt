package com.wonkijo.newsfeed.presentation.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.wonkijo.newsfeed.R
import com.wonkijo.newsfeed.presentation.model.RssFeed
import kotlinx.android.synthetic.main.item_news_feed.view.*

class NewsFeedAdapter(private val items: MutableList<RssFeed>,
                      private val onClickListener: OnClickFeedListener? = null): RecyclerView.Adapter<NewsFeedAdapter.NewsFeedViewHolder>() {

    fun setItems(items: List<RssFeed>? = null) {
        if (items.isNullOrEmpty()) return
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsFeedViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news_feed, parent, false)
        return NewsFeedViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsFeedViewHolder, position: Int) {
        holder.bind(items[position], onClickListener)
    }

    class NewsFeedViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val tvKeywords: List<AppCompatTextView> = listOf(
            itemView.tv_keyword_0, itemView.tv_keyword_1, itemView.tv_keyword_2)

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
}