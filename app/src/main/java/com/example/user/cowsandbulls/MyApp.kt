package com.example.user.cowsandbulls

import android.app.Application
import com.example.user.cowsandbulls.dagger.AppComponent
import com.example.user.cowsandbulls.dagger.AppModule
import com.example.user.cowsandbulls.dagger.DaggerAppComponent

class MyApp(): Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = initDagger(this)
    }

    fun initDagger(app: MyApp): AppComponent =
            DaggerAppComponent.builder()
                    .appModule(AppModule(app))
                    .build()
}