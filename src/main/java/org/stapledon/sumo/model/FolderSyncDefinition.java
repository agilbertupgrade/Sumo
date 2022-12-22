package org.stapledon.sumo.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"name", "description"})
public class FolderSyncDefinition {
    public String name;
    public String description;
    @Builder.Default
    public List<ChildrenItem> children = new ArrayList<>();
}
