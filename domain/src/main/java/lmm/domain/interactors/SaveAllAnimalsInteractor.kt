package lmm.domain.interactors

import lmm.data.repository.AnimalRepository

class SaveAllAnimalsInteractor(private val animalRepository: AnimalRepository) {

    suspend fun execute(onDone: suspend (() -> Unit)) {
        animalRepository.getAnimalsForSaving().collect { animals ->
            animalRepository.saveAll(animals)
            onDone()
        }
    }
}
