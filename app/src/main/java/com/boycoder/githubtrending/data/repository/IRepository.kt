package com.boycoder.githubtrending.data.repository

import com.boycoder.githubtrending.data.RepoList
import com.boycoder.githubtrending.data.entity.ResultX

/**
 * @Author: zhutao
 * @desc:
 */
interface IRepository {
    suspend fun getRepoList(): ResultX<RepoList>
}