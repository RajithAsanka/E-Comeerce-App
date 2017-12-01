/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nr.fc.service;

import com.nr.fc.model.ImageBank;

/**
 *
 * @author Rajitha
 */
public interface ImageBankService {

    /**
     *
     * @param id
     * @return
     */
    public ImageBank findById(String id);

    /**
     *
     * @param imageBank
     */
    public void save(ImageBank imageBank);
    
    /**
     * 
     * @param imageBank 
     */
    public void update(ImageBank imageBank);

}
