package org.example.model;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.apache.cayenne.query.ObjectSelect;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class IndexFundDaoTest {

    private ServerRuntime cayenneRuntime;
    private ObjectContext context;

    @BeforeClass
    public void setup() {
        cayenneRuntime = ServerRuntime.builder()
                .addConfig("cayenne-project.xml")
                .addConfig("cayenne-project-test.xml")
                .build();

        context = cayenneRuntime.newContext();
    }

    @AfterClass
    public void tearDown() {
        cayenneRuntime.shutdown();
    }

    @AfterMethod
    public void cleanDatabase() {
        context.deleteObjects(
                ObjectSelect.query(IndexFund.class).select(context)
        );

        context.commitChanges();
    }

    @Test
    public void givenIndexFundId_whenGetById_thenReturnIndexFundDtoWithSameId() {
        IndexFundDao indexFundDao = new IndexFundDao(context);
        indexFundDao.save(new IndexFundDto("TestISIN", "TestName"));

        int indexFundId = indexFundDao.getAll().get(0).getId();

        IndexFundDto indexFundDto = indexFundDao.getById(indexFundId);

        Assert.assertEquals(indexFundId, indexFundDto.getId());
    }
}
