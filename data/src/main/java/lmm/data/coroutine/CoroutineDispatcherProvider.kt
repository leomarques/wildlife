package lmm.data.coroutine

import kotlinx.coroutines.CoroutineDispatcher

interface CoroutineDispatcherProvider {
    fun provide(): CoroutineDispatcher
}
