package vip.aridi.meetup.loader

import org.bukkit.command.ConsoleCommandSender
import org.example.vip.aridi.meetup.Dainy
import vip.aridi.meetup.loader.module.IModule
import vip.aridi.meetup.loader.module.sub.ConfigurationModule
import vip.aridi.meetup.loader.module.sub.ProfileModule
import vip.aridi.meetup.loader.module.sub.ScenarioModule
import vip.aridi.meetup.util.CC


/*
 * This project can't be redistributed without
 * authorization of the developer
 *
 * Project @ Dainy
 * @author yek4h © 2024
 * Date: 23/07/2024
*/

class Loader(d: Dainy) : KLoader {

    private val modules: MutableList<IModule> = mutableListOf()
    private val console: ConsoleCommandSender = d.server.consoleSender

    companion object {
        @JvmStatic
        val configModule = ConfigurationModule()
        val profileModule = ProfileModule()
        val scenarioModule = ScenarioModule()
    }

    init {
        startup()
        console.sendMessage(CC.translate("&7[&dDainy&7] &aModule startup task finished successfully"))
    }

    /**
     * I Already know use enabled and disabled
     * when there's a startup method is useless
     * but when you obfuscate all this looks very different
     * that's why I decided to add one more useless method :p
     *
     * yek4h - 2024
     */

    override fun startup() {
        console.sendMessage(CC.translate("&7[&dDainy&7] &aModule startup task has been initialized"))
        initModules()
        enabled()
    }

    private fun initModules() {
        addModules(configModule)
        addModules(profileModule)
        addModules(scenarioModule)
    }

    override fun enabled() {
        loadModules()
    }

    override fun disabled() {
        unloadModules()
    }

    override fun loadModules() {
        modules.sortedBy { it.order() }.forEach {
            it.load()
            console.sendMessage(CC.translate("&7[&dModule System&7] &a${it.moduleName()} has been enabled successfully"))
        }
    }

    override fun unloadModules() {
        modules.sortedByDescending { it.order() }.forEach {
            it.unload()
            console.sendMessage(CC.translate("&7[&dModule System&7] &c${it.moduleName()} has been disabled successfully"))
        }
    }

    override fun addModules(iModule: IModule) {
        modules.add(iModule)
    }

    override fun reloadModule(moduleName: Int) {
        modules.firstOrNull { it.order() == moduleName }?.reload()
    }
}