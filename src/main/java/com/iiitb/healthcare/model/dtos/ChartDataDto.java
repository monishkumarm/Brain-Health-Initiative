package com.iiitb.healthcare.model.dtos;

public class ChartDataDto {
    private final String label;

    private final Integer count;

    public ChartDataDto(String diagnosisInfo, Long count) {
        this.label = diagnosisInfo;
        this.count = Math.toIntExact(count);
    }

    public String getLabel() {
        return label;
    }

    public Integer getCount() {
        return count;
    }
}
