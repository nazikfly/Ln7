package com.geektech.ln7.presentation.ui.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewbinding.ViewBinding
import com.geektech.ln7.presentation.utils.UIState
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class BaseFragment<VB:ViewBinding, VM:ViewModel>(
    @LayoutRes layoutId:Int,
) :Fragment(layoutId) {

    protected abstract val viewModel: VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initialize()
        setupListeners()
        setupSubscribers()
        setupRequest()
    }
    protected open fun initialize(){
    }
    protected open fun setupListeners(){
    }
    protected open fun setupSubscribers(){
    }
    protected open fun setupRequest(){}

    protected fun <T> StateFlow<UIState<T>>.collectState(
        onLoading: () -> Unit,
        onError: (message:String) -> Unit,
        onSuccess: (data:T) -> Unit
    ) {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                this@collectState.collect { state ->
                    when (state) {
                        is UIState.Empty -> {}
                        is UIState.Error -> onError(state.massage)
                        is UIState.Loading -> onLoading()
                        is UIState.Success -> onSuccess(state.data)
                    }
                }
            }
        }
    }
}