package com.techflow.openfda;

import java.io.IOException;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;

final class HttpTransportSpy extends MockHttpTransport
{
	private final String text;

	String method;

	String url;

	HttpTransportSpy(String text) {
		this.text = text;
	}

	@Override
	public LowLevelHttpRequest buildRequest(String method, String url) throws IOException
	{
		this.method = method;
		this.url = url;
		return new MockLowLevelHttpRequest() {
			@Override
			public LowLevelHttpResponse execute() throws IOException
			{
				final MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();
				// response.addHeader("custom_header", "value");
				response.setStatusCode(200);
				// response.setContentType(Json.CONTENT_TYPE);
				response.setContent(text);
				return response;
			}
		};
	}
}
