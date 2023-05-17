package com.myadmin.mapper;

import com.myadmin.dto.Student;
import com.myadmin.frame.MyAdminMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface StudentMapper extends MyAdminMapper<String, Student> {
}
