package wirebox.api;

import net.minecraft.util.ChunkCoordinates;

public interface IWirebox {

	ChunkCoordinates getLocation();
	
	//include a null in the Object[] to have it replaced with the side name, like monitor_touch events.
	void queueEventIfAttached(String eventName, Object[] event);
}
