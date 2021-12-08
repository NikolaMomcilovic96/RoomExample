package com.raywenderlich.roomexample.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.raywenderlich.roomexample.model.Player

@Database(entities = [Player::class], version = 1)
abstract class PlayerDatabase : RoomDatabase() {
    abstract fun playerDao(): PlayerDao

    companion object {
        private var INSTANCE: PlayerDatabase? = null

        fun getDatabase(context: Context): PlayerDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PlayerDatabase::class.java,
                    "player_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}