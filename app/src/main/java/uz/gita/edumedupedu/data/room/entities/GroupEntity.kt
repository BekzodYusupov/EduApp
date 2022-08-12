package uz.gita.edumedupedu.data.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "group")
data class GroupEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val name:String,
    val mentor:String,
    val course_id:Int
)
