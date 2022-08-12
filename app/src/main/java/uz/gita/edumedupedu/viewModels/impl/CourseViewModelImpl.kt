package uz.gita.edumedupedu.viewModels.impl

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.edumedupedu.data.repository.CourseRepository
import uz.gita.edumedupedu.data.repository.impl.RepositoryImpl
import uz.gita.edumedupedu.data.room.entities.CourseEntity
import uz.gita.edumedupedu.viewModels.CourseViewModel

class CourseViewModelImpl : CourseViewModel, ViewModel() {
    private val repo: CourseRepository = RepositoryImpl()
    override val coursesLiveData: MediatorLiveData<List<CourseEntity>> = MediatorLiveData()

    override val courseInfoLiveData: LiveData<Unit> = MutableLiveData()
    override var addCourseLiveData: MutableLiveData<Unit> = MutableLiveData()
    override val updateLivedata: MutableLiveData<Int> = MutableLiveData()
    override val openGroupLiveData: MutableLiveData<Int> = MutableLiveData()
    override val groupCountLiveData: MutableLiveData<Int> = MutableLiveData()


    init {
        coursesLiveData.addSource(repo.getCourses()) {
            coursesLiveData.value = it
        }
    }

    override fun insert(courseEntity: CourseEntity) = repo.insert(courseEntity)

    override fun update(id: Int) {
        updateLivedata.value = id
    }

    override fun getGroupCount(id: Int){
        Log.d("QQQQ", "getGroupCount: ${repo.getGroupCount(id)}")
        coursesLiveData.addSource(repo.getGroupCount(id)){
            groupCountLiveData.value = it
        }
    }

    override fun onCourseInfo() {

    }

    override fun setAddCourseLiveData() {
        addCourseLiveData.value = Unit
    }

    override fun triggerOpenGroupLiveData(id: Int) {
        openGroupLiveData.value = id
    }
}