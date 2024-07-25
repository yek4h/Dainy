package vip.aridi.meetup.profile

import com.mongodb.client.model.Filters
import com.mongodb.client.model.UpdateOptions
import org.bson.Document
import vip.aridi.meetup.database.MongoDatabase
import java.util.UUID


/*
 * This project can't be redistributed without
 * authorization of the developer
 *
 * Project @ Dainy
 * @author yek4h © 2024
 * Date: 25/07/2024
*/

class Profile(
    val uuid: UUID,
    var name: String = "???"
) {

    init {
        onLoad()
    }

    private fun onLoad() {
        val document = MongoDatabase.getCollection("profiles")
            .find(Filters.eq("uniqueId", uuid.toString()))
            .first()

        document?.let {
            name = it.getString("userName") ?: "???"
        }
    }

    fun onSave() {
        val document = Document().apply {
            put("uniqueId", uuid.toString())
            put("userName", name)
        }

        MongoDatabase.getCollection("profiles")
            .replaceOne(Filters.eq("uniqueId", uuid.toString()), document, UpdateOptions().upsert(true))

    }


}