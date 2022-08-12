package uz.gita.edumedupedu.viewModels

import androidx.lifecycle.LiveData
import uz.gita.edumedupedu.data.room.entities.GroupEntity

interface AddGroupViewModel {
    val backGroupsLiveData: LiveData<Unit>

    fun triggerBackGroups()
    fun insert(groupEntity: GroupEntity)

}