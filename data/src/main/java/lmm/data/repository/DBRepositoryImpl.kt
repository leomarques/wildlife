package lmm.data.repository

import lmm.data.database.AnimalDatabase

class DBRepositoryImpl : DBRepository {
    override fun isDBCreated() = AnimalDatabase.isDBCreated()
}
