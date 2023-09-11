package lmm.data.coroutine

import kotlinx.coroutines.Dispatchers

class CoroutineDispatcherProviderImpl : CoroutineDispatcherProvider {
    override fun provide() = Dispatchers.IO
}
