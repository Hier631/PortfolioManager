package org.example.model;

public class IndexFundDto {
    private Integer id;
    private String isin;
    private String name;

    public IndexFundDto(Integer id, String isin, String name) {
        this.id = id;
        this.isin = isin;
        this.name = name;
    }

    public IndexFundDto(String isin, String name) {
        this(null, isin, name);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
