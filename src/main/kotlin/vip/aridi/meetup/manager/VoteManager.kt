package vip.aridi.meetup.manager

import org.bukkit.Sound
import org.bukkit.entity.Player
import vip.aridi.meetup.loader.Loader
import vip.aridi.meetup.scenario.Scenario
import vip.aridi.meetup.util.CC

/*
 * This project can't be redistributed without
 * authorization of the developer
 *
 * Project @ Dainy
 * Author yek4h © 2024
 * Date: 26/07/2024
*/

class VoteManager {

    private val votes: MutableMap<Scenario, Int> = Loader.scenarioModule.scenarios.associateWith { 0 }.toMutableMap()
    private val lastVotedMap: MutableMap<Player, String?> = mutableMapOf()

    init {
        Loader.scenarioModule.scenarios.forEach { scenario ->
            votes[scenario] = 0
        }
    }

    fun getHighestVote(): Scenario {
        return votes.maxByOrNull { it.value }?.key
            ?: Loader.scenarioModule.getByName("Default")
            ?: error("Default scenario not found")
    }

    fun handleAddVote(player: Player, scenario: Scenario) {
        votes[scenario] = votes.getOrDefault(scenario, 0) + 1
        lastVotedMap[player] = scenario.name

        player.sendMessage(CC.translate("&CYou have already voted for &C${scenario.name}"))

        player.playSound(player.location, Sound.NOTE_PIANO, 1f, 1f)
    }

    fun handleRemove(player: Player, newVote: Scenario) {
        val lastVoted = lastVotedMap[player]

        if (lastVoted == newVote.name) {
            player.sendMessage(CC.translate("&CYou have already voted for &C${newVote.name}"))
            player.playSound(player.location, Sound.DIG_GRASS, 1f, 1f)
            return
        }

        val oldScenario = lastVoted?.let { Loader.scenarioModule.getByName(it) } ?: return

        votes[oldScenario] = votes.getOrDefault(oldScenario, 0) - 1
        lastVotedMap[player] = null

        handleAddVote(player, newVote)
    }

    fun handleRemoveOne(scenario: Scenario) {
        votes[scenario] = votes.getOrDefault(scenario, 0) - 1
    }

    fun hasVoted(player: Player): Boolean {
        return lastVotedMap[player] != null
    }

    fun getVotes(): Map<Scenario, Int> = votes.toMap()
}
