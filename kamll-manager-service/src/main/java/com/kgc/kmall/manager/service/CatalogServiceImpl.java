package com.kgc.kmall.manager.service;

import com.kgc.kmall.bean.*;
import com.kgc.kmall.manager.mapper.PmsBaseCatalog1Mapper;
import com.kgc.kmall.manager.mapper.PmsBaseCatalog2Mapper;
import com.kgc.kmall.manager.mapper.PmsBaseCatalog3Mapper;
import com.kgc.kmall.service.CatalogService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
@Service
public class CatalogServiceImpl implements CatalogService {

    @Resource
    PmsBaseCatalog1Mapper pmsBaseCatalog1Mapper;

    @Resource
    PmsBaseCatalog2Mapper pmsBaseCatalog2Mapper;

    @Resource
    PmsBaseCatalog3Mapper pmsBaseCatalog3Mapper;

    //一级分类
    @Override
    public List<PmsBaseCatalog1> getCatalog1() {
        return pmsBaseCatalog1Mapper.selectByExample(null);
    }

    //二级分类
    @Override
    public List<PmsBaseCatalog2> getCatalog2(Integer catalog1Id) {
        PmsBaseCatalog2Example example=new PmsBaseCatalog2Example();
        PmsBaseCatalog2Example.Criteria criteria = example.createCriteria();
        criteria.andCatalog1IdEqualTo(catalog1Id);
        return pmsBaseCatalog2Mapper.selectByExample(example);
    }

    //三级分类
    @Override
    public List<PmsBaseCatalog3> getCatalog3(Long catalog2Id) {
        PmsBaseCatalog3Example example=new PmsBaseCatalog3Example();
        PmsBaseCatalog3Example.Criteria criteria = example.createCriteria();
        criteria.andCatalog2IdEqualTo(catalog2Id);
        return pmsBaseCatalog3Mapper.selectByExample(example);
    }
}
