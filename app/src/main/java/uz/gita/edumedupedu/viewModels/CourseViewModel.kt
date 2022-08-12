package uz.gita.edumedupedu.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import uz.gita.edumedupedu.data.room.entities.CourseEntity

interface CourseViewModel {

    val coursesLiveData:MediatorLiveData<List<CourseEntity>>
    val courseInfoLiveData:LiveData<Unit>
    var addCourseLiveData: MutableLiveData<Unit>
    val updateLivedata:LiveData<Int>
    val openGroupLiveData:LiveData<Int>
    val groupCountLiveData: LiveData<Int>

    fun insert(courseEntity: CourseEntity)

    fun update(id: Int)

    fun getGroupCount(id: Int)

    fun onCourseInfo()

    fun setAddCourseLiveData()

    fun triggerOpenGroupLiveData(id: Int)
}