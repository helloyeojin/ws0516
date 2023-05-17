package com.myadmin.service;

import com.myadmin.dto.Anc;
import com.myadmin.frame.MyAdminService;
import com.myadmin.mapper.AncMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AncService implements MyAdminService<Integer, Anc> {

    @Autowired
    AncMapper mapper;

    public AncService(AncMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void register(Anc anc) throws Exception {
        mapper.insert(anc);
    }

    @Override
    public void remove(Integer integer) throws Exception {
        mapper.delete(integer);
    }

    @Override
    public void modify(Anc anc) throws Exception {
        mapper.update(anc);
    }

    @Override
    public Anc get(Integer integer) throws Exception {
        return mapper.select(integer);
    }

    @Override
    public List<Anc> get() throws Exception {
        return mapper.selectall();
    }
}
