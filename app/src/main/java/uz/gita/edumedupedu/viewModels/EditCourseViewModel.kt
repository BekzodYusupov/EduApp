package uz.gita.edumedupedu.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import uz.gita.edumedupedu.data.room.entities.CourseEntity

interface EditCourseViewModel {
    val backToHomeLiveData: LiveData<Unit>
    val editClickLiveData: LiveData<CourseEntity>

    fun update(courseEntity: CourseEntity)
    fun setBackToHome()
}