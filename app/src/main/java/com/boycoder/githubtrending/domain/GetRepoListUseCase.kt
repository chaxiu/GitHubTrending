package com.boycoder.githubtrending.domain

import com.boycoder.githubtrending.data.RepoList
import com.boycoder.githubtrending.data.entity.ResultX
import com.boycoder.githubtrending.data.repository.IRepository
import com.boycoder.githubtrending.data.repository.MainRepository

/**
 * @Author: zhutao
 * @desc:
 */
class GetRepoListUseCase(private val repository: IRepository = MainRepository()) {
    suspend operator fun invoke(): ResultX<RepoList> {
        return repository.getRepoList()
    }
}