package com.myadmin.mapper;

import com.myadmin.dto.Marker;
import com.myadmin.frame.MyAdminMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MarkerMapper extends MyAdminMapper<Integer, Marker> {
}
