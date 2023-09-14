package lmm.data.repository

import lmm.data.database.AnimalEntity

interface AnimalRepository {
    suspend fun getAll(): List<AnimalEntity>
    suspend fun saveAll(list: List<AnimalEntity>)
    suspend fun getAnimalsForSaving(): List<AnimalEntity>
    suspend fun isTableEmpty(): Boolean
}
