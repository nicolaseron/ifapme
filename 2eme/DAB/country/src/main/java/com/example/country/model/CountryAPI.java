package com.example.country.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryAPI {

    private Name name;
    private List<String> tld;
    private String cca2;
    private String cca3;
    private boolean independent;
    private String status;
    private boolean unMember;
    private Map<String, Currency> currencies;
    private Idd idd;
    private List<String> capital;
    private String region;
    private String subregion;
    private List<String> continents;
    private Flags flags;
    private Map<String, String> languages;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Name {
        private String common;
        private String official;
        private Map<String, LocalizedName> nativeName;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LocalizedName {
        private String official;
        private String common;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Currency {
        private String name;
        private String symbol;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Idd {
        private String root;
        private List<String> suffixes;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Flags {
        private String png;
        private String svg;
    }
}
