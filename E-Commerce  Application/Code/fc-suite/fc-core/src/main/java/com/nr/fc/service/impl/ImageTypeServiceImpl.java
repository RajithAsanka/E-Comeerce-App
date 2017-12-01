package com.nr.fc.service.impl;

import com.nr.fc.dao.ImageTypeDao;
import com.nr.fc.model.ImageType;
import com.nr.fc.service.ImageTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Naveen
 */
@Service
public class ImageTypeServiceImpl implements ImageTypeService {

    @Autowired
    private ImageTypeDao imageTypeDao;

    @Override
    public ImageType findById(String id) {
        return imageTypeDao.read("JPEG");
    }

}
