package com.myadmin.service;

import com.myadmin.dto.Lecture;
import com.myadmin.frame.MyAdminService;
import com.myadmin.mapper.LectureMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class LectureService implements MyAdminService<Integer, Lecture> {
    @Autowired
    LectureMapper mapper;

    public LectureService(LectureMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void register(Lecture lecture) throws Exception {
        mapper.insert(lecture);
    }

    @Override
    public void remove(Integer integer) throws Exception {
        mapper.delete(integer);
    }

    @Override
    public void modify(Lecture lecture) throws Exception {
        mapper.update(lecture);
    }

    @Override
    public Lecture get(Integer integer) throws Exception {
        return mapper.select(integer);
    }

    @Override
    public List<Lecture> get() throws Exception {
        return mapper.selectall();
    }
}
