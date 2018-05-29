package com.example.demo.service;

import com.example.demo.entity.Area;

import java.util.List;

/**
 * Created by PengHongfu 2018-05-28 17:53
 */
public interface AreaService {
    /**
     * 列出区域信息
     *
     * @return
     */
    List<Area> queryArea();

    /**
     * 根据查询某一个区域信息
     *
     * @param id
     * @return
     */
    Area queryAreaById(Integer id);

    /**
     * 插入一个区域信息
     *
     * @param area 区域
     * @return
     */
    boolean insertArea(Area area);

    /**
     * 更新区域信息
     *
     * @param area
     * @return
     */
    boolean updateArea(Area area);

    /**
     * 删除某一个区域信息
     *
     * @param id
     * @return
     */
    boolean deleteAreaById(Integer id);
}
