package com.kgc.kmall.manager.controller;


import com.kgc.kmall.bean.PmsBaseCatalog1;
import com.kgc.kmall.bean.PmsBaseCatalog2;
import com.kgc.kmall.bean.PmsBaseCatalog3;


import com.kgc.kmall.service.CatalogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@Api(tags = "查询1，2，3级分类", description = "提供用户相关的Rest API")
public class CatalogController {
    @Reference
    CatalogService catalogService;

    @ApiOperation("查询1级分类")
    @PostMapping("/getCatalog1")
//    @RequestMapping("/getCatalog1")
    public List<PmsBaseCatalog1> getCatalog1() {
        return catalogService.getCatalog1();
    }
    @ApiOperation("查询2级分类")
    @PostMapping("/getCatalog2")
    @ApiImplicitParam(name = "catalog1Id",value = "1级分类Id",required = true)
//    @RequestMapping("getCatalog2")
    public List<PmsBaseCatalog2> getCatalog2(Integer catalog1Id) {
        return catalogService.getCatalog2(catalog1Id);
    }
    @ApiOperation("查询3级分类")
    @PostMapping("/getCatalog3")
    @ApiImplicitParam(name = "catalog2Id",value = "2级分类Id",required = true)
//    @RequestMapping("getCatalog3")
    public List<PmsBaseCatalog3> getCatalog3(Long catalog2Id) {
        return catalogService.getCatalog3(catalog2Id);
    }
}