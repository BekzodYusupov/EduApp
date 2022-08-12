package uz.gita.edumedupedu.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import uz.gita.edumedupedu.data.room.entities.CourseEntity
import uz.gita.edumedupedu.data.room.entities.GroupEntity

interface GroupViewModel {
    val backToCourseLiveData: LiveData<Unit>
    val groupsLivedata: MediatorLiveData<List<GroupEntity>>
    val addLiveData:LiveData<Int>

    fun triggerBackCourseLivedata()
    fun getGroups(id:Int)
    fun delete(groupEntity: GroupEntity)
    fun triggerAdd(id: Int)
}