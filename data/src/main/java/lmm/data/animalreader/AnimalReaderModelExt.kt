package lmm.data.animalreader

import lmm.data.database.AnimalEntity

fun List<AnimalReaderModel>.toAnimalEntity(): List<AnimalEntity> {
    return map {
        with(it) {
            AnimalEntity(
                name = name,
                appelation = appelation,
                tier = tier,
                bodyType = bodyType,
                weapon = weapon,
                trapper = trapper,
                camp = camp,
                total = total,
                have = have,
                need = need
            )
        }
    }
}