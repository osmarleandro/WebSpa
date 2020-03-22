package net.seleucus.wsp.client;

import net.seleucus.wsp.crypto.WebSpaEncoder;

public class WSRequestBuilder extends ExtractedSuperclass {
	
	private final String host;
	private final String knock;
	
	public WSRequestBuilder(final String host, CharSequence password, int action) {
	
		this.host = host;
		WebSpaEncoder wsEncoder = new WebSpaEncoder(password, action);
		this.knock = wsEncoder.getKnock();
		
	}
	
	public String getKnock() {
		
		StringBuilder urlBuilder = new StringBuilder();

		extracted(urlBuilder);

		return urlBuilder.toString();
		
	}

	private void extracted(StringBuilder urlBuilder) {
		urlBuilder.append(host);
		if(!host.endsWith("/")) {
			urlBuilder.append('/');
		}
		urlBuilder.append(knock);
		urlBuilder.append('/');
	}

}
