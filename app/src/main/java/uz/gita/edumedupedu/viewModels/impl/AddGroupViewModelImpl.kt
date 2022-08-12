package uz.gita.edumedupedu.viewModels.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.edumedupedu.data.repository.GroupRepository
import uz.gita.edumedupedu.data.repository.impl.RepositoryImpl
import uz.gita.edumedupedu.data.room.entities.GroupEntity
import uz.gita.edumedupedu.viewModels.AddGroupViewModel

class AddGroupViewModelImpl : AddGroupViewModel, ViewModel() {
    val repo:GroupRepository = RepositoryImpl()
    override val backGroupsLiveData: MutableLiveData<Unit> = MutableLiveData()

    override fun triggerBackGroups() {
        backGroupsLiveData.value = Unit
    }

    override fun insert(groupEntity: GroupEntity) {
        repo.insert(groupEntity)
    }
}