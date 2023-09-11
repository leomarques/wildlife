package lmm.domain.interactors

import lmm.data.repository.DBRepository

class DataInteractor(private val dbRepository: DBRepository) {

    fun isFirstTime() = dbRepository.isDBCreated()
}
