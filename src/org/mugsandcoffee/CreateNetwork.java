package org.mugsandcoffee;

import org.matsim.api.core.v01.Scenario;
import org.matsim.api.core.v01.network.Network;
import org.matsim.core.api.experimental.network.NetworkWriter;
import org.matsim.core.config.Config;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.network.algorithms.NetworkCleaner;
import org.matsim.core.scenario.ScenarioUtils;
import org.matsim.core.utils.geometry.CoordinateTransformation;
import org.matsim.core.utils.geometry.transformations.TransformationFactory;
import org.matsim.core.utils.io.OsmNetworkReader;

public class CreateNetwork {
	
	private String mOSM_path;
	private String mOutputNetwork;
	
	public CreateNetwork() {
		
		this.mOSM_path = "data/map.osm";
		this.mOutputNetwork = "input/network.xml";
		
	}
	
	public void generateNetwork() {
		
	      String osm = this.mOSM_path;
	      Config config = ConfigUtils.createConfig();
	      Scenario sc = ScenarioUtils.createScenario(config);
	      Network net = sc.getNetwork();
	      CoordinateTransformation ct = 
	      TransformationFactory.getCoordinateTransformation(
	      TransformationFactory.WGS84, TransformationFactory.WGS84_TM);
	      OsmNetworkReader onr = new OsmNetworkReader(net,ct);
	      onr.parse(osm); 
	      new NetworkCleaner().run(net);
	      new NetworkWriter(net).write(this.mOutputNetwork);
	
	}

}
