package com.iiitb.healthcare.model.dtos;

import java.util.*;
import java.util.stream.Collectors;

public class PieChartDto {
    private final List<Integer> data;

    private final List<String> labels;

    public PieChartDto(List<com.iiitb.healthcare.model.dtos.ChartDataDto> diagnosisCounts) {
        this.data = diagnosisCounts.stream().map(com.iiitb.healthcare.model.dtos.ChartDataDto::getCount).collect(Collectors.toList());
        this.labels = diagnosisCounts.stream().map(com.iiitb.healthcare.model.dtos.ChartDataDto::getLabel).collect(Collectors.toList());
    }
}