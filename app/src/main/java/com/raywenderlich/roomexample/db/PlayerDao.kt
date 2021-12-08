package com.raywenderlich.roomexample.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query
import com.raywenderlich.roomexample.model.Player

@Dao
interface PlayerDao {
    @Insert(onConflict = IGNORE)
    fun addPlayer(player: Player)

    @Query("SELECT * FROM player_table ORDER BY id ASC")
    fun readAllData():LiveData<List<Player>>
}