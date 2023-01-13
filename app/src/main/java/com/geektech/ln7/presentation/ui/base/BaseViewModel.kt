package com.geektech.ln7.presentation.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geektech.ln7.domain.utils.Resource
import com.geektech.ln7.presentation.utils.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.Flow

abstract class BaseViewModel:ViewModel() {

    protected fun <T> Flow<Resource<T>>.collectFlow(_state: MutableStateFlow<UIState<T>>) {
        viewModelScope.launch {
            this@collectFlow.collect {
                when (it) {
                    is Resource.Loading -> {
                        _state.value =UIState.Loading()
                    }
                    is Resource.Error -> {
                        _state.value =UIState.Error(it.massage!!)
                    }
                    is Resource.Success -> {
                        if (it.data != null) {
                            _state.value = UIState.Success(it.data)
                        }
                    }
                }
            }
        }
    }

}