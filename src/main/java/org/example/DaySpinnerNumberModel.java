package org.example;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.time.LocalDate;
import java.time.YearMonth;

public class DaySpinnerNumberModel extends SpinnerNumberModel implements ChangeListener {

    private MonthSpinnerListModel monthModel;
    private YearSpinnerNumberModel yearModel;
    private int lengthOfMonth;


    public DaySpinnerNumberModel(MonthSpinnerListModel monthModel, YearSpinnerNumberModel yearModel) {
        if (monthModel == null) {
            throw new IllegalArgumentException();
        }

        if (yearModel == null) {
            throw new IllegalArgumentException();
        }

        this.monthModel = monthModel;
        this.yearModel = yearModel;

        updateLengthOfMonth();

        this.monthModel.addChangeListener(this);
        this.yearModel.addChangeListener(this);

        this.setValue(LocalDate.now().getDayOfMonth());
        this.setMinimum(1);
        this.setMaximum(lengthOfMonth);
        this.setStepSize(1);
    }

    private void updateLengthOfMonth() {
        this.lengthOfMonth = YearMonth.of(
                yearModel.getNumber().intValue(), monthModel.getCurrentMonthNumber()
        ).lengthOfMonth();
    }

    @Override
    public Object getNextValue() {
        Object value = super.getNextValue();

        if (value == null) {
            value = 1;
            monthModel.setValue(monthModel.getNextValue());
        }

        return value;
    }

    @Override
    public Object getPreviousValue() {
        Object value = super.getPreviousValue();

        if (value == null) {
            monthModel.setValue(monthModel.getPreviousValue());
            updateLengthOfMonth();
            value = lengthOfMonth;
        }

        return value;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == this.monthModel || e.getSource() == this.yearModel) {
            updateLengthOfMonth();
            if (this.getNumber().intValue() > this.lengthOfMonth) {
                this.setValue(lengthOfMonth);
            }
            this.setMaximum(lengthOfMonth);
        }
    }
}
