package com.wendy.jmock;

import mockit.Mock;
import mockit.MockUp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FileExportTest {

    @Test
    void export() {
        new MockUp<FileReader>() {
            @Mock
            public String readFromServer() {
                return "hello, I am server";
            }
        };
        FileExport fileExport = new FileExport();
        Assertions.assertTrue(fileExport.export());
    }
}