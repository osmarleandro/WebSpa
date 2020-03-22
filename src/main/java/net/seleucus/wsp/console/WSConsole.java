package net.seleucus.wsp.console;

import net.seleucus.wsp.client.WSClient;

public abstract class WSConsole {

	/**
	 * @deprecated Use {@link WSClient#getWsConsole()} instead
	 */
	public static final WSConsole getWsConsole() {
		return WSClient.getWsConsole();
	}

	public abstract String readLine(String string);

	public abstract char[] readPassword(String string);

	public abstract void println(String string);

}
