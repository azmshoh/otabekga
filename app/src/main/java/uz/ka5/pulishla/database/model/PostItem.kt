package uz.ka5.pulishla.database.model

data class PostItem(
    private val typeId: Int,
    val id: String,
    val url: String,
    val admin: String,
    val view: Long
) : PostModel(typeId)