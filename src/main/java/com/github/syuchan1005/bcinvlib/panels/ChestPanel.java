package com.github.syuchan1005.bcinvlib.panels;

import com.github.syuchan1005.bcinvlib.Component;
import com.github.syuchan1005.bcinvlib.Panel;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.Arrays;

/**
 * Created by syuchan on 2016/12/20.
 */
public class ChestPanel extends Panel {
	private final int Y_MAX;
	private ItemStack defaultSlot;

	public ChestPanel(Plugin plugin, int y_max, ItemStack defaultSlot) {
		super(plugin);
		if (1 > y_max && y_max > 6) {
			throw new IllegalArgumentException("size range 1-9");
		}
		this.defaultSlot = defaultSlot;
		Y_MAX = y_max;
		components = new Component[9 * (Y_MAX)];
	}

	@Deprecated
	public void setComponent(int x, int y, Component component) {
		setComponent(x + (y * 9), component);
	}

	@Override
	public Inventory getInventory() {
		Inventory inventory = Bukkit.createInventory(this, components.length);
		inventory.setContents(Arrays.stream(components)
				.map(c -> (c == null) ? defaultSlot : c.getDisplayItem())
				.toArray(ItemStack[]::new)
		);
		return inventory;
	}
}
