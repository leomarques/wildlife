package lmm.data.animalreader

import android.content.Context

interface AnimalReader {
    fun getAnimals(context: Context): List<AnimalReaderModel>
}
