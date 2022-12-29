package org.stapledon.sumo;


import com.google.gson.Gson;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;
import org.stapledon.sumo.entity.ScheduledItem;
import org.stapledon.sumo.model.ChildrenItem;
import org.stapledon.sumo.model.FolderSyncDefinition;
import org.stapledon.sumo.model.WebhookPayload;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class ParseSumoBackup {

    private final String pclBackupJson;

    private final CSVPrinter destinationFile;

    private final Gson gson;


    public void parse() throws IOException {
        FolderSyncDefinition pclDefinition = gson.fromJson(pclBackupJson, FolderSyncDefinition.class);
        List<ScheduledItem> scheduledItem = new ArrayList<>();

        log.info("Parsing Results={}", pclDefinition);
        CollectionUtils.emptyIfNull(pclDefinition.getChildren())
                .forEach(item -> scheduledItem.addAll(findScheduledQueries(item)));

        log.info("Writing CSV to {}", destinationFile);
        destinationFile.printRecord("Name", "Description", "Frequency", "Type", "Emails");
        scheduledItem.forEach(item -> {
            //log.info("{} - {}", item.getType(), item.getName());
            try {
                destinationFile.printRecord(item.getName(), item.getDescription(), item.getFrequency(), item.getType(), item.getEmails());
            } catch (IOException e) {
                throw new InvalidOutputException(e);
            }
        });
        log.info("Webhook Analysis - Deduplicated By SearchName", pclDefinition);
        log.info("----------------", pclDefinition);
        scheduledItem
                .stream()
                .filter(p -> p.getType().equals("Webhook"))
                .filter(p -> p.getDeduplicatedBySearchName())
                .forEach(item ->
            log.info("{}", item.getName())
        );
        log.info("Webhook Analysis - Deduplicated By Custom Criteria", pclDefinition);
        log.info("----------------", pclDefinition);
        scheduledItem
                .stream()
                .filter(p -> p.getType().equals("Webhook"))
                .filter(p -> !p.getDeduplicatedBySearchName())
                .forEach(item ->
                        log.info("{} - {}", item.getName(), item.getAlias())
                );
        log.info("----------------", pclDefinition);
    }

    private List<ScheduledItem> findScheduledQueries(ChildrenItem item) {
        List<ScheduledItem> items = new ArrayList<>();
        if (item == null)
            return items;
        if (item.getSearchSchedule() != null) {
            var notification = item.getSearchSchedule().getNotification();
            if (notification.getTaskType().equals("WebhookSearchNotificationSyncDefinition")) {
                var payload = gson.fromJson(notification.getPayload().toString(), WebhookPayload.class);
                items.add(ScheduledItem
                        .builder()
                        .name(item.getName())
                        .description(item.getDescription())
                        .type("Webhook")
                        .frequency(item.getSearchSchedule().getCronExpression())
                        .deduplicatedBySearchName(Strings.isNotBlank(payload.getAlias()) && payload.getAlias().equals("{{SearchName}}"))
                        .alias(payload.getAlias())
                        .build());
            } else {
                log.warn("Email - {}", item.getName());
                items.add(ScheduledItem
                        .builder()
                        .name(item.getName())
                        .description(item.getDescription())
                        .type("Email")
                        .frequency(item.getSearchSchedule().getCronExpression())
                        .emails(StringUtils.joinWith(",", notification.getToList()))
                        .build());
            }
        }
        CollectionUtils.emptyIfNull(item.getChildren()).forEach(childrenItem -> items.addAll(findScheduledQueries(childrenItem)));
        return items;
    }

}
