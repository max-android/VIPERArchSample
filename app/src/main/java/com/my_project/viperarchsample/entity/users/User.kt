package com.my_project.viperarchsample.entity.users

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class User(
    @SerializedName("id") @Expose val id: Int,
    @SerializedName("first_name") @Expose val firstName: String,
    @SerializedName("last_name") @Expose val lastName: String,
    @SerializedName("avatar") @Expose val avatar: String
)





