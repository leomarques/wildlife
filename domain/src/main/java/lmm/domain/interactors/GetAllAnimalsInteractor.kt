package lmm.domain.interactors

import lmm.data.repository.AnimalRepository
import lmm.domain.model.Animal
import java.text.Normalizer

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
                    camp,
                    total,
                    have,
                    need
                )
            }
        }.sortedBy { animal -> animal.name.normalize() }
    }
}

fun CharSequence.normalize(): String {
    val temp = Normalizer.normalize(this, Normalizer.Form.NFD)
    return "\\p{InCombiningDiacriticalMarks}+".toRegex().replace(temp, "")
}