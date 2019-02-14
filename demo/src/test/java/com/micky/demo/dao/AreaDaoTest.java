package com.micky.demo.dao;

import com.micky.demo.entity.Area;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {
    @Autowired
    private AreaDao areaDao;

    @Test
    @Ignore
    public void queryArea() {
        List<Area> areaList = areaDao.queryArea();
        assertEquals(2, areaList.size());
    }

    @Test
    @Ignore
    public void queryAreaById() {
        Area area = areaDao.queryAreaById(1);
        assertEquals("ddd", area.getAreaName());
    }

    @Test
    @Ignore
    public void insertArea() {
        Area area = new Area();
        area.setAreaName("hehe");
        area.setIsDelete(0);
        area.setPriority(1);
       int areaId =  areaDao.insertArea(area);
       assertEquals(1,areaId);
    }

    @Test
    public void updateArea() {
        Area area = new Area();
        area.setAreaName("hehe");
        area.setIsDelete(0);
        area.setPriority(2);
        area.setAreaId(3);
        int effectnum = areaDao.updateArea(area);
        assertEquals(1,effectnum);
    }
}