package com.github.syuchan1005.bcinvlib;

import org.bukkit.inventory.ItemStack;

import java.util.function.BiFunction;

/**
 * Created by syuchan on 2016/12/20.
 */
public class Component {
	private Panel panel;
	private ItemStack displayItem;
	private BiFunction<Component, Boolean, Boolean> rightClickBiFunction;
	private BiFunction<Component, Boolean, Boolean> leftClickBiFunction;

	protected Component(ItemStack displayItem) {
		this.displayItem = displayItem;
	}

	public Panel getPanel() {
		return panel;
	}

	public void setPanel(Panel panel) {
		this.panel = panel;
	}

	public ItemStack getDisplayItem() {
		return displayItem;
	}

	public void setDisplayItem(ItemStack displayItem) {
		this.displayItem = displayItem;
	}
	
	public boolean onRightClick(boolean isShift) {
		if (rightClickBiFunction != null) return rightClickBiFunction.apply(this, isShift);
		return true;
	}

	public BiFunction<Component, Boolean, Boolean> getRightClickBiFunction() {
		return rightClickBiFunction;
	}

	public void setRightClickBiFunction(BiFunction<Component, Boolean, Boolean> rightClickBiFunction) {
		this.rightClickBiFunction = rightClickBiFunction;
	}

	public boolean onLeftClick(boolean isShift) {
		if (leftClickBiFunction != null) return leftClickBiFunction.apply(this, isShift);
		return true;
	}

	public BiFunction<Component, Boolean, Boolean> getLeftClickBiFunction() {
		return leftClickBiFunction;
	}

	public void setLeftClickBiFunction(BiFunction<Component, Boolean, Boolean> leftClickBiFunction) {
		this.leftClickBiFunction = leftClickBiFunction;
	}
}
