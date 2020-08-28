package com.amartinez.bairesdev.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.amartinez.bairesdev.R
import com.amartinez.bairesdev.databinding.FragmentGithubBinding
import com.amartinez.bairesdev.ui.data.Api
import com.amartinez.bairesdev.ui.data.Data
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GithubFragment: Fragment() {
    private lateinit var binder: FragmentGithubBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binder = DataBindingUtil.inflate(inflater,
            R.layout.fragment_github, container, false)
        retainInstance = true
        return binder.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadRepositories()
    }

    private fun loadRepositories() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val lastFmService = retrofit.create(Api::class.java)
        val call = lastFmService.loadData()

        call.enqueue(object : Callback<List<Data>> {
            override fun onFailure(call: Call<List<Data>>?, t: Throwable?) {
                Toast.makeText(requireContext(), R.string.github_error, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Data>>, response: Response<List<Data>>?) {
                response?.body()?.let { showRepositories(it) }
            }
        })
    }

    private fun showRepositories(repositories: List<Data>) {
        val adapter = GithubAdapter(requireContext())
        val linearLayoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binder.rvRepo.layoutManager = linearLayoutManager
        binder.rvRepo.adapter = adapter

        adapter.addItems(repositories)
        adapter.notifyDataSetChanged()
    }
}