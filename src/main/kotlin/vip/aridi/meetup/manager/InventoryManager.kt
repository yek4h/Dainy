package vip.aridi.meetup.manager

import org.bukkit.Bukkit
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import vip.aridi.meetup.loader.Loader
import vip.aridi.meetup.util.Util


/*
 * This project can't be redistributed without
 * authorization of the developer
 *
 * Project @ Dainy
 * @author yek4h © 2024
 * Date: 27/07/2024
*/

class InventoryManager {

    private val scenarioInventory: Inventory = Bukkit.createInventory(null, 18, "Scenarios")

    init {
        initializeScenarioInventory()
    }

    private fun initializeScenarioInventory() {
        setupInventory()
    }

    private fun setupInventory() {
        clearInventory()
        populateInventory()
    }

    private fun clearInventory() {
        scenarioInventory.clear()
    }

    private fun populateInventory() {
        val scenarios = Loader.scenarioModule.scenarios.sortedBy { it.name }
        for (scenario in scenarios) {
            val item = Util.getScenarioItem(scenario)
            addItemToInventory(item)
        }
    }

    private fun addItemToInventory(item: ItemStack) {
        scenarioInventory.addItem(item)
    }

    fun refreshScenarios() {
        setupInventory()
    }

    fun getScenarioInventory(): Inventory {
        return scenarioInventory
    }
}