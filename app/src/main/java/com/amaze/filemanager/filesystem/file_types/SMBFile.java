package com.amaze.filemanager.filesystem.file_types;

import android.content.Context;

import com.amaze.filemanager.filesystem.HybridFile;
import com.amaze.filemanager.utils.OpenMode;

import java.net.MalformedURLException;

import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;


/**
 * Created by Rustam Khadipash on 6/5/2018.
 */
public class SMBFile extends HybridFile {
    private String path;
    final private OpenMode mode = OpenMode.SMB;

    public SMBFile(OpenMode mode, String path) {
        super(mode, path);
        this.path = path;
    }

    public SMBFile(OpenMode mode, String path, String name, boolean isDirectory) {
        super(mode, path, name, isDirectory);
        this.path = path;
    }

    @Override
    public long lastModified() throws SmbException {
        SmbFile smbFile = getSmbFile();
        if (smbFile != null)
            return smbFile.lastModified();
        return super.lastModified();
    }

    @Override
    public long length() {
        try {
            return getLength();
        } catch (Exception e) {
            return super.length();
        }
    }

    @Override
    public long length(Context context) {
        try {
            return getLength();
        } catch (Exception e) {
            return super.length(context);
        }
    }

    private long getLength() throws Exception {
        SmbFile smbFile = getSmbFile();
        if (smbFile != null)
            try {
                return smbFile.length();
            } catch (SmbException ignored) {
            }
        throw new Exception();
    }

    @Override
    public String getName() {
        SmbFile smbFile = getSmbFile();
        if (smbFile != null)
            return smbFile.getName();
        return super.getName();
    }

    @Override
    public String getName(Context context) {
        SmbFile smbFile=getSmbFile();
        if(smbFile!=null)
            return smbFile.getName();
        return super.getName(context);
    }

    private SmbFile getSmbFile() {
        try {
            return new SmbFile(path);
        } catch (MalformedURLException e) {
            return null;
        }
    }

    private SmbFile getSmbFile(int timeout) {
        try {
            SmbFile smbFile = new SmbFile(path);
            smbFile.setConnectTimeout(timeout);
            return smbFile;
        } catch (MalformedURLException e) {
            return null;
        }
    }
}
