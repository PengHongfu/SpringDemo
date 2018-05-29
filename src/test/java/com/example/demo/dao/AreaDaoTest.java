package com.example.demo.dao;

import com.example.demo.entity.Area;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by PengHongfu 2018-05-28 17:27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {

    @Autowired
    private  AreaDao areaDao;

    @Test
    public void queryArea() {
        List<Area> areaList = areaDao.queryArea();
        assertEquals(2,areaList.size());
    }

    @Test
    public void queryAreaById() {
        Area area = areaDao.queryAreaById(1);
        assertEquals("江西",area.getAreaName());

    }

    @Test
    public void insertArea() {
        Area area = new Area();
        area.setAreaName("郓城");
        area.setPriority(4);
        int count = areaDao.insertArea(area);
        assertEquals(1,count);

    }

    @Test
    public void updateArea() {
    }

    @Test
    public void deleteAreaById() {
    }
}