package com.atguigu.crud.controller;

import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.bean.Msg;
import com.atguigu.crud.entity.TblSalary;
import com.atguigu.crud.service.SalaryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salary")
public class SalaryController {
    private final SalaryService salaryService;

    @Autowired
    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    /**
     * 根据薪资 ID 获取薪资信息
     *
     * @param salaryId 薪资 ID
     * @return 薪资信息
     */
    @GetMapping("/{salaryId}")
    public TblSalary getSalaryById(@PathVariable int salaryId) {
        return salaryService.getSalaryById(salaryId);
    }

    /**
     * 查询所有员工的薪资星系
     *
     * @return 薪资信息
     */
    @GetMapping("/all")
    public Msg getAllSalary(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        // 这不是一个分页查询
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn, 5);
        // startPage后面紧跟的这个查询就是一个分页查询
        List<TblSalary> emps = salaryService.getAllSalary();
        // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
        PageInfo page = new PageInfo(emps, 5);
        return Msg.success().add("pageInfo", page);
    }

    /**
     * 添加薪资信息
     *
     * @param salary 薪资对象
     * @return 添加成功的记录数
     */
    @PostMapping("/add")
    public int addSalary(@RequestBody TblSalary salary) {
        return salaryService.addSalary(salary);
    }

    /**
     * 更新薪资信息
     *
     * @param salary 薪资对象
     * @return 更新成功的记录数
     */
    @PutMapping
    public int updateSalary(@RequestBody TblSalary salary) {
        return salaryService.updateSalary(salary);
    }

    /**
     * 删除薪资信息
     *
     * @param salaryId 薪资 ID
     * @return 删除成功的记录数
     */
    @DeleteMapping("/{salaryId}")
    public int deleteSalary(@PathVariable int salaryId) {
        return salaryService.deleteSalary(salaryId);
    }
}
