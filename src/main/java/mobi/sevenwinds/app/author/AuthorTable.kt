package mobi.sevenwinds.app.author

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.*
import java.time.LocalDateTime

object AuthorTable : IntIdTable("author") {
    val name = text("name")
    val createdAt = timestamp("created_at").default(LocalDateTime.now())
}

class AuthorEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<AuthorEntity>(AuthorTable)

    var name by AuthorTable.name
    var createdAt by AuthorTable.createdAt

    fun toResponse(): AuthorRecord {
        return AuthorRecord(id.value, name, createdAt)
    }
}

data class AuthorRecord(
    val id: Int,
    val name: String,
    val createdAt: LocalDateTime
) 