package com.wendy.basic.nio.file_permisson;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/10/20 23:09
 * @Version 1.0
 */
public class PosixFilePermissionDemo {
    /**
     * 设置文件的权限
     *
     * @param file 文件
     */
    private void setFilePermision(File file) {
        //using PosixFilePermission to set file permissions 777
        Set<PosixFilePermission> perms = new HashSet<PosixFilePermission>();
        //add owners permission
        perms.add(PosixFilePermission.OWNER_READ);
        perms.add(PosixFilePermission.OWNER_WRITE);
        perms.add(PosixFilePermission.OWNER_EXECUTE);
        //add group permissions
        perms.add(PosixFilePermission.GROUP_READ);
        perms.add(PosixFilePermission.GROUP_WRITE);
        perms.add(PosixFilePermission.GROUP_EXECUTE);
        //add others permissions
        perms.add(PosixFilePermission.OTHERS_READ);
        perms.add(PosixFilePermission.OTHERS_WRITE);
        perms.add(PosixFilePermission.OTHERS_EXECUTE);
        try {
            Files.setPosixFilePermissions(Paths.get(file.getAbsolutePath()), perms);
            Files.setPosixFilePermissions(file.toPath(), perms);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 指定权限创建文件夹
     *
     * @param directoryStr 文件夹路径
     * @throws IOException
     */
    private void createDirectoryWithPermision(String directoryStr) throws IOException {
        FileSystem fileSystem = FileSystems.getDefault();
        Path directory = fileSystem.getPath(directoryStr);
        Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rwxr-x---");
        FileAttribute<Set<PosixFilePermission>> attr = PosixFilePermissions.asFileAttribute(perms);
        Files.createDirectory(directory, attr);
    }
}
