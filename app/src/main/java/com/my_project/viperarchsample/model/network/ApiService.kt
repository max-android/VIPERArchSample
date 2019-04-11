package com.my_project.viperarchsample.model.network

import com.my_project.viperarchsample.entity.login.TokenResponse
import com.my_project.viperarchsample.entity.sources.Sources
import com.my_project.viperarchsample.entity.sources.WrapSource
import com.my_project.viperarchsample.entity.users.Users
import com.my_project.viperarchsample.entity.users.WrapUser
import io.reactivex.Flowable
import io.reactivex.Single
import retrofit2.http.*

/**
 * Created Максим on 07.04.2019.
 * Copyright © Max
 */
interface ApiService {

    //https://reqres.in
    //https://reqres.in/api/login

    @FormUrlEncoded
    @POST("login")
    fun loginRequest(
        @Field("email") email: String,
        @Field("password") password: String
    ): Single<TokenResponse>

    //https://reqres.in/api/users
    @GET("users")
    fun usersRequest(): Flowable<Users>

    @GET("users/{id}")
    fun userRequest(@Path("id") userId: Int): Flowable<WrapUser>

    //https://reqres.in/api/unknown
    @GET("unknown")
    fun sourcesRequest(): Flowable<Sources>

    @GET("unknown/{id}")
    fun sourceRequest(@Path("id") userId: Int): Flowable<WrapSource>
}