package com.lh.util;

import org.springframework.web.multipart.MultipartFile;

public class UploadFile {
    MultipartFile image;

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
