package util.test;

import Dao.StudentDao;
import Dao.impl.StudentDaoImpl;
import domain.Student;
import org.junit.Test;
import util.JDBCUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.*;

public class StudentDaoTest {

    StudentDao studentDao=new StudentDaoImpl();

    @Test
    public void add() {

        Student student = new Student();
        student.setName("hh1");
        student.setEmail("hh@qq.com");
        student.setAge(18);
        studentDao.add(student);
    }

    @Test
    public void delete() {

        boolean delete = studentDao.delete(13);
        if (delete){
            System.out.println("执行成功了1条数据");
        }else {
            System.out.println("没有数据");
        }

    }

    @Test
    public void update() {
        Student student= new Student();
        student.setName("老王");
        studentDao.update(student);
    }

    @Test
    public void select() {
        Student student = new Student();
        Student select = studentDao.select(12);
        System.out.println(select.toString());

    }

    @Test
    public void selectList() {
        List<Student>studentList = studentDao.selectList();
//        foreach,循环
        for (Student student:studentList){
            System.out.println(student);
        }
//        for,循环
        for (int i=0; i<studentList.size();i++){
            Student student = studentList.get(i);
        }
//        迭代器遍历
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()){
            Student student=iterator.next();
            System.out.println(student);
        }
    }
}