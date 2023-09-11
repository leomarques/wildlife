package lmm.data.repository

import android.content.Context
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import lmm.data.animalreader.AnimalReader
import lmm.data.coroutine.CoroutineDispatcherProvider
import lmm.data.database.AnimalDao
import lmm.data.database.AnimalEntity

class AnimalRepositoryImpl(
    private val animalDao: AnimalDao,
    private val animalReader: AnimalReader,
    private val coroutineDispatcherProvider: CoroutineDispatcherProvider,
    private val context: Context
) : AnimalRepository {

    override fun getAll(): Flow<List<AnimalEntity>> {
        return animalDao.selectAll()
    }

    override suspend fun saveAll(list: List<AnimalEntity>) {
        withContext(coroutineDispatcherProvider.provide()) {
            list.forEach { animal ->
                animalDao.insert(animal)
            }
        }
    }

    override suspend fun getAnimalsForSaving(): Flow<List<AnimalEntity>> {
        return withContext(coroutineDispatcherProvider.provide()) {
            return@withContext listOf(
                animalReader.getAnimals(context).map {
                    with(it) {
                        AnimalEntity(
                            name,
                            appelation,
                            tier,
                            bodyType,
                            weapon,
                            trapper,
                            camp,
                            total,
                            have,
                            need
                        )
                    }
                }
            ).asFlow()
        }
    }

    override fun isDBEmpty() = flow {
        animalDao.selectAll().collect {
            emit(it.isEmpty())
        }
    }
}
