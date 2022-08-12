package uz.gita.edumedupedu.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.gita.edumedupedu.data.room.daos.CourseDao
import uz.gita.edumedupedu.data.room.daos.GroupDao
import uz.gita.edumedupedu.data.room.entities.CourseEntity
import uz.gita.edumedupedu.data.room.entities.GroupEntity

@Database(entities = [CourseEntity::class, GroupEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun courseDao(): CourseDao
    abstract fun groupDao(): GroupDao

    companion object {
        private var instanse: AppDatabase? = null

        fun init(context: Context) {
            if (instanse == null) {
                instanse = Room.databaseBuilder(context,AppDatabase::class.java, "edu_db.db")
                    .allowMainThreadQueries()
                    .build()
            }
        }

        fun getInstance():AppDatabase = instanse!!
    }
}