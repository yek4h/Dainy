package vip.aridi.meetup.loader.module.sub

import vip.aridi.meetup.loader.module.IModule
import vip.aridi.meetup.manager.VoteManager


/*
 * This project can't be redistributed without
 * authorization of the developer
 *
 * Project @ Dainy
 * @author yek4h © 2024
 * Date: 26/07/2024
*/

class ManagerModule(
): IModule {

    lateinit var voteManager: VoteManager

    override fun order(): Int {
        return 12
    }

    override fun load() {
        voteManager = VoteManager()
    }

    override fun unload() {
        // Implement Unload Logic
    }

    override fun reload() {
        // Implement Reload Logic
    }

    override fun moduleName(): String {
        return "Managers"
    }
}