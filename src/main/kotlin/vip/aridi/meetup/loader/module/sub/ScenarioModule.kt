package vip.aridi.meetup.loader.module.sub

import vip.aridi.meetup.loader.module.IModule
import vip.aridi.meetup.scenario.Scenario
import vip.aridi.meetup.scenario.sub.NoFallScenario
import vip.aridi.meetup.scenario.sub.NoScenario


/*
 * This project can't be redistributed without
 * authorization of the developer
 *
 * Project @ Dainy
 * @author yek4h © 2024
 * Date: 23/07/2024
*/

class ScenarioModule(
): IModule {

    val scenarios: MutableList<Scenario> = mutableListOf()

    override fun order(): Int {
        return 3
    }

    override fun load() {
        scenarios.addAll(listOf(
            NoScenario(),
            NoFallScenario()
        ))
    }

    override fun unload() {
        //Unload Scenarios
    }

    override fun reload() {
        //Reload scenarios
    }

    fun getByName(input: String): Scenario? {
        return scenarios.firstOrNull { it.name.equals(input, ignoreCase = true) }
    }

    override fun moduleName(): String {
        return "Scenarios"
    }
}