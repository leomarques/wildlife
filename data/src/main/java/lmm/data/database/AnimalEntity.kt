package lmm.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "animal")
data class AnimalEntity(
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
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
