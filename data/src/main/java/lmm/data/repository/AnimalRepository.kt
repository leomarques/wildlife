package lmm.data.repository

import kotlinx.coroutines.flow.Flow
import lmm.data.database.AnimalEntity

interface AnimalRepository {
    fun getAll(): Flow<List<AnimalEntity>>
    suspend fun saveAll(list: List<AnimalEntity>)
    suspend fun getAnimalsForSaving(): Flow<List<AnimalEntity>>
}
