package vip.aridi.meetup.util

import org.bukkit.inventory.ItemStack
import rip.katz.api.utils.ItemBuilder
import vip.aridi.meetup.loader.Loader
import vip.aridi.meetup.loader.module.sub.ScenarioModule
import vip.aridi.meetup.scenario.Scenario


/*
 * This project can't be redistributed without
 * authorization of the developer
 *
 * Project @ Dainy
 * @author yek4h © 2024
 * Date: 25/07/2024
*/

object Util {

    private val scenarioConfig = Loader.configModule.scenarioConfig.config

    @JvmStatic
    fun getScenarioItem(scenario: Scenario): ItemStack {
        val lore = scenarioConfig.getStringList("SCENARIOS.LORE").map { line ->
            CC.translate(
                line.replace("<description>", scenario.description)
            )
        }

        return ItemBuilder(scenario.icon.type)
            .data(scenario.icon.durability.toInt())
            .amount(scenario.icon.amount)
            .name(CC.translate(scenarioConfig.getString("SCENARIOS.NAME-COLOR") + scenario.name))
            .lore(lore).build()
    }
}