package com.my_project.viperarchsample.view.sources

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.my_project.viperarchsample.R
import com.my_project.viperarchsample.entity.sources.WrapSource


class SourceAdapter(private val action: (WrapSource) -> Unit) : RecyclerView.Adapter<SourceAdapter.SourceHolder>() {

    private val items: MutableList<WrapSource> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SourceHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_source, parent, false)
        return SourceHolder(view)
    }

    override fun onBindViewHolder(holder: SourceHolder, position: Int) {
        val source = items[position]
        holder.bindTo(source)
    }

    override fun getItemCount() = items.size

    fun setData(sources: List<WrapSource>) {
        items.addAll(sources)
    }

    fun updateData(sources: List<WrapSource>) {
        items.clear()
        items.addAll(sources)
        notifyDataSetChanged()
    }

    inner class SourceHolder(private val containerView: View) : RecyclerView.ViewHolder(containerView) {

        private var text = containerView.findViewById(R.id.nameTextView) as TextView
        private var view = containerView.findViewById(R.id.colorView) as View

        init {
            containerView.setOnClickListener { action(items[layoutPosition]) }
        }

        fun bindTo(wrapSource: WrapSource) = with(wrapSource) {
            text.text = sourc.name
            view.setBackgroundColor(Color.parseColor(sourc.color))
        }
    }
}
