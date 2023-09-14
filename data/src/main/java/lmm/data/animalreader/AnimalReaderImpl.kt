package lmm.data.animalreader

import android.content.Context
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import java.io.BufferedReader

class AnimalReaderImpl : AnimalReader {
    override suspend fun getAnimals(context: Context): List<AnimalReaderModel> {
        val bufferReader = BufferedReader(context.assets.open("wildlife.csv").reader())
        val csvParser = CSVParser.parse(
            bufferReader,
            CSVFormat.DEFAULT
        )
        val list = mutableListOf<AnimalReaderModel>()
        csvParser.forEach {
            it?.let {
                val animals = AnimalReaderModel(
                    name = it.get(0),
                    appelation = it.get(1),
                    tier = it.get(2),
                    bodyType = it.get(3),
                    weapon = it.get(4),
                    trapper = it.get(5).toInt(),
                    camp = it.get(6).toInt(),
                    total = it.get(7).toInt(),
                    have = it.get(8).toInt(),
                    need = it.get(9).toInt(),
                )
                list.add(animals)
            }
        }

        return list
    }
}
