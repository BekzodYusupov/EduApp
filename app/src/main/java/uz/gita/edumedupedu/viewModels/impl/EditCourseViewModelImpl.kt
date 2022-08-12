package uz.gita.edumedupedu.viewModels.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.edumedupedu.data.repository.CourseRepository
import uz.gita.edumedupedu.data.repository.impl.RepositoryImpl
import uz.gita.edumedupedu.data.room.entities.CourseEntity
import uz.gita.edumedupedu.viewModels.EditCourseViewModel

class EditCourseViewModelImpl : EditCourseViewModel, ViewModel() {
    private val repo:CourseRepository = RepositoryImpl()
    override val backToHomeLiveData: MutableLiveData<Unit> = MutableLiveData()
    override val editClickLiveData: MutableLiveData<CourseEntity> = MutableLiveData()

    override fun update(courseEntity: CourseEntity) {
        repo.update(courseEntity)
    }

    override fun setBackToHome() {
        backToHomeLiveData.value = Unit
    }
}