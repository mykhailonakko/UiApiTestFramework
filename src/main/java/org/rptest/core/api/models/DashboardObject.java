package org.rptest.core.api.models;

import lombok.Data;

import java.util.List;

@Data
public class DashboardObject {
    List<Content> content;
    @Data
    public static class Content {
        private final Integer id;
        private final String name;
        private final String owner;
        private final Boolean share;
    }
}
