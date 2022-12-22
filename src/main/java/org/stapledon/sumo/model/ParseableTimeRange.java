package org.stapledon.sumo.model;

import lombok.Data;

@Data
public class ParseableTimeRange{
	private From from;
	private Object to;
	private String type;
}