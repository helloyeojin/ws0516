package com.myadmin.service;

import com.myadmin.dto.Marker;
import com.myadmin.frame.MyAdminMapper;
import com.myadmin.frame.MyAdminService;
import com.myadmin.mapper.MarkerMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MarkerService implements MyAdminService<Integer, Marker> {
    @Autowired
    MarkerMapper mapper;

    public MarkerService(MarkerMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void register(Marker marker) throws Exception {
        mapper.insert(marker);
    }

    @Override
    public void remove(Integer integer) throws Exception {
        mapper.delete(integer);
    }

    @Override
    public void modify(Marker marker) throws Exception {
        mapper.update(marker);
    }

    @Override
    public Marker get(Integer integer) throws Exception {
        return mapper.select(integer);
    }

    @Override
    public List<Marker> get() throws Exception {
        return mapper.selectall();
    }
}
