package com.amaze.filemanager.filesystem.file_types;

import com.amaze.filemanager.filesystem.HybridFile;
import com.amaze.filemanager.utils.OpenMode;


/**
 * Created by Rustam Khadipash on 6/5/2018.
 */
public class BoxFile extends HybridFile {
    public BoxFile(OpenMode mode, String path) {
        super(mode, path);
    }

    public BoxFile(OpenMode mode, String path, String name, boolean isDirectory) {
        super(mode, path, name, isDirectory);
    }
}
