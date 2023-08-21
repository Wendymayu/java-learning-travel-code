package com.wendy.basic.practice.slice_file_upload;

import lombok.Data;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/8/21 23:34
 * @Version 1.0
 */
@Data
public class SliceInfo {
    private int start;

    private int end;

    private int sliceCode;

    private String filePath;

    private String tempFilePath;

    private String fileName;

    public SliceInfo(int start, int end, int sliceCode, String filePath, String tempFilePath, String fileName) {
        this.start = start;
        this.end = end;
        this.sliceCode = sliceCode;
        this.filePath = filePath;
        this.tempFilePath = tempFilePath;
        this.fileName = fileName;
    }
}
