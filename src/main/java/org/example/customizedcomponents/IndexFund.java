package org.example.customizedcomponents;

public class IndexFund {
    private String isin;
    private String name;

    public IndexFund(String isin, String name) {
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
