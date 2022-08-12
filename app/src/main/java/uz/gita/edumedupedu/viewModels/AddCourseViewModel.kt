package uz.gita.edumedupedu.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import uz.gita.edumedupedu.data.room.entities.CourseEntity

interface AddCourseViewModel {
    val backToHomeLiveData: MutableLiveData<Unit>

    fun insert(name: String)

    fun setBackToHome()
}