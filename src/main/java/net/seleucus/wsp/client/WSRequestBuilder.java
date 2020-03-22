package net.seleucus.wsp.client;

import net.seleucus.wsp.crypto.WebSpaEncoderRenamed;

public class WSRequestBuilder extends ExtracterSuperclass {
	
	private final String host;
	private final String knock;
	
	public WSRequestBuilder(final String host, CharSequence password, int action) {
	
		this.host = host;
		WebSpaEncoderRenamed wsEncoder = new WebSpaEncoderRenamed(password, action);
		this.knock = wsEncoder.getKnockRenamed();
		
	}
	
	public String getKnock() {
		
		StringBuilder urlBuilder = new StringBuilder();
		
		urlBuilder.append(host);
		if(!host.endsWith("/")) {
			urlBuilder.append('/');
		}
		urlBuilder.append(knock);
		urlBuilder.append('/');
		
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
