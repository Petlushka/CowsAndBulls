package com.example.user.cowsandbulls

import android.app.Application
import android.arch.persistence.room.Room
import com.example.user.cowsandbulls.dagger.AppComponent
import com.example.user.cowsandbulls.dagger.AppModule
import com.example.user.cowsandbulls.dagger.DaggerAppComponent
import com.example.user.cowsandbulls.model.AppDatabase

class MyApp: Application() {

    public lateinit var appComponent: AppComponent
    lateinit var appDatabase: AppDatabase

    override fun onCreate() {
        super.onCreate()
        appComponent = initDagger(this)
        appDatabase = Room.databaseBuilder(this, AppDatabase::class.java, "appDb").build()
    }

    fun initDagger(app: MyApp): AppComponent =
            DaggerAppComponent.builder()
                    .appModule(AppModule(app))
                    .build()
}