package lmm.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
        AnimalEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AnimalDatabase : RoomDatabase() {

    abstract fun animalDao(): AnimalDao

    companion object {

        @Volatile
        private var INSTANCE: AnimalDatabase? = null

        fun isDBCreated() =
            if (INSTANCE != null) true else synchronized(this) {
                INSTANCE != null
            }

        fun getInstance(context: Context): AnimalDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE
                    ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AnimalDatabase::class.java, "Animal.db"
            )
                .build()
    }
}
