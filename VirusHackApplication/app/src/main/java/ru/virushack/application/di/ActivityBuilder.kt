package ru.virushack.application.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.virushack.application.ui.details.GreenhouseDetailsModule
import ru.virushack.application.ui.details.view.GreenhouseDetailsActivity
import ru.virushack.application.ui.list.GreenhouseListModule
import ru.virushack.application.ui.list.view.GreenhouseListActivity
import ru.virushack.application.ui.splash.SplashActivityModule
import ru.virushack.application.ui.splash.view.SplashActivity

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [SplashActivityModule::class])
    abstract fun bindSplashActivity(): SplashActivity

    @ContributesAndroidInjector(modules = [GreenhouseListModule::class])
    abstract fun bindGreenhouseListActivity(): GreenhouseListActivity

    @ContributesAndroidInjector(modules = [GreenhouseDetailsModule::class])
    abstract fun bindGreenhouseDetailsActivity(): GreenhouseDetailsActivity
}