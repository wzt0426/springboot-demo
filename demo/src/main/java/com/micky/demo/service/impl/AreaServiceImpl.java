package com.micky.demo.service.impl;

import com.micky.demo.dao.AreaDao;
import com.micky.demo.entity.Area;
import com.micky.demo.enums.ResultEnum;
import com.micky.demo.handler.AreaException;
import com.micky.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> queryArea() {

       List<Area> list = areaDao.queryArea();
       try {
            int ss = 1/0;
       }catch (Exception e) {
           throw new AreaException(ResultEnum.CESHI_ERROR);
       }

        return list;
    }

    @Override
    public Area queryAreaById(int qreaId) {
       Area area =  areaDao.queryAreaById(qreaId);
        return area;
    }

    @Override
    @Transactional
    public boolean insertArea(Area area) {
        if (area.getAreaName() != null && !"".equals(area.getAreaName())) {
            try {
                int effectNum = areaDao.insertArea(area);
                if (effectNum > 0) {
                    return true;
                } else {
                    throw new AreaException(ResultEnum.CESHI_ERROR);
                }
            } catch (Exception e) {
                throw new AreaException(ResultEnum.CESHI_ERROR);
            }
        } else {
            throw new AreaException(ResultEnum.CESHI_ERROR);
        }
    }

    @Override
    @Transactional
    public boolean updateArea(Area area) {
        if (area.getAreaId() != null && !"".equals(area.getAreaId())) {
            try {
                int effectNum = areaDao.updateArea(area);
                if (effectNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入时异常");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入时异常"+e.getLocalizedMessage());
            }
        } else {
            throw new RuntimeException("信息不能为空");
        }
    }
}
