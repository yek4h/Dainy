package vip.aridi.meetup.game

import org.bukkit.Material
import org.bukkit.World
import org.bukkit.entity.Player
import org.example.vip.aridi.meetup.Dainy
import vip.aridi.meetup.Dainy
import vip.aridi.meetup.loader.Loader
import vip.aridi.meetup.profile.Profile
import java.util.Random


/*
 * This project can't be redistributed without
 * authorization of the developer
 *
 * Project @ Dainy
 * @author yek4h © 2024
 * Date: 25/07/2024
*/

class MeetupManager(
) {

    private val plugin: Dainy = Dainy.get()
    private val seatedPlayer: MutableMap<Player, Int> = mutableMapOf()
    private val allowedBlocks: MutableList<Material> = mutableListOf()
    private var announcement = false

    fun startGame() {

    }

    fun startCountdown() {

    }

    fun checkForWinners() {

    }

    private fun selectWinner(/* Probably we will put profile here */) {

    }

    fun setupAllowedBlocks() {

    }

    fun loadWorldChunks() {

    }

    fun sitPlayer() {

    }

    fun unsitPlayer() {

    }

    fun onWorldLoaded(world: World) {

    }

    companion object {
        val data = MeetupDataGame()
    }
}