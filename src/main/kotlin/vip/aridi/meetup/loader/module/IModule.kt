package vip.aridi.meetup.loader.module


/*
 * This project can't be redistributed without
 * authorization of the developer
 *
 * Project @ Dainy
 * @author yek4h © 2024
 * Date: 23/07/2024
*/

interface IModule {

    fun order(): Int

    fun load()

    fun unload()

    fun reload()

    fun moduleName() : String

}