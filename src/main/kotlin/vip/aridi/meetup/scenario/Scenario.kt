package vip.aridi.meetup.scenario

import org.bukkit.Bukkit
import org.bukkit.event.Event
import org.bukkit.event.EventHandler
import org.bukkit.event.HandlerList
import org.bukkit.event.Listener
import org.bukkit.inventory.ItemStack
import vip.aridi.meetup.Dainy
import kotlin.reflect.KClass

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
        private set

    private val eventListeners = mutableListOf<Listener>()

    fun handleToggle() {
        isActive = !isActive
        if (isActive) {
            onEnable()
        } else {
            onDisable()
        }
    }

    open fun onEnable() {
        registerEvents()
    }

    open fun onDisable() {
        unregisterEvents()
    }

    private fun registerEvents() {
        eventListeners.forEach {
            Bukkit.getPluginManager().registerEvents(it, Dainy.get())
        }
    }

    private fun unregisterEvents() {
        eventListeners.forEach {
            HandlerList.unregisterAll(it)
        }
    }

    protected fun <T : Event> subscribe(eventClass: KClass<T>, handler: (T) -> Unit) {
        val listener = object : Listener {
            @Suppress("UNCHECKED_CAST")
            @EventHandler
            fun onEvent(event: Event) {
                if (eventClass.java.isAssignableFrom(event::class.java)) {
                    handler(event as T)
                }
            }
        }
        eventListeners.add(listener)
    }

}