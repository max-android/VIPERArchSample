package com.my_project.viperarchsample.entity.users

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class WrapUser(@SerializedName("data") @Expose val user: User)
