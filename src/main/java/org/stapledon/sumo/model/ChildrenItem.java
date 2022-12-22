package org.stapledon.sumo.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChildrenItem {
	@Builder.Default
	private List<ChildrenItem> children = new ArrayList<>();
	private String name;
	private String description;
	private String type;
	private SearchSchedule searchSchedule;
	private Search search;
}