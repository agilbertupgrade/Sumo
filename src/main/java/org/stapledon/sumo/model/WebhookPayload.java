package org.stapledon.sumo.model;

import lombok.Data;

@Data
public class WebhookPayload {
	private String searchQueryUrl;
	private String numRawResults;
	private String fireTime;
	private String searchName;
	private String searchQuery;
	private String aggregateResultsJson;
	private String alias;
	private String searchDescription;
	private String rawResultsJson;
	private String priority;
	private String timeRange;
}