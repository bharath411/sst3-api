package com.rest.ops.pojo;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TestRailProject {

	
	  @JsonProperty("id")
	    private Integer id;
	    @JsonProperty("name")
	    private String name;
	    @JsonProperty("announcement")
	    private Object announcement;
	    @JsonProperty("show_announcement")
	    private Boolean showAnnouncement;
	    @JsonProperty("is_completed")
	    private Boolean isCompleted;
	    @JsonProperty("completed_on")
	    private Object completedOn;
	    @JsonProperty("suite_mode")
	    private Integer suiteMode;
	    @JsonProperty("url")
	    private String url;
	    @JsonIgnore
	    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	    @JsonProperty("id")
	    public Integer getId() {
	        return id;
	    }

	    @JsonProperty("id")
	    public void setId(Integer id) {
	        this.id = id;
	    }

	    @JsonProperty("name")
	    public String getName() {
	        return name;
	    }

	    @JsonProperty("name")
	    public void setName(String name) {
	        this.name = name;
	    }

	    @JsonProperty("announcement")
	    public Object getAnnouncement() {
	        return announcement;
	    }

	    @JsonProperty("announcement")
	    public void setAnnouncement(Object announcement) {
	        this.announcement = announcement;
	    }

	    @JsonProperty("show_announcement")
	    public Boolean getShowAnnouncement() {
	        return showAnnouncement;
	    }

	    @JsonProperty("show_announcement")
	    public void setShowAnnouncement(Boolean showAnnouncement) {
	        this.showAnnouncement = showAnnouncement;
	    }

	    @JsonProperty("is_completed")
	    public Boolean getIsCompleted() {
	        return isCompleted;
	    }

	    @JsonProperty("is_completed")
	    public void setIsCompleted(Boolean isCompleted) {
	        this.isCompleted = isCompleted;
	    }

	    @JsonProperty("completed_on")
	    public Object getCompletedOn() {
	        return completedOn;
	    }

	    @JsonProperty("completed_on")
	    public void setCompletedOn(Object completedOn) {
	        this.completedOn = completedOn;
	    }

	    @JsonProperty("suite_mode")
	    public Integer getSuiteMode() {
	        return suiteMode;
	    }

	    @JsonProperty("suite_mode")
	    public void setSuiteMode(Integer suiteMode) {
	        this.suiteMode = suiteMode;
	    }

	    @JsonProperty("url")
	    public String getUrl() {
	        return url;
	    }

	    @JsonProperty("url")
	    public void setUrl(String url) {
	        this.url = url;
	    }

	    @JsonAnyGetter
	    public Map<String, Object> getAdditionalProperties() {
	        return this.additionalProperties;
	    }

	    @JsonAnySetter
	    public void setAdditionalProperty(String name, Object value) {
	        this.additionalProperties.put(name, value);
	    }

	
}
