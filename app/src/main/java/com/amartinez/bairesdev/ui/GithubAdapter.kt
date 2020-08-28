package com.amartinez.bairesdev.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.amartinez.bairesdev.R
import com.amartinez.bairesdev.databinding.ItemGithubBinding
import com.amartinez.bairesdev.ui.data.Data

class GithubAdapter(private val context: Context) : RecyclerView.Adapter<GithubAdapter.GithubhHolder>() {

    private var results: ArrayList<Data> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubhHolder {
        val view: View
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_github, parent, false
        )
        view = binding.root

        return GithubhHolder(view)
    }

    fun addItems(list: List<Data>) {
        results.addAll(list)
    }

    override fun onBindViewHolder(holder: GithubhHolder, position: Int) {
        holder.bind(position, results[position])
    }

    override fun getItemCount(): Int {
        return results.size
    }

    inner class GithubhHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val touched = false

        @SuppressLint("ClickableViewAccessibility")
        fun bind(position: Int, data: Data) {
            val binder = DataBindingUtil.getBinding<ItemGithubBinding>(view)

            binder?.tvUrl?.text = data.html_url
            binder?.tvUrl?.setOnClickListener {
                val openURL = Intent(android.content.Intent.ACTION_VIEW)
                openURL.data = Uri.parse(data.html_url)
                context.startActivity(openURL)
            }
        }
    }
}