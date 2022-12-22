package org.stapledon.sumo.model;

import lombok.Data;

@Data
public class TimeRange{
	private From from;
	private Object to;
	private String type;
}