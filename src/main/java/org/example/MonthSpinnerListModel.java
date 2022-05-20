package org.example;

import javax.swing.*;
import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.util.*;

public class MonthSpinnerListModel extends SpinnerListModel {
    private String firstMonth;
    private String lastMonth;
    private YearSpinnerNumberModel yearModel;
    private Map<String, Integer> monthToMonthNumber;

    public MonthSpinnerListModel(YearSpinnerNumberModel yearModel) {
        if (yearModel == null) {
            throw new IllegalArgumentException();
        }

        this.yearModel = yearModel;

        List<String> months = getMonths();

        monthToMonthNumber = new HashMap<>();
        for (int i = 0; i < months.size(); i++) {
            monthToMonthNumber.put(months.get(i), i + 1);
        }

        this.setList(months);
        this.setValue(months.get(LocalDate.now().getMonthValue() - 1));
        this.firstMonth = months.get(0);
        this.lastMonth = months.get(months.size() - 1);
    }

    private List<String> getMonths() {
        List<String> months = new ArrayList<>(Arrays.asList(new DateFormatSymbols(Locale.US).getShortMonths()));
        int lastIndex = months.size() - 1;

        if (months.get(lastIndex) == null || months.get(lastIndex).length() <= 0) {
            months.remove(lastIndex);
        }

        return months;
    }

    public int getCurrentMonthNumber() {
        return monthToMonthNumber.get((String) getValue());
    }

    @Override
    public Object getNextValue() {
        Object value = super.getNextValue();

        if (value == null) {
            value = firstMonth;
            yearModel.setValue(yearModel.getNextValue());
        }

        return value;
    }

    @Override
    public Object getPreviousValue() {
        Object value = super.getPreviousValue();

        if (value == null) {
            value = lastMonth;
            yearModel.setValue(yearModel.getPreviousValue());
        }

        return value;
    }
}
