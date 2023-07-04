package com.atguigu.crud.dao;


import com.atguigu.crud.entity.TblSalary;

import java.util.List;

public interface TblSalaryMapper {
    int deleteByPrimaryKey(Integer salaryId);

    int insert(TblSalary record);

    int insertSelective(TblSalary record);

    TblSalary selectByPrimaryKey(Integer salaryId);

    int updateByPrimaryKeySelective(TblSalary record);

    int updateByPrimaryKey(TblSalary record);
    List<TblSalary> getAllSalary();
}