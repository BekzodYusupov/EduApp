package uz.gita.edumedupedu.data.repository.impl

import androidx.lifecycle.LiveData
import uz.gita.edumedupedu.data.repository.CourseRepository
import uz.gita.edumedupedu.data.repository.GroupRepository
import uz.gita.edumedupedu.data.room.AppDatabase
import uz.gita.edumedupedu.data.room.daos.CourseDao
import uz.gita.edumedupedu.data.room.daos.GroupDao
import uz.gita.edumedupedu.data.room.entities.CourseEntity
import uz.gita.edumedupedu.data.room.entities.GroupEntity

class RepositoryImpl:CourseRepository, GroupRepository {
    private val database: AppDatabase = AppDatabase.getInstance()
    private val courseDao: CourseDao = database.courseDao()
    private val groupDao:GroupDao = database.groupDao()

    override fun getCourses(): LiveData<List<CourseEntity>> = courseDao.getCourses()

    override fun getGroupCount(id: Int): LiveData<Int> = courseDao.getGroupCount(id)

    override fun insert(courseEntity: CourseEntity) = courseDao.insert(courseEntity)

    override fun update(courseEntity: CourseEntity) = courseDao.update(courseEntity)

    override fun getGroups(id: Int): LiveData<List<GroupEntity>> = groupDao.getGroups(id)

    override fun insert(groupEntity: GroupEntity) = groupDao.insert(groupEntity)

    override fun delete(groupEntity: GroupEntity) = groupDao.delete(groupEntity)

    override fun update(groupEntity: GroupEntity) = groupDao.update(groupEntity)
}