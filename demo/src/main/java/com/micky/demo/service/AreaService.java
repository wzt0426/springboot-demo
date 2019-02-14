package com.micky.demo.service;

import com.micky.demo.entity.Area;

import java.util.List;

public interface AreaService {
    List<Area> queryArea();
    Area  queryAreaById(int qreaId);
    boolean insertArea(Area area);
    boolean updateArea(Area area);
}
