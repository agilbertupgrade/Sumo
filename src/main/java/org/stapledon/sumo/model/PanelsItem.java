package org.stapledon.sumo.model;

import java.util.List;

import lombok.Data;

@Data
public class PanelsItem{
	private List<Object> linkedDashboards;
	private boolean keepVisualSettingsConsistentWithParent;
	private String visualSettings;
	private String description;
	private Object id;
	private String title;
	private String panelType;
	private List<QueriesItem> queries;
	private Object coloringRules;
	private String key;
	private TimeRange timeRange;
}