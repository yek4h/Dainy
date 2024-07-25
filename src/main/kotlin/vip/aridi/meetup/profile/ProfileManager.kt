package vip.aridi.meetup.profile

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import org.bson.Document
import vip.aridi.meetup.database.MongoDatabase
import java.util.*
import java.util.concurrent.ConcurrentHashMap


/*
 * This project can't be redistributed without
 * authorization of the developer
 *
 * Project @ Dainy
 * @author yek4h © 2024
 * Date: 25/07/2024
*/

object ProfileManager {
    private val profiles: ConcurrentHashMap<UUID, Profile> = ConcurrentHashMap()
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    fun start() {
        val collection = MongoDatabase.getCollection("profiles")

        collection.find().forEach { doc ->
            scope.launch {
                val profile = parse(doc)
                profiles[profile.uuid] = profile
            }
        }
    }

    fun stop() {
        profiles.values.forEach {
            it.onSave()
            profiles.remove(it.uuid, it)
        }
    }


    private fun parse(doc: Document): Profile {
        return Profile(UUID.fromString(doc.getString("uniqueId")))
    }

    fun findByUUID(uuid: UUID?): Profile? {
        return uuid?.let { profiles[it] }
    }

    fun putAbsentProfile(profile: Profile) {
        profiles.putIfAbsent(profile.uuid, profile)
    }
}