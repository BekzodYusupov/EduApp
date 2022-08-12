package uz.gita.edumedupedu.viewModels.impl

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.edumedupedu.data.repository.GroupRepository
import uz.gita.edumedupedu.data.repository.impl.RepositoryImpl
import uz.gita.edumedupedu.data.room.entities.GroupEntity
import uz.gita.edumedupedu.viewModels.GroupViewModel

class GroupViewModelImpl : GroupViewModel, ViewModel() {
    private val repo: GroupRepository = RepositoryImpl()
    override val backToCourseLiveData: MutableLiveData<Unit> = MutableLiveData()
    override val groupsLivedata: MediatorLiveData<List<GroupEntity>> = MediatorLiveData()
    override val addLiveData: MutableLiveData<Int> = MutableLiveData()

    override fun triggerBackCourseLivedata() {
        backToCourseLiveData.value = Unit
    }

    override fun getGroups(id: Int) {
        groupsLivedata.addSource(repo.getGroups(id)) {
            groupsLivedata.value = it
        }
    }

    override fun delete(groupEntity: GroupEntity) {
        repo.delete(groupEntity)
    }

    override fun triggerAdd(id: Int) {
        addLiveData.value = id
    }
}