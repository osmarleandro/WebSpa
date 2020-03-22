package net.seleucus.wsp.daemon;

import net.seleucus.wsp.config.WSConfiguration;
import net.seleucus.wsp.db.WSGestalt;
import net.seleucus.wsp.main.WebSpa;

public class WSDaemonStop extends WSGestalt {

	public WSDaemonStop(WebSpa myWebSpa) {
		super(myWebSpa);
	}

	public WSConfiguration getWSConfiguration() {
		return myConfiguration;
	}
}
