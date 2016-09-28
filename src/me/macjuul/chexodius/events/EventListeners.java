package me.macjuul.chexodius.events;

import com.laytonsmith.abstraction.events.MCProjectileHitEvent;
import com.laytonsmith.annotations.event;
import com.laytonsmith.core.events.Driver;
import com.laytonsmith.core.events.EventUtils;
import me.macjuul.chexodius.LifeCycle;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityToggleGlideEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

@SuppressWarnings("deprecation")
public class EventListeners implements Listener {
	private static EventListeners listener;

	public static void register() {
		if(listener == null){
			listener = new EventListeners();
		}
		LifeCycle.chp.registerEvents(listener);
	}
	
	public static void unregister() {
		EntityToggleGlideEvent.getHandlerList().unregister(listener);
	}
	
	@event
	public void onHit(MCProjectileHitEvent event) {
		EventUtils.TriggerListener(Driver.EXTENSION, "projectile_hit_block", event);
	}
	
	@EventHandler
	public void onGlide(EntityToggleGlideEvent event) {
		if(event.getEntityType().equals(EntityType.PLAYER) && ((Player) event.getEntity()).isFlying()) {
			return;
		}
		ExodiusEvents.ExodiusEntityGlideEvent evt = new ExodiusEvents.ExodiusEntityGlideEvent(event);
		EventUtils.TriggerListener(Driver.EXTENSION, "entity_toggle_glide", evt);
	}
	
	@EventHandler
	public void onSwap(PlayerSwapHandItemsEvent event) {
		ExodiusEvents.ExodiusPlayerSwapHandItemsEvent evt = new ExodiusEvents.ExodiusPlayerSwapHandItemsEvent(event);
		EventUtils.TriggerListener(Driver.EXTENSION, "player_swap_hand", evt);
	}
}
