package lmm.data.animalreader

import android.content.Context

interface AnimalReader {
    suspend fun getAnimals(context: Context): List<AnimalReaderModel>
}
