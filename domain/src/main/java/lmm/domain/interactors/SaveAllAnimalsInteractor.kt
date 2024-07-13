package lmm.domain.interactors

import lmm.data.repository.AnimalRepository

class SaveAllAnimalsInteractor(private val animalRepository: AnimalRepository) {
    suspend fun execute() {
        val animals = animalRepository.getAnimalsForSaving()
        animalRepository.saveAll(animals)
    }
}
