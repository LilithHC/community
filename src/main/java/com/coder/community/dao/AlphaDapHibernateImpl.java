package com.coder.community.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AlphaDapHibernateImpl implements AlphaDao{
    @Override
    public String select(){
        return "Hibernate";
    }
}
