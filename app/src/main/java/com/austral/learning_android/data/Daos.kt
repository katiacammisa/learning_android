package com.austral.learning_android.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface FriendDao {
    @Insert
    suspend fun insert(friend: Friend)

    @Update
    suspend fun update(friend: Friend)

    @Delete
    suspend fun delete(friend: Friend)

    @Query("SELECT * FROM friends")
    fun getAllFriends(): LiveData<List<Friend>>
}