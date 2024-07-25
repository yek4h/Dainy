package vip.aridi.meetup.loader

import vip.aridi.meetup.loader.module.IModule


/*
 * This project can't be redistributed without
 * authorization of the developer
 *
 * Project @ Dainy
 * @author yek4h © 2024
 * Date: 23/07/2024
*/

interface KLoader {

    fun startup()

    fun enabled()

    fun disabled()

    fun loadModules()

    fun unloadModules()

    fun addModules(iModule: IModule)

    fun reloadModule(moduleName: Int)

}