package org.example.model;

public class IndexFundDto {
    private String isin;
    private String name;

    public IndexFundDto(String isin, String name) {
        this.isin = isin;
        this.name = name;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
