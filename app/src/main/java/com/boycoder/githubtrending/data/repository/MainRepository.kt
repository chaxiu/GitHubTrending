package com.boycoder.githubtrending.data.repository

import com.boycoder.githubtrending.data.RepoList
import com.boycoder.githubtrending.data.entity.ResultX
import com.boycoder.githubtrending.data.source.RepoDataSource
import com.boycoder.githubtrending.data.source.remote.RemoteRepoDataSource

/**
 * @Author: zhutao
 * @desc:
 */
class MainRepository(
    private val dataSource: RepoDataSource = RemoteRepoDataSource,
    private val localDataSource: RepoDataSource? = null
) : IRepository {
    override suspend fun getRepoList(): ResultX<RepoList> {
        // 暂不处理缓存逻辑
        return dataSource.getRepos()
    }
}