package org.stapledon.sumo.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ScheduledItem {

    private String name;
    private String description;
    private String type;
    private String frequency;
    private String emails;
}
