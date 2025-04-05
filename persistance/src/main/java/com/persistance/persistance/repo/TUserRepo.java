package com.persistance.persistance.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.persistance.persistance.entity.TUser;

@Repository
public interface TUserRepo extends JpaRepository<TUser, Integer>{

    @Query("SELECT t FROM TUser t WHERE t.userCode=?1")
    public List<TUser> findByUserCode(String userCode);
}
