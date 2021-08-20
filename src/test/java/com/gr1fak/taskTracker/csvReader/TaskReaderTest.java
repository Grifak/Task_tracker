package com.gr1fak.taskTracker.csvReader;

import com.gr1fak.taskTracker.csv.TaskCsvReader;
import com.gr1fak.taskTracker.model.TaskEntity;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.List;

public class TaskReaderTest {

    @Test
    public void testReadingTaskEntityFromCsv() throws Exception{
        File testFile = new File("C:\\Users\\User\\Desktop\\task.csv");
        List<TaskEntity> tasks = TaskCsvReader.readCsv(testFile);

        Assert.assertEquals(2, tasks.size());
        TaskEntity task1 = tasks.get(0);
        Assert.assertEquals("sad", task1.getName());
        Assert.assertEquals("BACKLOG", task1.getStatus());

        TaskEntity task2 = tasks.get(1);
        Assert.assertEquals("sdf", task2.getName());
        Assert.assertEquals("BACKLOG", task2.getStatus());

    }
}
