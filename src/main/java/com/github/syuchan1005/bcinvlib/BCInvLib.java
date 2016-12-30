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
		if (event.getAction() == Action.PHYSICAL) {
			ChestPanel chestPanel = new ChestPanel(instance, 1, new ItemStack(Material.STAINED_GLASS_PANE));
			ItemStack okItem = new ItemStack(Material.STAINED_GLASS_PANE);
			okItem.setDurability((short) 5);
			chestPanel.setComponent(0, new Button(okItem));
			ItemStack ngItem = new ItemStack(Material.STAINED_GLASS_PANE);
			ngItem.setDurability((short) 14);
			chestPanel.setComponent(8, new Button(ngItem));
			chestPanel.show(event.getPlayer());
		}
	}
}
