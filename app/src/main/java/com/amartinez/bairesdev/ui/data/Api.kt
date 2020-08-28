package com.amartinez.bairesdev.ui.data

import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("orgs/octokit/repos")
    fun loadData() : Call<List<Data>>
}