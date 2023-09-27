package lmm.data.repository

import android.content.Context
import kotlinx.coroutines.withContext
import lmm.data.animalreader.AnimalReader
import lmm.data.animalreader.toAnimalEntity
import lmm.data.coroutine.CoroutineDispatcherProvider
import lmm.data.database.AnimalDao
import lmm.data.database.AnimalEntity

class AnimalRepositoryImpl(
    private val animalDao: AnimalDao,
    private val animalReader: AnimalReader,
    private val coroutineDispatcherProvider: CoroutineDispatcherProvider,
    private val context: Context
) : AnimalRepository {

    override suspend fun getAll(): List<AnimalEntity> {
        return animalDao.selectAll()
    }

    override suspend fun saveAll(list: List<AnimalEntity>) {
        list.forEach { animal ->
            animalDao.insert(animal)
        }
    }

    override suspend fun getAnimalsForSaving(): List<AnimalEntity> {
        return withContext(coroutineDispatcherProvider.provide()) {
            animalReader.getAnimals(context).toAnimalEntity()
        }
    }
}
