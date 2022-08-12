package uz.gita.edumedupedu.data.room.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import uz.gita.edumedupedu.data.room.entities.GroupEntity

@Dao
interface GroupDao {
    @Query("SELECT * FROM `group` WHERE course_id = :id")
    fun getGroups(id:Int):LiveData<List<GroupEntity>>

    @Insert
    fun insert(groupEntity: GroupEntity)

    @Update
    fun update(groupEntity: GroupEntity)

    @Delete
    fun delete(groupEntity: GroupEntity)
}