package edu.ucne.ocupaciones.respository

import edu.ucne.ocupaciones.data.AppDataBase
import edu.ucne.ocupaciones.Model.Occupation
import javax.inject.Inject

class OccupationRepository @Inject constructor(
    val db: AppDataBase
) {
    suspend fun insertOccupation(occupation: Occupation) {
        db.occupationDao.insertOccupation(occupation)
    }

    suspend fun updateOccupation(occupation: Occupation) {
        db.occupationDao.updateOccupation(occupation)
    }

    suspend fun deleteOccupation(occupation: Occupation) {
        db.occupationDao.deleteOccupation(occupation)
    }

    fun getOccupation(occupationId: Int) = db.occupationDao.getOccupation(occupationId)

    fun getAll() = db.occupationDao.getAll()
}

