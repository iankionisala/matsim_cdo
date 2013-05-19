package org.mugsandcoffee;

import org.matsim.core.config.Config;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.controler.Controler;

public class CreateOutput {
	
	private String mConfig_path;
	
	public CreateOutput() {
		
		this.mConfig_path = "input/config.xml";
	}
	
	public void generateOutput() {
		
		Config config = ConfigUtils.loadConfig(this.mConfig_path);
		Controler controler = new Controler(config);
		
		controler.run();
		
	}

}
