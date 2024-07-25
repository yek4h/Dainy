package vip.aridi.meetup.util

import org.bukkit.ChatColor


/*
 * This project can't be redistributed without
 * authorization of the developer
 *
 * Project @ Dainy
 * @author yek4h © 2024
 * Date: 23/07/2024
*/

object CC {

    val dainyColor = ChatColor.LIGHT_PURPLE

    @JvmStatic
    fun translate(cc: String): String {
        return ChatColor.translateAlternateColorCodes('&', cc)
    }

}