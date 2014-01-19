package wirebox.api;

import java.util.HashMap;

public interface IModule {
	
	//internal redstone outputs that other modules/panels can use as inputs.
	HashMap getRedstoneOutputStates();
		
	//internal analog (0-15) redstone outputs for other modules/panels to use.
	HashMap getAnalogRedstoneOutputStates();
	
	//internal inputs that this panel accepts from other modules/panels.
	String[] getRedstoneInputNames();

}
