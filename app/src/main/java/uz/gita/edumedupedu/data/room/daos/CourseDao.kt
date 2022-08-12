package uz.gita.edumedupedu.data.room.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import uz.gita.edumedupedu.data.room.entities.CourseEntity

@Dao
interface CourseDao {

    @Query("SELECT * FROM course")
    fun getCourses():LiveData<List<CourseEntity>>

    @Query("SELECT COUNT(id) FROM course WHERE id = :id")
    fun getGroupCount(id: Int):LiveData<Int>

    @Insert
    fun insert(courseEntity: CourseEntity)

    @Update
    fun update(courseEntity: CourseEntity)
}
