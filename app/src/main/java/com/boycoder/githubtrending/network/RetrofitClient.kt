package com.boycoder.githubtrending.network

import android.util.Log
import com.boycoder.githubtrending.network.service.RepoService
import com.meteor.vchat.base.util.moshi.*
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @Author: zhutao
 * @desc:
 */
object RetrofitClient {

    private const val TAG = "OkHttp"
    private const val BASE_URL = "https://trendings.herokuapp.com/"
    private const val TIME_OUT = 10

    val moshi: Moshi by lazy {
        Moshi.Builder()
            .add(NullStringAdapter)
            .add(KotlinJsonAdapterFactory())
            .build()
    }


    val service by lazy { getService(RepoService::class.java, BASE_URL) }



    private val client: OkHttpClient by lazy {
        val builder = OkHttpClient.Builder()
        builder.connectTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
        builder.build()
    }

    private fun <S> getService(
        serviceClass: Class<S>,
        baseUrl: String,
        client: OkHttpClient = this.client
    ): S {
        return Retrofit.Builder()
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(baseUrl)
            .build().create(serviceClass)
    }
}