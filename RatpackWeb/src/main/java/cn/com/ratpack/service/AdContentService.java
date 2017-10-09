package cn.com.ratpack.service;

import cn.com.ratpack.Dao.AdContentDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class AdContentService {

    @Autowired
    private AdContentDao adContentDao;



}
