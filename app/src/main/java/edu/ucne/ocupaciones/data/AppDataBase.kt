package edu.ucne.ocupaciones.data

import androidx.room.Database
import androidx.room.Entity //Not used because there are no entities
import androidx.room.PrimaryKey  //Not used because there are no entities
import androidx.room.RoomDatabase
import edu.ucne.ocupaciones.data.dao.OccupationDao
import edu.ucne.ocupaciones.Model.Occupation

@Database(
    entities = [Occupation::class],
    version = 1
)
abstract class AppDataBase : RoomDatabase() {
    abstract val occupationDao: OccupationDao
}