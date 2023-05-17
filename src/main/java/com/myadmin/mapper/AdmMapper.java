package com.myadmin.mapper;

import com.myadmin.dto.Adm;
import com.myadmin.dto.Lecture;
import com.myadmin.frame.MyAdminMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AdmMapper extends MyAdminMapper<String, Adm> {
}
