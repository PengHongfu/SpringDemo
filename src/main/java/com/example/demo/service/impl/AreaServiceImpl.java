package com.example.demo.service.impl;

import com.example.demo.dao.AreaDao;
import com.example.demo.entity.Area;
import com.example.demo.handler.MyException;
import com.example.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by PengHongfu 2018-05-28 17:54
 */
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> queryArea() {
        return areaDao.queryArea();
    }

    @Override
    public Area queryAreaById(Integer id) {
        /*if(true){//抛出运行时异常
            //throw new MyException("自定义异常！");
            //throw new RuntimeException();
        }
        int a =1/0;//抛出Exceptin*/
        return areaDao.queryAreaById(id);
    }

    @Transactional
    @Override
    public boolean insertArea(Area area) {
        if (area.getAreaName() != null &&
                !"".equals(area.getAreaName())) {
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());

            try {
                int effectedNum = areaDao.insertArea(area);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new MyException("插入区域信息失败！");
                }
            } catch (MyException e) {
                throw new MyException("插入区域信息失败！" + e.getMessage());
            }
        } else {
            throw new MyException("区域信息不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean updateArea(Area area) {
        if (area.getAreaId() != null &&
                "".equals(area.getAreaId())) {
            //area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            try {
                int effectedNum = areaDao.updateArea(area);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新区域信息失败！");
                }
            } catch (RuntimeException e) {
                throw new RuntimeException("更新区域信息失败！" + e.getMessage());
            }
        } else {
            throw new RuntimeException("区域信息不能为空！");
        }
    }
    @Transactional
    @Override
    public boolean deleteAreaById(Integer id) {
        if (id > 0) {
            try {
                int effectedNum = areaDao.deleteAreaById(id);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除区域信息失败！");
                }
            } catch (RuntimeException e) {
                throw new RuntimeException("删除区域信息失败！" + e.getMessage());
            }
        } else {
            throw new RuntimeException("区域Id不能为空！");
        }
    }
}
