package com.boycoder.githubtrending.data.source.remote

import android.util.Log
import com.boycoder.githubtrending.data.RepoList
import com.boycoder.githubtrending.data.entity.ResultX
import com.boycoder.githubtrending.data.entity.ResultX.*
import com.boycoder.githubtrending.data.source.RepoDataSource
import com.boycoder.githubtrending.network.RetrofitClient
import com.google.android.material.tabs.TabLayout
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * @Author: zhutao
 * @desc:
 */
object RemoteRepoDataSource : RepoDataSource {
    const val TAG = "RemoteRepoDataSource"
    override suspend fun getRepos(): ResultX<RepoList> =
        withContext(Dispatchers.IO) {
            try {
                Success(RetrofitClient.service.repos())
            } catch (e: Exception) {
                Log.e(TAG, e.message, e)
                Error(e)
            }
        }
}