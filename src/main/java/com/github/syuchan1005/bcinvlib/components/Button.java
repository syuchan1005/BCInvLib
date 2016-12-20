package com.github.syuchan1005.bcinvlib.components;

import com.github.syuchan1005.bcinvlib.Component;
import org.bukkit.inventory.ItemStack;

/**
 * Created by syuchan on 2016/12/20.
 */
public class Button extends Component {

	public Button(ItemStack displayItem) {
		super(displayItem);
		setRightClickBiFunction((component, isShift) -> {
			onAction(component);
			return true;
		});
	}

	public void onAction(Component component) {}
}
