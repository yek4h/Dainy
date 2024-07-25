package vip.aridi.meetup.loader.module.sub

import org.example.vip.aridi.meetup.Dainy
import vip.aridi.meetup.loader.module.IModule
import vip.aridi.meetup.util.Configuration


/*
 * This project can't be redistributed without
 * authorization of the developer
 *
 * Project @ Dainy
 * @author yek4h © 2024
 * Date: 23/07/2024
*/

class ConfigurationModule(
): IModule {

    lateinit var mainConfig: Configuration
    lateinit var scenarioConfig: Configuration
    override fun order(): Int {
        return 1
    }

    override fun load() {
        mainConfig = Configuration(Dainy.get(), "config", "yml")
        scenarioConfig = Configuration(Dainy.get(), "scenario", "yml")
    }

    override fun unload() {
        mainConfig.save()
        scenarioConfig.save()
    }

    override fun reload() {
        mainConfig.reload()
        scenarioConfig.reload()
    }

    override fun moduleName(): String {
        return "Configuration"
    }
}