package com.example.anton_stock_feed.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("profile1")
public class JavaConfiguration {
    private String DAO;
    private String ProfileService;
    private String JsonSerialize;
    private String APIService;

    public String getDAO() {
        return DAO;
    }

    public void setDAO(String DAO) {
        this.DAO = DAO;
    }

    public String getProfileService() {
        return ProfileService;
    }

    public void setProfileService(String profileService) {
        ProfileService = profileService;
    }

    public String getJsonSerialize() {
        return JsonSerialize;
    }

    public void setJsonSerialize(String jsonSerialize) {
        JsonSerialize = jsonSerialize;
    }

    public String getAPIService() {
        return APIService;
    }

    public void setAPIService(String APIService) {
        this.APIService = APIService;
    }
}
