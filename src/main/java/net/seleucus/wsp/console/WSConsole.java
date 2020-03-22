package net.seleucus.wsp.console;

public abstract class WSConsole {

	public abstract String readLine(String string);

	public abstract char[] readPassword(String string);

	public abstract void println(String string);

}
