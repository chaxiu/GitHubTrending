package com.boycoder.githubtrending

import com.boycoder.githubtrending.data.Repo
import com.boycoder.githubtrending.network.RetrofitClient
import org.junit.Assert
import org.junit.Test

/**
 * @Author: zhutao
 * @desc:
 */
class JSONTest {

    @Test
    fun test() {
        val json = """{"repo": null, "repo_link": "https://github.com/JetBrains/kotlin", "desc": "The Kotlin Programming Language.", "lang": "Kotlin", "stars": "40,907", "forks": "5,067", "added_stars": "98 stars this week", "avatars": ["https://avatars.githubusercontent.com/u/292714?s=40&v=4", "https://avatars.githubusercontent.com/u/1127631?s=40&v=4", "https://avatars.githubusercontent.com/u/908958?s=40&v=4", "https://avatars.githubusercontent.com/u/3007027?s=40&v=4", "https://avatars.githubusercontent.com/u/888318?s=40&v=4"]}"""
        val repo = RetrofitClient.moshi.adapter(Repo::class.java).fromJson(json)
        println(repo?.repo)
    }
}