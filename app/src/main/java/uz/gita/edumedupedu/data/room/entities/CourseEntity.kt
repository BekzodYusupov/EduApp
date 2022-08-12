package uz.gita.edumedupedu.data.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "course")
data class CourseEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name:String
)
