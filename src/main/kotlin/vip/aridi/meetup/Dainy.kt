package org.example.vip.aridi.meetup

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import vip.aridi.meetup.loader.KLoader
import vip.aridi.meetup.loader.Loader


/*
 * This project can't be redistributed without
 * authorization of the developer
 *
 * Project @ Dainy
 * @author yek4h © 2024
 * Date: 23/07/2024
*/

class Dainy(
) : JavaPlugin() {

    lateinit var load: KLoader

    override fun onEnable() {
        load = Loader(this)
    }

    override fun onDisable() {

    }

    companion object {
        fun get(): Dainy {
            return getPlugin(Dainy::class.java)
        }
    }
}