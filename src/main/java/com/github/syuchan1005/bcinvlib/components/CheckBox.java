package com.github.syuchan1005.bcinvlib.components;

import com.github.syuchan1005.bcinvlib.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/**
 * Created by syuchan on 2016/12/20.
 */
public class CheckBox extends Component {
	private static ItemStack onButton;
	private static ItemStack offButton;
	static {
		onButton = new ItemStack(Material.STAINED_GLASS_PANE);
		onButton.setDurability((short)5);
		offButton = new ItemStack(Material.STAINED_GLASS_PANE);
		offButton.setDurability((short)14);
	}

	public CheckBox() {
		super(offButton);
		setRightClickBiFunction((component, isShift) -> {
			if (component.getDisplayItem().equals(onButton)) {
				component.setDisplayItem(offButton);
			} else {
				component.setDisplayItem(onButton);
			}
			return true;
		});
	}

	public boolean isSelect() {
		return onButton.equals(getDisplayItem());
	}
}
