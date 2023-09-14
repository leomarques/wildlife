package lmm.domain.interactors

import lmm.data.repository.AnimalRepository

class DataInteractor(private val animalRepository: AnimalRepository) {

    suspend fun shouldPopulateDB() = animalRepository.isTableEmpty()
}
