package me.macjuul.chexodius.events;

import com.laytonsmith.core.events.BindableEvent;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

/**
 * Created by deide on 2016-09-24.
 */
public interface MCEntityToggleGlideEvent extends BindableEvent {
    Object _GetObject();
    boolean isGliding();
    Entity getEntity();
    EntityType getEntityType();
}
