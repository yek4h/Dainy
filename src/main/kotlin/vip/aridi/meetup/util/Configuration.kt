package vip.aridi.meetup.util

import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.java.JavaPlugin
import java.io.File
import java.io.IOException

/*
 * This project can't be redistributed without
 * authorization of the developer
 *
 * Project @ Dainy
 * @author yek4h © 2024
 * Date: 23/07/2024
*/

class Configuration(
    private val plugin: JavaPlugin,
    fileName: String,
    extension: String = "yml",
    folder: String = plugin.dataFolder.path
) {

    private val file: File = File(folder, "$fileName.$extension")
    var config: FileConfiguration = createFile()

    private fun createFile(): FileConfiguration {
        if (!file.exists()) {
            file.parentFile.mkdirs()
            if (plugin.getResource(file.name) == null) {
                try {
                    file.createNewFile()
                } catch (e: IOException) {
                    plugin.logger.severe("Failed to create new file ${file.name}")
                }
            } else {
                plugin.saveResource(file.name, false)
            }
        }
        return YamlConfiguration.loadConfiguration(file)
    }

    fun save() {
        try {
            config.save(file)
        } catch (e: IOException) {
            plugin.logger.severe("Could not save config file ${file.name}")
            e.printStackTrace()
        }
    }

    fun reload() {
        try {
            config = YamlConfiguration.loadConfiguration(file)
        } catch (e: IOException) {
            plugin.logger.severe("Couldn't reload the config file ${file.name}")
            e.printStackTrace()
        }
    }
}