package org.stapledon.sumo.model;

import java.util.List;

import lombok.Data;

@Data
public class Layout{
	private List<LayoutStructuresItem> layoutStructures;
	private String layoutType;
}