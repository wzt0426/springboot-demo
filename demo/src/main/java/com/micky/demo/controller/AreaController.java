package com.micky.demo.controller;

import com.micky.demo.entity.Area;
import com.micky.demo.service.AreaService;
import com.micky.demo.utils.Result;
import com.micky.demo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/area")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/arealist", method = RequestMethod.GET)
    public Result<Area> listArea() {
        //Map<String,Object> modelMap = new HashMap<String,Object>();
        List<Area> list = areaService.queryArea();
        //modelMap.put("areaList",list);
        return ResultUtil.success(list);
    }

    @RequestMapping(value = "/getArea", method = RequestMethod.GET)
    public Map<String,Object> getArea(Integer id) {
        Map<String,Object> modelMap = new HashMap<String,Object>();
        Area area = areaService.queryAreaById(id);
        modelMap.put("area",area);
        return modelMap;
    }

    @RequestMapping(value = "/addArea", method = RequestMethod.POST)
    public Map<String,Object> addArea(@RequestBody Area area) {
        Map<String,Object> modelMap = new HashMap<String,Object>();
        modelMap.put("success",areaService.insertArea(area));
        return modelMap;
    }

    @RequestMapping(value = "/editArea", method = RequestMethod.POST)
    public Map<String,Object> editArea(@RequestBody Area area) {
        Map<String,Object> modelMap = new HashMap<String,Object>();
        modelMap.put("success",areaService.updateArea(area));
        return modelMap;
    }

}

