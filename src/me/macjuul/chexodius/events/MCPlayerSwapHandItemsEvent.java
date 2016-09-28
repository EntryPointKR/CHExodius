package me.macjuul.chexodius.events;

import com.laytonsmith.core.events.BindableEvent;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Created by deide on 2016-09-24.
 */
public interface MCPlayerSwapHandItemsEvent extends BindableEvent {
    Object _GetObject();
    ItemStack getMainHandItem();
    ItemStack getOffHandItem();
    void setMainHandItem(ItemStack mainHandItem);
    void setOffHandItem(ItemStack mainHandItem);
    Player getPlayer();
}
