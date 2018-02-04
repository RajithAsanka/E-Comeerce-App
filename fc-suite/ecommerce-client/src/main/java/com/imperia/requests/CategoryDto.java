package com.imperia.requests;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * CategoryDto Table
 * Created by Kithmal on 12/11/17.
 */
public class CategoryDto {

    @JsonProperty(value = "id")
    private Long id;
    @JsonProperty(value = "mainCategory")
    private String mainCategory;
    @JsonProperty(value = "categoryName")
    private String categoryName;
    @JsonProperty(value = "description")
    private String description;
    @JsonProperty(value = "status")
    private String status;


    public String getMainCategory() {
        return mainCategory;
    }

    public void setMainCategory(String mainCategory) {
        this.mainCategory = mainCategory;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
