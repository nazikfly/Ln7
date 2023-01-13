package com.geektech.ln7.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geektech.ln7.domain.utils.Resource
import com.geektech.ln7.presentation.utils.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.util.concurrent.Flow

abstract class BaseViewModel:ViewModel() {

    protected fun <T> Flow<Resource<T>>.collectFlow(_state: MutableStateFlow<UIState<T>>) {
        viewModelScope.launch {
            this@collectFlow.collect {
                when (it) {
                    is Resource.Loading -> {
                        _state.value = com.geektech.ln7.presentation.utils.UIState.Loanding()
                    }
                    is Resource.Error -> {
                        _state.value =
                            com.geektech.ln7.presentation.utils.UIState.Error(it.message!!)
                    }
                    is Resource.Success -> {
                        if (it.data != null) {
                            _state.value =
                                com.geektech.ln7.presentation.utils.UIState.Success(it.data)
                        }
                    }
                }
            }
        }
    }

}