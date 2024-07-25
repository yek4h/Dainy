package vip.aridi.meetup.scenario

import org.bukkit.Bukkit
import org.bukkit.event.Listener
import org.bukkit.inventory.ItemStack
import org.example.vip.aridi.meetup.Dainy

/*
 * This project can't be redistributed without
 * authorization of the developer
 *
 * Project @ Dainy
 * @author yek4h © 2024
 * Date: 23/07/2024
*/

abstract class Scenario(
    val name: String,
    val icon: ItemStack,
    val description: String
) : Listener {

    var isActive: Boolean = false

    fun handleToggle() {
        Bukkit.getPluginManager().registerEvents(this, Dainy.get())
    }
}