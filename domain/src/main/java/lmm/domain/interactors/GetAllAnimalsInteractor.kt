package lmm.domain.interactors

import lmm.data.repository.AnimalRepository
import lmm.domain.model.Animal

class GetAllAnimalsInteractor(private val animalRepository: AnimalRepository) {
    suspend fun execute(): List<Animal> {
        return animalRepository.getAll().map { animalEntity ->
            with(animalEntity) {
                Animal(
                    name,
                    appelation,
                    tier,
                    bodyType,
                    weapon,
                    trapper,
                    camp
                )
            }
        }
    }
}
