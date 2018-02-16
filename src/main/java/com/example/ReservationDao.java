package com.example;

import java.util.List;

import org.seasar.doma.AnnotateWith;
import org.seasar.doma.Annotation;
import org.seasar.doma.AnnotationTarget;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

@Dao(config = AppConfig.class)
@ConfigAutowireable
public interface ReservationDao {
    @Select
    @Bean
    List<Reservation> selectAll();

    @Select
    @Bean
    List<Reservation> selectByName(String name);

    @Insert
    @Transactional
    @Bean
    int insert(Reservation reservation);
}
