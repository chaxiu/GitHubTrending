package com.boycoder.githubtrending.data.source

import com.boycoder.githubtrending.data.RepoList
import com.boycoder.githubtrending.data.entity.ResultX

/**
 * @Author: zhutao
 * @desc:
 */
interface RepoDataSource {
    suspend fun getRepos(): ResultX<RepoList>
}