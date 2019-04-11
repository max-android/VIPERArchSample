package com.my_project.viperarchsample.view.users

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.facebook.drawee.view.SimpleDraweeView
import com.my_project.viperarchsample.R
import com.my_project.viperarchsample.entity.users.WrapUser

class UsersAdapter(private val action: (WrapUser) -> Unit) : RecyclerView.Adapter<UsersAdapter.UsersHolder>() {

    private val items: MutableList<WrapUser> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UsersHolder(view)
    }

    override fun onBindViewHolder(holder: UsersHolder, position: Int) {
        val user = items[position]
        holder.bindTo(user)
    }

    override fun getItemCount() = items.size

    fun setData(users: List<WrapUser>) {
        //items.clear()
        items.addAll(users)
    }

    fun updateData(users: List<WrapUser>) {
        items.clear()
        items.addAll(users)
        notifyDataSetChanged()
    }

    inner class UsersHolder(private val containerView: View) : RecyclerView.ViewHolder(containerView) {

        private var text = containerView.findViewById(R.id.nameTextView) as TextView
        private var view = containerView.findViewById(R.id.imageView) as SimpleDraweeView

        init {
            containerView.setOnClickListener { action(items[layoutPosition]) }
        }

        fun bindTo(users: WrapUser) = with(users) {
            text.text = user.firstName
            view.setImageURI(user.avatar)
        }
    }
}