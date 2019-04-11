package com.my_project.viperarchsample.entity.login

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class TokenResponse(@SerializedName ("token") @Expose val token:String)

