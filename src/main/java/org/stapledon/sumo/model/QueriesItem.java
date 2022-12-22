package org.stapledon.sumo.model;

import lombok.Data;

@Data
public class QueriesItem{
	private String queryKey;
	private Object metricsQueryMode;
	private boolean jsonMemberTransient;
	private Object outputCardinalityLimit;
	private Object metricsQueryData;
	private Object spansQueryData;
	private String timeSource;
	private String queryString;
	private Object tracesQueryData;
	private String parseMode;
	private String queryType;
}