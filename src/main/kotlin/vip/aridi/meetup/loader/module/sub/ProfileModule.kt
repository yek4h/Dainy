package vip.aridi.meetup.loader.module.sub

import vip.aridi.meetup.loader.module.IModule
import vip.aridi.meetup.profile.ProfileManager


/*
 * This project can't be redistributed without
 * authorization of the developer
 *
 * Project @ Dainy
 * @author yek4h © 2024
 * Date: 25/07/2024
*/

class ProfileModule(
): IModule {
    override fun order(): Int {
        return 2
    }

    override fun load() {
        ProfileManager.start()
    }

    override fun unload() {
        ProfileManager.stop()
    }

    override fun reload() {
        //No implemented yet
    }

    override fun moduleName(): String {
        return "Profile"
    }
}