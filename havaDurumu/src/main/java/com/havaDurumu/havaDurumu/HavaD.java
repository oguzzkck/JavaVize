package com.havaDurumu.havaDurumu;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HavaD {

    private String name;
    public Main main;
    @JsonProperty("weather")
    public List<ozellik> property;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public List<ozellik> getProperty() {
        return property;
    }

    public void setProperty(List<ozellik> property) {
        this.property = property;
    }

    @Override
    public String toString() {
        return "Wethr [name=" + name + ", main=" + main + ", property="
                + property + "]";
    }
}