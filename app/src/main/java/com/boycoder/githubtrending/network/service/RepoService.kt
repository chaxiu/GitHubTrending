package com.boycoder.githubtrending.network.service

import com.boycoder.githubtrending.data.RepoList
import retrofit2.http.*

/**
 * @Author: zhutao
 * @desc:
 */
interface RepoService {
    @GET("repo")
    suspend fun repos(@Query("lang") lang: String = "Kotlin", @Query("since") since: String = "weekly"): RepoList
}