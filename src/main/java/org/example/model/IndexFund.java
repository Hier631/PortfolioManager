package org.example.model;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.query.ObjectSelect;
import org.example.model.auto._IndexFund;
import org.example.utils.CayenneUtil;

public class IndexFund extends _IndexFund {

    private static final long serialVersionUID = 1L;

    public IndexFundDto toDto()
    {
        return new IndexFundDto(this.getIsin(), this.getName());
    }

    public void copyDataFromDto(IndexFundDto indexFundDto) {
        this.setIsin(indexFundDto.getIsin());
        this.setName(indexFundDto.getName());
    }
}
