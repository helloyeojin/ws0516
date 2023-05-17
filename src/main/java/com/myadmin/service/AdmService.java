package com.myadmin.service;

import com.myadmin.dto.Adm;
import com.myadmin.dto.Lecture;
import com.myadmin.frame.MyAdminService;
import com.myadmin.mapper.AdmMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AdmService implements MyAdminService<String, Adm> {
    @Autowired
    AdmMapper mapper;

    public AdmService(AdmMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void register(Adm adm) throws Exception {
        mapper.insert(adm);
    }

    @Override
    public void remove(String s) throws Exception {
        mapper.delete(s);
    }

    @Override
    public void modify(Adm adm) throws Exception {
        mapper.update(adm);
    }

    @Override
    public Adm get(String s) throws Exception {
        return mapper.select(s);
    }

    @Override
    public List<Adm> get() throws Exception {
        return mapper.selectall();
    }
}
