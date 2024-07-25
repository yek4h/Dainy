package vip.aridi.meetup.scenario.sub

import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.inventory.ItemStack
import vip.aridi.meetup.scenario.Scenario


/*
 * This project can't be redistributed without
 * authorization of the developer
 *
 * Project @ Dainy
 * @author yek4h © 2024
 * Date: 25/07/2024
*/

class NoFallScenario(
): Scenario(
    name = "No Fall Scenario",
    icon = ItemStack(Material.CHAINMAIL_BOOTS),
    description = "You can't take fall damage with this scenario!"
) {

    override fun onEnable() {
        super.onEnable()

        subscribe(EntityDamageEvent::class) { event ->
            if (event.entity is Player && event.cause == EntityDamageEvent.DamageCause.FALL) {
                event.isCancelled = true
            }
        }
    }
}