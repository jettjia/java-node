package com.atguigu.springdata;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonRepsotory extends JpaRepository<Person, Integer>, JpaSpecificationExecutor<Person>,PersonDao {
    // 根据 lastName 来获取对应的 Person
    Person getByLastName(String lastName);

    // WHERE lastName LIKE ?% AND id < ?
    List<Person> getByLastNameStartingWithAndIdLessThan(String lastName, Integer id);

    List<Person> getByAddress_IdGreaterThan(Integer id);

    // 查询 id 值最大的那个 Person
    // 使用 @Query 注解可以自定义 JPQL 语句以实现更灵活的查询
    @Query("SELECT p FROM Person p WHERE p.id = (SELECT max(p2.id) FROM Person p2)")
    Person getMaxIdPerson();

    // 为 @Query 注解传递参数的方式1: 使用占位符
    @Query("SELECT p FROM Person p WHERE p.lastName = ?1 AND p.email = ?2")
    List<Person> testQueryAnnotationParams1(String lastName, String email);

    // 为 @Query 注解传递参数的方式2: 命名参数的方式
    @Query("SELECT p FROM Person p WHERE p.lastName = :lastName AND p.email = :email")
    List<Person> testQueryAnnotationParams2(@Param("lastName") String lastName, @Param("email") String email);

    // SpringData 允许在占位符上添加 %%
    @Query("SELECT p FROM Person p WHERE p.lastName LIKE %?1% AND p.email LIKE %?2%")
    List<Person> testQueryAnnotationLikeParam(String lastName, String email);

    // 设置 nativeQuery=true 即可以使用原生的 SQL 查询
    @Query(value = "SELECT count(id) FROM jpa_persons", nativeQuery = true)
    Long getTotalCount();

    // 可以通过自定义的 JPQL 完成 UPDATE 和 DELETE 操作. 注意: JPQL 不支持使用 INSERT
    // 在 @Query 注解中编写 JPQL 语句, 但必须使用 @Modifying 进行修饰. 以通知 SpringData, 这是一个
    // UPDATE 或 DELETE 操作
    // UPDATE 或 DELETE 操作需要使用事务, 此时需要定义 Service 层. 在 Service 层的方法上添加事务操作.
    // 默认情况下, SpringData 的每个方法上有事务, 但都是一个只读事务. 他们不能完成修改操作!
    @Modifying
    @Query("UPDATE Person p SET p.email = :email WHERE id = :id")
    void updatePersonEmail(@Param("id") Integer id, @Param("email") String email);
}
