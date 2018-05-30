package com.example.demo.dao;

import com.example.demo.entity.Area;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by PengHongfu 2018-05-28 17:16
 */
@Mapper
public interface AreaDao {

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
    int insertArea(Area area);

    /**
     * 更新区域信息
     *
     * @param area
     * @return
     */
    int updateArea(Area area);

    /**
     * 删除某一个区域信息
     *
     * @param id
     * @return
     */
    int deleteAreaById(Integer id);

}
