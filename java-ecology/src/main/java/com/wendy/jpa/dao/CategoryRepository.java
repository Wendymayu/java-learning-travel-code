package com.wendy.jpa.dao;

import com.wendy.jpa.pojo.JpaCategory;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/7/10 15:12
 * @Version 1.0
 */
public interface CategoryRepository extends CrudRepository<JpaCategory, String> {
    /**
     * 自动生成单表查询
     */
    Iterable<JpaCategory> findByCategoryName(String categoryName);

    @Query("select po from JpaCategory po where po.categoryName=:categoryName")
    Iterable<JpaCategory> findByCategoryName2(String categoryName);

    @Query("select po from JpaCategory po where po.categoryName=:name")
    Iterable<JpaCategory> findByCategoryName3(@Param("name") String categoryName);

    @Transactional //事务的注解
    @Modifying
    @Query("update JpaCategory n set n.description=:description where n.id =:id")
    int updateIpaCategory(String id, String description);

    @Query(value = "select * from ms_category c where c.category_name=:name",
            nativeQuery = true)
    Iterable<JpaCategory> findByCategoryName4(@Param("name") String categoryName);
}