package com.amaze.filemanager.filesystem.file_types;

import com.amaze.filemanager.filesystem.HybridFile;
import com.amaze.filemanager.utils.OpenMode;


/**
 * Created by Rustam Khadipash on 6/5/2018.
 */
public class SMBFile extends HybridFile {
    public SMBFile(OpenMode mode, String path) {
        super(mode, path);
    }

    public SMBFile(OpenMode mode, String path, String name, boolean isDirectory) {
        super(mode, path, name, isDirectory);
    }
}
