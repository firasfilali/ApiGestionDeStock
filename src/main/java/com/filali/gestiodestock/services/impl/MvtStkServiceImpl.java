package com.filali.gestiodestock.services.impl;


import com.filali.gestiodestock.repository.MvtStkRepository;
import com.filali.gestiodestock.services.MvtStkService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
@Slf4j
public class MvtStkServiceImpl implements MvtStkService {

    private MvtStkRepository mvtStkRepository;
    @Autowired
    public MvtStkServiceImpl(MvtStkRepository mvtStkRepository) {
        this.mvtStkRepository = mvtStkRepository;
    }


}
