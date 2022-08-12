package uz.gita.edumedupedu.viewModels.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.edumedupedu.data.repository.CourseRepository
import uz.gita.edumedupedu.data.repository.impl.RepositoryImpl
import uz.gita.edumedupedu.data.room.entities.CourseEntity
import uz.gita.edumedupedu.viewModels.AddCourseViewModel

class AddCourseViewModelImpl() : ViewModel(), AddCourseViewModel {
    private val repo: CourseRepository = RepositoryImpl()
    override val backToHomeLiveData = MutableLiveData<Unit>()

    override fun insert(name: String) {
        repo.insert(CourseEntity(0,name))
    }

    override fun setBackToHome() {
        backToHomeLiveData.value = Unit
    }
}