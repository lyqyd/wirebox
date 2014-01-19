package wirebox.api;

import java.util.Map;

public interface PanelRegistry {

	void registerPanel(IPanel panel);
	
	Map<String, IPanel> getPanel();
	
	IPanel getPanel(String uid);
	
}
