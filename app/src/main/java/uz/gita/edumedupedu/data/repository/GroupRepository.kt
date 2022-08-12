package uz.gita.edumedupedu.data.repository

import androidx.lifecycle.LiveData
import uz.gita.edumedupedu.data.room.entities.GroupEntity

interface GroupRepository {

    fun getGroups(id: Int): LiveData<List<GroupEntity>>

    fun insert(groupEntity: GroupEntity)

    fun delete(groupEntity: GroupEntity)

    fun update(groupEntity: GroupEntity)
}