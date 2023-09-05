package lmm.data.animalreader

data class AnimalReaderModel(
    val name: String,
    val appelation: String,
    val tier: String,
    val bodyType: String,
    val weapon: String,
    val trapper: Int,
    val camp: Int,
    val total: Int,
    val have: Int,
    val need: Int,
)
