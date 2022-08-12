package uz.gita.edumedupedu.data.repository

import androidx.lifecycle.LiveData
import uz.gita.edumedupedu.app.App
import uz.gita.edumedupedu.data.room.AppDatabase
import uz.gita.edumedupedu.data.room.entities.CourseEntity

interface CourseRepository {

    fun getCourses():LiveData<List<CourseEntity>>

    fun getGroupCount(id:Int):LiveData<Int>

    fun insert(courseEntity: CourseEntity)

    fun update(courseEntity: CourseEntity)

}