package com.my_project.viperarchsample.entity.users

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Users(
    @SerializedName("page") @Expose val page: Int,
    @SerializedName("per_page") @Expose val perPage: Int,
    @SerializedName("total") @Expose val total: Int,
    @SerializedName("total_pages") @Expose val totalPages: Int,
    @SerializedName("data") @Expose val user: List<User>
    )







