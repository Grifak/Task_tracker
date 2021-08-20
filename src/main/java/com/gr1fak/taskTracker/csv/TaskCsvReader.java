package com.gr1fak.taskTracker.csv;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.gr1fak.taskTracker.model.TaskEntity;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskCsvReader {

    public static List<TaskEntity> readCsv(File csvFile) throws IOException {
        CsvMapper mapper = new CsvMapper();

        CsvSchema schema = mapper.schemaFor(TaskEntity.class)
                .withSkipFirstDataRow(true)
                .withColumnSeparator(';').withoutQuoteChar();
        MappingIterator<TaskEntity> taskIterator = mapper
                .readerFor(TaskEntity.class)
                .with(schema).readValues(csvFile);

        List<TaskEntity> result = new ArrayList<>();
        while (taskIterator.hasNext()){

        }

        return taskIterator.readAll();
    }
}
