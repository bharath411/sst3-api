package com.rest.ops.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
public class Product {

@JsonProperty("category")
private String category;
@JsonProperty("description")
private String description;
@JsonProperty("discontinued")
private Integer discontinued;
@JsonProperty("id")
private Integer id;
@JsonProperty("listPrice")
private Integer listPrice;
@JsonProperty("minimumReorderQuantity")
private Integer minimumReorderQuantity;
@JsonProperty("productCode")
private String productCode;
@JsonProperty("productName")
private String productName;
@JsonProperty("quantityPerUnit")
private String quantityPerUnit;
@JsonProperty("reorderLevel")
private Integer reorderLevel;
@JsonProperty("standardCost")
private Integer standardCost;
@JsonProperty("targetLevel")
private Integer targetLevel;

@JsonProperty("category")
public String getCategory() {
return category;
}

@JsonProperty("category")
public void setCategory(String category) {
this.category = category;
}

@JsonProperty("description")
public String getDescription() {
return description;
}

@JsonProperty("description")
public void setDescription(String description) {
this.description = description;
}

@JsonProperty("discontinued")
public Integer getDiscontinued() {
return discontinued;
}

@JsonProperty("discontinued")
public void setDiscontinued(Integer discontinued) {
this.discontinued = discontinued;
}

@JsonProperty("id")
public Integer getId() {
return id;
}

@JsonProperty("id")
public void setId(Integer id) {
this.id = id;
}

@JsonProperty("listPrice")
public Integer getListPrice() {
return listPrice;
}

@JsonProperty("listPrice")
public void setListPrice(Integer listPrice) {
this.listPrice = listPrice;
}

@JsonProperty("minimumReorderQuantity")
public Integer getMinimumReorderQuantity() {
return minimumReorderQuantity;
}

@JsonProperty("minimumReorderQuantity")
public void setMinimumReorderQuantity(Integer minimumReorderQuantity) {
this.minimumReorderQuantity = minimumReorderQuantity;
}

@JsonProperty("productCode")
public String getProductCode() {
return productCode;
}

@JsonProperty("productCode")
public void setProductCode(String productCode) {
this.productCode = productCode;
}

@JsonProperty("productName")
public String getProductName() {
return productName;
}

@JsonProperty("productName")
public void setProductName(String productName) {
this.productName = productName;
}

@JsonProperty("quantityPerUnit")
public String getQuantityPerUnit() {
return quantityPerUnit;
}

@JsonProperty("quantityPerUnit")
public void setQuantityPerUnit(String quantityPerUnit) {
this.quantityPerUnit = quantityPerUnit;
}

@JsonProperty("reorderLevel")
public Integer getReorderLevel() {
return reorderLevel;
}

@JsonProperty("reorderLevel")
public void setReorderLevel(Integer reorderLevel) {
this.reorderLevel = reorderLevel;
}

@JsonProperty("standardCost")
public Integer getStandardCost() {
return standardCost;
}

@JsonProperty("standardCost")
public void setStandardCost(Integer standardCost) {
this.standardCost = standardCost;
}

@JsonProperty("targetLevel")
public Integer getTargetLevel() {
return targetLevel;
}

@JsonProperty("targetLevel")
public void setTargetLevel(Integer targetLevel) {
this.targetLevel = targetLevel;
}

}