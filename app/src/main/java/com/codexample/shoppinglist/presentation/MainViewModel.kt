package com.codexample.shoppinglist.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codexample.shoppinglist.domain.DeleteShopItemUseCase
import com.codexample.shoppinglist.domain.EditShopItemUseCase
import com.codexample.shoppinglist.domain.GetShopListUseCase
import com.codexample.shoppinglist.domain.ShopItem
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getShopListUseCase: GetShopListUseCase,
    private val deleteShopItemUseCase: DeleteShopItemUseCase,
    private val editShopItemUseCase: EditShopItemUseCase,
) : ViewModel() {

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(showItem: ShopItem) {
        viewModelScope.launch {
            deleteShopItemUseCase.deleteShopItem(showItem)
        }
    }

    fun changeEnableState(shopItem: ShopItem) {
        viewModelScope.launch {
            val newItem = shopItem.copy(enabled = !shopItem.enabled)
            editShopItemUseCase.editShopItem(newItem)
        }
    }
}