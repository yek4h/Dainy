package vip.aridi.meetup.database

import com.mongodb.client.MongoClients
import com.mongodb.client.MongoCollection
import org.bson.Document


/*
 * This project can't be redistributed without
 * authorization of the developer
 *
 * Project @ Dainy
 * @author yek4h © 2024
 * Date: 25/07/2024
*/

object MongoDatabase {

    private val client = MongoClients.create("mongodb://localhost:27017")
    val database = client.getDatabase("meetup")

    fun getCollection(collectionName: String): MongoCollection<Document> {
        return database.getCollection(collectionName)
    }

    inline fun <reified T> getCollection(collectionName: String, documentClass: Class<T>): MongoCollection<T> {
        return database.getCollection(collectionName, documentClass)
    }

    fun close() {
        client.close()
    }
}