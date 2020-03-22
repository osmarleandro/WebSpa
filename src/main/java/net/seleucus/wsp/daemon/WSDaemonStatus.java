package net.seleucus.wsp.daemon;

import net.seleucus.wsp.config.WSConfiguration;
import net.seleucus.wsp.db.WSGestalt;
import net.seleucus.wsp.main.WebSpa;

public class WSDaemonStatus extends WSGestalt {

	protected WSConfiguration myConfiguration;

	public WSDaemonStatus(WebSpa myWebSpa) {
		super(myWebSpa);
	}

	public WSConfiguration getWSConfiguration() {
		return myConfiguration;
	}
}
