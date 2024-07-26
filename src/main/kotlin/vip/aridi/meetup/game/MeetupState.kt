package vip.aridi.meetup.game

import org.bukkit.ChatColor


/*
 * This project can't be redistributed without
 * authorization of the developer
 *
 * Project @ Dainy
 * @author yek4h © 2024
 * Date: 26/07/2024
*/

enum class MeetupState(val prettyName: String, val color: ChatColor) {
    GAME_ENDED("Game Ended.", ChatColor.YELLOW),
    IN_GAME("In Game", ChatColor.RED),
    STARTING_GAME("Starting", ChatColor.GOLD),
    WAITING("Waiting", ChatColor.GREEN);

    fun formatted(): String {
        return "$color$prettyName"
    }
}