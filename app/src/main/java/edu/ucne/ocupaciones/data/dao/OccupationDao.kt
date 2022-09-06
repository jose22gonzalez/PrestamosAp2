package edu.ucne.ocupaciones.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import edu.ucne.ocupaciones.Model.Occupation
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@Dao
interface OccupationDao  {
    @Insert
    suspend fun insertOccupation(occupation: Occupation)

    @Update fun updateOccupation(occupation: Occupation)

    @Delete fun deleteOccupation(occupation: Occupation)

    @Query("SELECT * FROM Occupation WHERE OccupationId = :occupationId")

    fun getOccupation(occupationId: Int): Flow<Occupation>

    @Query("SELECT * FROM Occupation")
    fun getAll(): Flow<List<Occupation>>
}