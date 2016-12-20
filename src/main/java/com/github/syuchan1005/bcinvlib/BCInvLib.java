package com.github.syuchan1005.bcinvlib;

import com.github.syuchan1005.bcinvlib.components.Button;
import com.github.syuchan1005.bcinvlib.panels.ChestPanel;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class BCInvLib extends JavaPlugin implements Listener {
	private static BCInvLib instance;

	@Override
	public void onEnable() {
		instance = this;
		this.getServer().getPluginManager().registerEvents(this, this);
	}

	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		if (event.getAction() == Action.RIGHT_CLICK_AIR) {
			ChestPanel chestPanel = new ChestPanel(instance, 9, 1);
			chestPanel.setComponent(0, 0, new Button(new ItemStack(Material.STAINED_GLASS_PANE)));
			chestPanel.show(event.getPlayer());
		}
	}
}
