package jdbcdemo2;

import Dao.StudentDao;
import Dao.impl.StudentDaoImpl;
import domain.Student;

import java.util.List;

public class JdbcTest {
    private static StudentDao studentDao=new StudentDaoImpl();

    public static void main(String[] args) {
//        Student select = studentDao.select(1);
        studentDao.select(1);
        List<Student> students = studentDao.selectList();
        for (Student s:students) {
            System.out.println(s.toString());
        }

         System.out.println(students.size());
        for (int i = 0; i <students.size() ; i++) {
            if ((i+1)%2==0){
                System.out.println("第"+(i+1)+"数据："+students.get(2));
            }

        }
    }
}
