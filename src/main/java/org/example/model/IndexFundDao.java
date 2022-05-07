package org.example.model;

import org.apache.cayenne.Cayenne;
import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.query.ObjectSelect;
import org.example.utils.CayenneUtil;

import java.util.ArrayList;
import java.util.List;

public class IndexFundDao implements Dao<IndexFundDto, Integer> {

    private final ObjectContext context = CayenneUtil.getContext();

    @Override
    public IndexFundDto getById(Integer id) {

        IndexFundDto indexFundDto = null;

        if (id != null) {
            IndexFund indexFund = Cayenne.objectForPK(context, IndexFund.class, id);

            if (indexFund != null) {
                indexFundDto = indexFund.toDto();
            }
        }

        return indexFundDto;
    }

    @Override
    public void deleteById(Integer id) {
        if (id != null) {
            IndexFund indexFund = Cayenne.objectForPK(context, IndexFund.class, id);
            if (indexFund != null) {
                context.deleteObject(indexFund);
                context.commitChanges();
            }
        }
    }

    @Override
    public List<IndexFundDto> getAll() {
        List<IndexFundDto> indexFundDtoList = null;

        List<IndexFund> indexFunds = ObjectSelect
                .query(IndexFund.class)
                .select(context);

        if (indexFunds != null && indexFunds.size() > 0)
        {
            indexFundDtoList = new ArrayList<>();
            for (IndexFund indexFund : indexFunds) {
                indexFundDtoList.add(indexFund.toDto());
            }
        }

        return indexFundDtoList;
    }

    @Override
    public void save(IndexFundDto indexFundDto) {
        if (indexFundDto != null
                && indexFundDto.getIsin() != null
                && getIndexFundByIsin(indexFundDto.getIsin()) == null) {

            IndexFund indexFund = context.newObject(IndexFund.class);
            indexFund.copyDataFromDto(indexFundDto);
            context.commitChanges();
        }
    }

    @Override
    public void update(IndexFundDto indexFundDto) {
        if (indexFundDto != null
                && indexFundDto.getIsin() != null
                && indexFundDto.getId() != null) {

            IndexFund indexFund = Cayenne.objectForPK(context, IndexFund.class, indexFundDto.getId());

            if (indexFundDto.getIsin().equals(indexFund.getIsin())
                    || getIndexFundByIsin(indexFundDto.getIsin()) == null) {

                indexFund.copyDataFromDto(indexFundDto);
                context.commitChanges();
            }
        }
    }

    @Override
    public void delete(IndexFundDto indexFundDto) {
        if (indexFundDto != null && indexFundDto.getIsin() != null) {

            IndexFund indexFund = getIndexFundByIsin(indexFundDto.getIsin());

            if (indexFund != null)
            {
                context.deleteObject(indexFund);
                context.commitChanges();
            }
        }
    }

    private IndexFund getIndexFundByIsin(String isin) {
        return ObjectSelect.query(IndexFund.class)
                .where(IndexFund.ISIN.eq(isin))
                .selectOne(context);
    }
}
