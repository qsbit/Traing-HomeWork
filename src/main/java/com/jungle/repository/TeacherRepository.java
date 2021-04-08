package com.jungle.repository;

import com.jungle.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * 方式一：使用继承 方法有限
 * 方式二：根据约定写方法
 * 方式三：面向对象SQL
 * @Query   增删改 还要添加：@Modifying  @Transactional
 */

public interface TeacherRepository extends JpaRepository<Teacher,Integer>, JpaSpecificationExecutor<Teacher> {
    /**
     * 方式二
     * @param id
     * @return
     */
    Teacher findTeacherById(Integer id);

    List<Teacher> findTeacherByTeacherAge(Integer age);

    List<Teacher> findTeacherByTeacherNameLike(String teacherName);

    List<Teacher> findTeacherByIdBetween(Integer start, Integer end);

    /**
     * 方式三 JPQL
     * select * from 类名 where 属性=''
     */
    @Query("select t from Teacher t where teacherAddress = ?1 and teacherAge=?2")
    List<Teacher> findByAddress(String teacherAddress,Integer teacherAge);

    /**
     * 修改
     * @param teacherName
     * @param id
     * @return
     */
    @Transactional
    @Modifying
    @Query("update Teacher set teacherName=?1 where id = ?2")
    int updateTeacherById(String teacherName, Integer id);

    /**
     * 删除
     * @param id
     * @return
     */
    @Transactional
    @Modifying
    @Query("delete from Teacher where id=?1")
    int deleteTeacherById(Integer id);

    /**
     * 根据对象修改
     * @param teacher
     * @return
     */
    @Transactional
    @Modifying
    @Query("update Teacher set teacherName=:#{#teacher.teacherName},teacherAge=:#{#teacher.teacherAge},teacherAddress=:#{#teacher.teacherAddress} where id=:#{#teacher.id}")
    int updateTeacherById_Teacher(Teacher teacher);

    /**
     * 方式四
     * @param teacher
     * @return
     */
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "update hsd_teacher set teacher_name=:#{#teacher.teacherName},teacher_age=:#{#teacher.teacherAge},teacher_address=:#{#teacher.teacherAddress} where id=:#{#teacher.id}")
    int updateTeacherById_Teacher_4(Teacher teacher);

}
