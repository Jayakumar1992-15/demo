package com.example.java;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TaskManagerMainTest {
    private ByteArrayOutputStream outContent;
    private PrintStream originalOut;

    @Before
    public void setUp() {
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testMainExecutesWithoutException() {
        try {
            TaskManagerMain.main(new String[] {});
        } catch (Exception e) {
            fail("Main method threw an exception: " + e.getMessage());
        }
    }

    @Test
    public void testMainOutputContainsTasks() {
        TaskManagerMain.main(new String[] {});
        String output = outContent.toString();
        assertTrue("Output should contain 'Tasks:'", output.contains("Tasks:"));
        assertTrue("Output should contain 'Buy groceries'", output.contains("Buy groceries"));
        assertTrue("Output should contain 'Finish homework'", output.contains("Finish homework"));
        assertTrue("Output should contain 'Call mom'", output.contains("Call mom"));
    }

    @Test
    public void testMainOutputContainsMarkingMessage() {
        TaskManagerMain.main(new String[] {});
        String output = outContent.toString();
        assertTrue("Output should contain marking message", output.contains("Marking 'Finish homework' as done"));
    }

    @Test
    public void testMainOutputContainsUpdatedTasks() {
        TaskManagerMain.main(new String[] {});
        String output = outContent.toString();
        assertTrue("Output should contain 'Updated Tasks:'", output.contains("Updated Tasks:"));
    }

    @Test
    public void testMainOutputContainsRemovingMessage() {
        TaskManagerMain.main(new String[] {});
        String output = outContent.toString();
        assertTrue("Output should contain removing message", output.contains("Removing 'Finish homework' ..."));
    }

    @Test
    public void testMainOutputContainsRemainingTasks() {
        TaskManagerMain.main(new String[] {});
        String output = outContent.toString();
        assertTrue("Output should contain 'Buy groceries'", output.contains("Buy groceries"));
        assertTrue("Output should contain 'Call mom'", output.contains("Call mom"));
    }
}