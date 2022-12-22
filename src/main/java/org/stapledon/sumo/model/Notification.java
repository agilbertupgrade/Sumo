package org.stapledon.sumo.model;

import java.util.List;
import lombok.Data;

@Data
public class Notification{
	private String taskType;
	private String webhookId;
	private Object payload;
	private boolean itemizeAlerts;
	private int maxItemizedAlerts;
	private boolean includeHistogram;
	private boolean includeQuery;
	private boolean includeCsvAttachment;
	private boolean includeResultSet;
	private List<String> toList;
	private String subjectTemplate;
}