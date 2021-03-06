package com.aday.abook

import android.app.Application
import android.app.IntentService
import com.aday.abook.feature.main.MainComponent
import com.aday.abook.feature.addbook.AddBookComponent
import com.aday.abook.feature.memo.BookMemoComponent
import com.aday.abook.feature.search.BookSearchComponent
import com.aday.abook.feature.calendar.CalendarComponent
import com.aday.abook.feature.booklist.BookListComponent
import com.aday.abook.feature.setting.SettingComponent
import com.aday.abook.mvvm.ViewModelModule
import com.aday.core.dagger.module.APIModule
import com.aday.core.dagger.module.ApplicationModule
import com.aday.core.dagger.module.HttpClientModule
import com.aday.core.dagger.module.RoomModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [ApplicationModule::class,
        HttpClientModule::class,
        APIModule::class,
        ViewModelModule::class,
        RoomModule::class
])

interface ApplicationComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(baseApplication: BaseApplication)

    fun inject(intentService: IntentService)

    //add component builder 여기로 들어오면 이제 다른 컨포넌트로 들어갈 수 있음
    fun addBookComponentBuilder(): AddBookComponent.Builder

    fun bookMemoComponentBuilder(): BookMemoComponent.Builder

    fun bookSearchComponentBuilder(): BookSearchComponent.Builder

    fun mainComponentBuilder(): MainComponent.Builder

    fun calendarComponentBuilder(): CalendarComponent.Builder

    fun bookListComponentBuilder(): BookListComponent.Builder

    fun settingComponentBuilder(): SettingComponent.Builder
}