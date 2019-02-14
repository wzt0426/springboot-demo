package com.micky.demo.dao;

import com.micky.demo.entity.Area;

import java.util.List;

public interface AreaDao {
    List<Area> queryArea();
    Area  queryAreaById(int qreaId);
    int insertArea(Area area);
    int updateArea(Area area);
}
