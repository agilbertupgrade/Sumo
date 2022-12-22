package org.stapledon.sumo.model;

import java.util.List;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(of = {"scheduleType", "cronExpression"})
public class SearchSchedule{
	private String cronExpression;
	private ParseableTimeRange parseableTimeRange;
	private Notification notification;
	private boolean muteErrorEmails;
	private String scheduleType;
	private String displayableTimeRange;
	private String timeZone;
	private Threshold threshold;
	private List<Object> parameters;
}