package com.example.demo.web;

import com.example.demo.entity.Area;
import com.example.demo.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by PengHongfu 2018-05-28 18:05
 */
@RestController
@RequestMapping("/area")
public class AreaController {
    private final static Logger logger = LoggerFactory.getLogger(AreaController.class);
    @Autowired
    private AreaService areaService;

    @GetMapping(value = "/listarea")
    public Map<String, Object> listArea(){
        logger.debug("----------进入查询区域列表页面-----------");
        logger.info("----------进入查询区域列表页面-----------");
        logger.warn("----------进入查询区域列表页面-----------");
        logger.error("----------进入查询区域列表页面-----------");
        Map<String, Object> modelMap = new HashMap<>();
        List<Area> list = areaService.queryArea();
        modelMap.put("areaList", list);
        return modelMap;
    }

    @GetMapping("/getarea")
    public Map<String, Object> getAreaByAreaId(Integer areaId){
        Map<String, Object> modelMap = new HashMap<>();
        Area area = areaService.queryAreaById(areaId);

        modelMap.put("area", area);

        return modelMap;
    }

    @PostMapping("/addarea")
    public Map<String, Object> addArea(@RequestBody Area area){
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("success", areaService.insertArea(area));

        return modelMap;
    }

    @PostMapping("/modifyarea")
    public Map<String, Object> modifyArea(@RequestBody Area area){
        Map<String, Object> modelMap = new HashMap<>();

        modelMap.put("success", areaService.updateArea(area));

        return modelMap;
    }

    @PostMapping("/delarea")
    public Map<String, Object> deleteArea(Integer areaId){
        System.out.println(areaId);
        Map<String, Object> modelMap = new HashMap<>();

        modelMap.put("success", areaService.deleteAreaById(areaId));

        return modelMap;
    }


}
