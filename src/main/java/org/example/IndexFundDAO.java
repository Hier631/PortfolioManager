package org.example;

import org.example.utils.CSV;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class IndexFundDAO implements DAO<IndexFund, String> {

    public static final String INDEX_FUNDS_FILE = "IndexFunds.csv";

    public IndexFundDAO() {
        File file = new File(INDEX_FUNDS_FILE);
        if (!file.exists()) {
            try (OutputStreamWriter writer = new OutputStreamWriter(
                    Files.newOutputStream(
                            Paths.get(INDEX_FUNDS_FILE),
                            StandardOpenOption.CREATE_NEW), StandardCharsets.UTF_8)) {

                writer.write(CSV.encodeRegister(Arrays.asList("ISIN", "Name")));
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public IndexFund get(String id) {

        IndexFund indexFund = null;

        String text = "";
        String encodedIsin = CSV.encode(id);
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        Files.newInputStream(
                                Paths.get(INDEX_FUNDS_FILE)), StandardCharsets.UTF_8))) {
            while ((text = br.readLine()) != null && !text.startsWith(encodedIsin));
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

        if (text != null && text.startsWith(encodedIsin)) {
            List<String> indexFundData = CSV.decodeRegister(text);
            indexFund = new IndexFund(indexFundData.get(0), indexFundData.get(1));
        }

        return indexFund;
    }

    @Override
    public List<IndexFund> getAll() {
        return null;
    }

    @Override
    public void save(IndexFund indexFund) {
        if (!isIdRegistered(indexFund.getIsin())) {
            try (OutputStreamWriter writer = new OutputStreamWriter(
                    Files.newOutputStream(
                            Paths.get(INDEX_FUNDS_FILE),
                            StandardOpenOption.APPEND), StandardCharsets.UTF_8)) {

                writer.write(CSV.encodeRegister(Arrays.asList(indexFund.getIsin(), indexFund.getName())));
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(IndexFund indexFund) {

    }

    @Override
    public void delete(IndexFund indexFund) {

    }

    private boolean isIdRegistered(String isin) {

        String text = "";
        String encodedIsin = CSV.encode(isin);
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        Files.newInputStream(
                                Paths.get(INDEX_FUNDS_FILE)), StandardCharsets.UTF_8))) {
            while ((text = br.readLine()) != null && !text.startsWith(encodedIsin));
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

        return text != null;
    }
}
