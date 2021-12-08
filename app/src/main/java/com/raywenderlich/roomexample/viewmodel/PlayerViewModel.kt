package com.raywenderlich.roomexample.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.raywenderlich.roomexample.db.PlayerDatabase
import com.raywenderlich.roomexample.model.Player
import com.raywenderlich.roomexample.repository.PlayerRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlayerViewModel(application: Application) : AndroidViewModel(application) {
    private val readAllData: LiveData<List<Player>>
    private val repository: PlayerRepo

    init {
        val playerDao = PlayerDatabase.getDatabase(application).playerDao()
        repository = PlayerRepo(playerDao)
        readAllData = repository.readAllData
    }

    fun addPlayer(player: Player) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addPlayer(player)
        }
    }
}