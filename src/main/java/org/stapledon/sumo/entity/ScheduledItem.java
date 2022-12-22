package org.stapledon.sumo.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ScheduledItem {

    public String name;
    public String description;
    public String type;
    public String frequency;
    public String emails;
}
