package com.my_project.viperarchsample.entity.sources

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Source(
    @SerializedName("id") @Expose val id: Int,
    @SerializedName("name") @Expose val name: String,
    @SerializedName("year") @Expose val year:Int,
    @SerializedName("color") @Expose val color: String,
    @SerializedName("pantone_value") @Expose val pantoneValue: String
    )





