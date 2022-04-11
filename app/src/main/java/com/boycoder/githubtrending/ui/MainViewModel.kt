package com.boycoder.githubtrending.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.boycoder.githubtrending.data.RepoList
import com.boycoder.githubtrending.data.entity.ResultX
import com.boycoder.githubtrending.domain.GetRepoListUseCase
import kotlinx.coroutines.launch

/**
 * @Author: zhutao
 * @desc:
 */
class MainViewModel(
    val getRepoListUseCase: GetRepoListUseCase = GetRepoListUseCase()
) : ViewModel() {
    val repos: LiveData<RepoList>
        get() = _repos
    private val _repos = MutableLiveData<RepoList>()

    fun loadRepos() {
        viewModelScope.launch {
            val result = getRepoListUseCase()
            when (result) {
                is ResultX.Success -> {
                    _repos.value = result.data
                }
                is ResultX.Error -> {
                    _repos.value = RepoList()
                }
                ResultX.Loading -> {
                    // 展示Loading
                }
            }
        }
    }
}