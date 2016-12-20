package com.github.syuchan1005.bcinvlib.panels;

import com.github.syuchan1005.bcinvlib.Component;
import com.github.syuchan1005.bcinvlib.Panel;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.Arrays;

/**
 * Created by syuchan on 2016/12/20.
 */
public class ChestPanel extends Panel {
	private final int Y_MAX;

	public ChestPanel(Plugin plugin, int y_max) {
		super(plugin);
		if (y_max > 9) {
			throw new IllegalArgumentException("size is max 9!");
		}
		Y_MAX = y_max;
		components = new Component[9 * (Y_MAX + 1)];
	}

	@Deprecated
	public void setComponent(int x, int y, Component component) {
		setComponent(x + (y * 9), component);
	}

	public void setComponent(int position, Component component) {
		components[position] = component;
	}

	@Override
	public Inventory getInventory() {
		Inventory inventory = Bukkit.createInventory(this, components.length);
		inventory.setContents(Arrays.stream(components)
				.map(Component::getDisplayItem)
				.toArray(ItemStack[]::new)
		);
		return inventory;
	}
}
