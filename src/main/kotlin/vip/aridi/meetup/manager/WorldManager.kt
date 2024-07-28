package vip.aridi.meetup.manager

import org.bukkit.World
import org.bukkit.block.Biome
import org.bukkit.scheduler.BukkitRunnable
import vip.aridi.meetup.game.MeetupManager


/*
 * This project can't be redistributed without
 * authorization of the developer
 *
 * Project @ Dainy
 * @author yek4h © 2024
 * Date: 28/07/2024
*/

class WorldManager(
    private val meetupManager: MeetupManager
): BukkitRunnable() {

    private var world: World? = null
    private var isGenerating = false

    init {
        //Remove dir and adjust biomes logic
    }

    override fun run() {
        TODO("Not yet implemented")
    }

    private fun createNewWorld() {

    }

    private fun noValidCenter(): Boolean {
        //checkers
        return true
    }

    private fun regenerateWorld() {
        //Regen world
    }

    private fun createLockFile() {
        // gen lock and create a new world
    }

    private fun cleanDirectory() {
        // Remove the directory
    }

    private fun adjustBiome() {
        //Put the logic for adjust the world biome
    }

    private fun setBiome(from: Biome, to: Biome, plus: Int) {
        // From biome, to the new biome, and the ID logic or something
    }


}