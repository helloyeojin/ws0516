package com.myadmin.service;

import com.myadmin.dto.Lecture;
import com.myadmin.dto.Student;
import com.myadmin.frame.MyAdminService;
import com.myadmin.mapper.LectureMapper;
import com.myadmin.mapper.StudentMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StudentService implements MyAdminService<String, Student> {

    @Autowired
    StudentMapper mapper;

    @Override
    public void register(Student student) throws Exception {
        mapper.insert(student);
    }

    @Override
    public void remove(String s) throws Exception {
        mapper.delete(s);
    }

    @Override
    public void modify(Student student) throws Exception {
        mapper.update(student);
    }

    @Override
    public Student get(String s) throws Exception {
        return mapper.select(s);
    }

    @Override
    public List<Student> get() throws Exception {
        return mapper.selectall();
    }
}
