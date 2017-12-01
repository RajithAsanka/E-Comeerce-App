
package com.nr.fc.service.impl;

import com.nr.fc.dao.ImageBankDao;
import com.nr.fc.model.ImageBank;
import com.nr.fc.service.ImageBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author Naveen
 */
@Service
public class ImageBankServiceImpl implements ImageBankService {

    @Autowired
    private ImageBankDao imageBankDao;

    @Override
    public ImageBank findById(String id) {
        return imageBankDao.read(id);
    }

    @Override
    @Transactional
    public void save(ImageBank imageBank) {
        imageBankDao.create(imageBank);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void update(ImageBank imageBank) {
        imageBankDao.update(imageBank);
    }

}
