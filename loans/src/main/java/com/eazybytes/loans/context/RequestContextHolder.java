package com.drspeedracer.loans.context;

import org.springframework.util.Assert;

public class RequestContextHolder {

	private static final ThreadLocal<RequestContext> requestContext = new ThreadLocal<RequestContext>();

	public static final RequestContext getContext() {
		RequestContext context = requestContext.get();

		if (context == null) {
			context = createEmptyContext();
			requestContext.set(context);

		}
		return requestContext.get();
	}

	public static final void setContext(RequestContext context) {
		requestContext.set(context);
	}

	public static final RequestContext createEmptyContext() {
		return new RequestContext();
	}

}
