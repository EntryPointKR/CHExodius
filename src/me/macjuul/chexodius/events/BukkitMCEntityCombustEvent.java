package me.macjuul.chexodius.events;

import com.laytonsmith.abstraction.MCEntity;
import com.laytonsmith.abstraction.bukkit.entities.BukkitMCEntity;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityCombustEvent;

public class BukkitMCEntityCombustEvent implements MCEntityCombustEvent {
	EntityCombustEvent e;
	
	public BukkitMCEntityCombustEvent(Event e) {
		this.e = (EntityCombustEvent) e;
	}

	@Override
	public int getDuration() {
		return e.getDuration();
	}

	@Override
	public void setDuration(int d) {
		e.setDuration(d);
	}
	
	@Override
	public MCEntity getEntity() {
		return new BukkitMCEntity(e.getEntity());
	}
	
	@Override
	public Object _GetObject() {
		return this.e;
	}

}
