package lmm.data

import lmm.data.animalreader.AnimalReader
import lmm.data.animalreader.AnimalReaderImpl
import lmm.data.coroutine.CoroutineDispatcherProvider
import lmm.data.coroutine.CoroutineDispatcherProviderImpl
import lmm.data.database.AnimalDatabase
import lmm.data.repository.AnimalRepository
import lmm.data.repository.AnimalRepositoryImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val dataModule = module {
    single {
        AnimalDatabase.getInstance(get()).animalDao()
    }

    factoryOf(::CoroutineDispatcherProviderImpl) { bind<CoroutineDispatcherProvider>() }

    factoryOf(::AnimalRepositoryImpl) { bind<AnimalRepository>() }
    factoryOf(::AnimalReaderImpl) { bind<AnimalReader>() }
}
