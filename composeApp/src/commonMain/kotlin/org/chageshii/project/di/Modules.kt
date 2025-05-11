package org.chageshii.project.di

import org.chageshii.project.core.data.HttpClientFactory
import org.chageshii.project.screen.data.network.KtorRemoteBugDataSource
import org.chageshii.project.screen.data.network.RemoteBugDataSource
import org.chageshii.project.screen.data.repository.DefaultBugRepository
import org.chageshii.project.screen.presentation.bug_list.BugListViewModel
import org.chageshii.project.screen.domain.BugRepository
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    single { HttpClientFactory.create(get()) }
    singleOf(::KtorRemoteBugDataSource).bind<RemoteBugDataSource>()
    singleOf(::DefaultBugRepository).bind<BugRepository>()

//    single {
//        get<DatabaseFactory>().create()
//            .setDriver(BundledSQLiteDriver())
//            .build()
//    }
//    single { get<FavoriteBugDatabase>().favoriteBugDao }

    viewModelOf(::BugListViewModel)
//    viewModelOf(::BugDetailViewModel)
//    viewModelOf(::SelectedBugViewModel)
}
