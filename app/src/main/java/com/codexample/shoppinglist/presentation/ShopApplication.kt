package com.codexample.shoppinglist.presentation

import android.app.Application
import com.codexample.shoppinglist.di.DaggerApplicationComponent

class ShopApplication: Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}