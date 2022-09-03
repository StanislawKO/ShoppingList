package com.codexample.shoppinglist.di

import android.app.Application
import com.codexample.shoppinglist.data.AppDatabase
import com.codexample.shoppinglist.data.ShopListDao
import com.codexample.shoppinglist.data.ShopListRepositoryImpl
import com.codexample.shoppinglist.domain.ShopListRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindShopListRepository(impl: ShopListRepositoryImpl): ShopListRepository

    companion object {

        @ApplicationScope
        @Provides
        fun provideShopListDao(
            application: Application
        ): ShopListDao {
            return AppDatabase.getInstance(application).shopListDao()
        }
    }
}
