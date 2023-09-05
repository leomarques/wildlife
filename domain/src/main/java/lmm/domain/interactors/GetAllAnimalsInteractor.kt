package lmm.domain.interactors

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import lmm.data.repository.AnimalRepository
import lmm.domain.model.Animal

class GetAllAnimalsInteractor(private val animalRepository: AnimalRepository) {

    fun execute(): Flow<List<Animal>> {
        return animalRepository.getAll().map { animalEntityList ->
            animalEntityList.map { animalEntity ->
                with(animalEntity) {
                    Animal(
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
        }
    }
}
