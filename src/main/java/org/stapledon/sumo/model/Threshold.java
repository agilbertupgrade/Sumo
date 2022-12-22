package org.stapledon.sumo.model;

import lombok.Data;

@Data
public class Threshold{
	private int count;
	private Object thresholdType;
	private String operator;
}