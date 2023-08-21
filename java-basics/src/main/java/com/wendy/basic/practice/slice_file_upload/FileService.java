package com.wendy.basic.practice.slice_file_upload;

import java.io.*;
import java.util.concurrent.*;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/8/21 22:06
 * @Version 1.0
 */
public class FileService {
    private String path = "D:/local_file_server/";

    private String fileName = "pepper.docx";

    private String filePath = path + fileName;

    private String tempFilePath = path + "temp/";

    private int ONE_MB = 1024 * 1024;

    private int sliceSize = ONE_MB;

    private ExecutorService executors;

    private void initExecutors() {
        executors = new ThreadPoolExecutor(10, 10,
                1, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
    }

    public void sliceFile() {
        initExecutors();
        SliceInfo sliceInfo = new SliceInfo(ONE_MB, 2 * ONE_MB, 1,
                filePath, tempFilePath, fileName);
        ReadFileThread thread = new ReadFileThread(sliceInfo);
        System.out.println(tempFilePath);
        executors.submit(thread);
    }

    private File mergeSlice() {
        return null;
    }

}
