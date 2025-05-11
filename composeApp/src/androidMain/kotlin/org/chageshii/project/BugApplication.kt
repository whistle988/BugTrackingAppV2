package org.chageshii.project

import android.app.Application
import org.chageshii.project.di.initKoin
import org.koin.android.ext.koin.androidContext

class BugApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@BugApplication)
        }
    }
}
