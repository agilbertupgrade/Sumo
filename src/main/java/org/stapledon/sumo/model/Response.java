package org.stapledon.sumo.model;

import java.util.List;
import lombok.Data;

@Data
public class Response{
	private Layout layout;
	private TopologyLabelMap topologyLabelMap;
	private List<Object> variables;
	private int refreshInterval;
	private List<PanelsItem> panels;
	private String name;
	private String description;
	private String theme;
	private String type;
	private String title;
	private List<Object> coloringRules;
	private TimeRange timeRange;
}