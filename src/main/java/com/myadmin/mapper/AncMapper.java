package com.myadmin.mapper;

import com.myadmin.dto.Anc;
import com.myadmin.frame.MyAdminMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AncMapper extends MyAdminMapper<Integer, Anc> {
}
