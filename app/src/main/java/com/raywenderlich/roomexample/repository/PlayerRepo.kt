package com.raywenderlich.roomexample.repository

import androidx.lifecycle.LiveData
import com.raywenderlich.roomexample.db.PlayerDao
import com.raywenderlich.roomexample.model.Player

class PlayerRepo(private val playerDao: PlayerDao) {
    val readAllData: LiveData<List<Player>> = playerDao.readAllData()

    fun addPlayer(player: Player) {
        playerDao.addPlayer(player)
    }
}