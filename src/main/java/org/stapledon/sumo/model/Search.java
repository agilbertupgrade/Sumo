package org.stapledon.sumo.model;

import java.util.List;
import lombok.Data;

@Data
public class Search{
	private boolean byReceiptTime;
	private String viewName;
	private List<Object> queryParameters;
	private String parsingMode;
	private String queryText;
	private String defaultTimeRange;
	private String viewStartTime;
}