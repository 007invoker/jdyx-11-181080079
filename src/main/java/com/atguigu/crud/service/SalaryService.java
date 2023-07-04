package com.atguigu.crud.service;

import com.atguigu.crud.dao.TblSalaryMapper;
import com.atguigu.crud.entity.TblSalary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryService {
    private final TblSalaryMapper salaryMapper;

    @Autowired
    public SalaryService(TblSalaryMapper salaryMapper) {
        this.salaryMapper = salaryMapper;
    }
    /**
     * 查询所有员工的薪资信息
     *
     * @return 对应的薪资信息
     */
    public List<TblSalary> getAllSalary() {
        return salaryMapper.getAllSalary();
    }

    /**
     * 根据薪资 ID 查询薪资信息
     *
     * @param salaryId 薪资 ID
     * @return 对应的薪资信息
     */
    public TblSalary getSalaryById(int salaryId) {
        return salaryMapper.selectByPrimaryKey(salaryId);
    }

    /**
     * 添加薪资信息
     *
     * @param salary 薪资对象
     * @return 添加成功的记录数
     */
    public int addSalary(TblSalary salary) {
        return salaryMapper.insertSelective(salary);
    }

    /**
     * 更新薪资信息
     *
     * @param salary 薪资对象
     * @return 更新成功的记录数
     */
    public int updateSalary(TblSalary salary) {
        return salaryMapper.updateByPrimaryKeySelective(salary);
    }

    /**
     * 删除薪资信息
     *
     * @param salaryId 薪资 ID
     * @return 删除成功的记录数
     */
    public int deleteSalary(int salaryId) {
        return salaryMapper.deleteByPrimaryKey(salaryId);
    }
}
