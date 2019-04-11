package com.my_project.viperarchsample.entity.sources

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created Максим on 07.04.2019.
 * Copyright © Max
 */
class Sources(
    @SerializedName("page") @Expose val page: Int,
    @SerializedName("per_page") @Expose val perPage: Int,
    @SerializedName("total") @Expose val total: Int,
    @SerializedName("total_pages") @Expose val totalPages: Int,
    @SerializedName("data") @Expose val source: List<Source>
    )



