package lmm.data.coroutine

import kotlinx.coroutines.Dispatchers
import lmm.data.coroutine.CoroutineDispatcherProvider

class CoroutineDispatcherProviderImpl : CoroutineDispatcherProvider {
    override fun provide() = Dispatchers.IO
}
