package Dao;

import domain.Student;

import java.util.List;

public interface StudentDao {
    /**
     * 增加一个信息
     *
     * @param student
     */
    void add(Student student) ;

    /**
     * 删除一个信息
     * @param id
     * @return
     */
    boolean delete(int id);

    /**
     * 修改
     * @param student
     */

    void update(Student student);

    /**
     * 查询一个信息
     * @param id
     * @return
     */
    Student select(int id);

    List<Student> selectList();
}

