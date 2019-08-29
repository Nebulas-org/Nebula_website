package com.gsac.nebulas.service.impl;

import com.gsac.nebulas.dao.PresentationMapper;
import com.gsac.nebulas.model.Presentation;
import com.gsac.nebulas.model.PresentationExample;
import com.gsac.nebulas.service.PresentationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 简介
 * @author YI
 * @date 2018-8-29 23:18:13
 */
@Service
public class PresentationServiceImpl implements PresentationService {
    @Autowired
    PresentationMapper presentationMapper;

    @Override
    public int save(Presentation presentation) {
        return presentationMapper.insertSelective(presentation);
    }

    @Override
    public Presentation find() {
        PresentationExample example = new PresentationExample();
        example.setLimit(1);
        example.setOrderByClause("crateDate DESC");
        PresentationExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo((byte)1);

        List<Presentation> presentations = presentationMapper.selectByExampleWithBLOBs(example);

        if (presentations != null && presentations.size() > 0){
            return presentations.get(0);
        }

        return null;
    }

    @Override
    public int update(Presentation presentation) {
        return presentationMapper.updateByPrimaryKeyWithBLOBs(presentation);
    }
}
