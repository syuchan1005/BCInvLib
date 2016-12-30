package com.github.syuchan1005.bcinvlib;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.plugin.Plugin;

/**
 * Created by syuchan on 2016/12/20.
 */
public abstract class Panel implements Listener, InventoryHolder {
	private final Plugin plugin;
	protected Component[] components;

	public Panel(Plugin plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, this.plugin);
	}

	public void show(Player player) {
		player.openInventory(this.getInventory());
	}

	public void hide(Player player) {
		player.closeInventory();
	}

	public void setComponent(int position, Component component) {
		component.setPanel(this);
		components[position] = component;
	}

	@EventHandler
	public void onClick(InventoryClickEvent event) {
		boolean cancel = false;
		Inventory inventory = event.getInventory();
		if (inventory.getHolder().equals(this)) {
			boolean isShift = false;
			Component component = components[event.getSlot()];
			if (component != null) {
				switch (event.getClick()) {
					case SHIFT_LEFT:
						isShift = true;
					case LEFT:
						cancel = component.onLeftClick(isShift);
						break;
					case SHIFT_RIGHT:
						isShift = true;
					case RIGHT:
						cancel = component.onRightClick(isShift);
						break;
					default:
						cancel = true;
						break;
				}
			}
		}
		event.setCancelled(cancel);
	}
}
