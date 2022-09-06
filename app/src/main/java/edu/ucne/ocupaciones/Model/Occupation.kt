package edu.ucne.ocupaciones.Model

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.PrimaryKey

@Dao
@Entity(tableName = "Occupation")
data class Occupation(
    @PrimaryKey(autoGenerate = true)
    val OccupationId: Int = 0,
    val Description: String = "",
    val Salary: Double
)