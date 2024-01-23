package com.sujeet.project.springboot.model;

public class Flight {
    private Integer fId;

    private String fSource;
    private String fDestination;
    private String fName;

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public String getfSource() {
        return fSource;
    }

    public void setfSource(String fSource) {
        this.fSource = fSource;
    }

    public String getfDestination() {
        return fDestination;
    }

    public void setfDestination(String fDestination) {
        this.fDestination = fDestination;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }
}
