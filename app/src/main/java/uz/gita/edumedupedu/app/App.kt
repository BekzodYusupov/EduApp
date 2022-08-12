package uz.gita.edumedupedu.app

import android.app.Application
import uz.gita.edumedupedu.data.room.AppDatabase

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        AppDatabase.init(this)
    }
}