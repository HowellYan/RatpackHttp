package cn.com.ratpack.Dao;

import cn.com.ratpack.ModelMapper.AdContentMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class AdContentDao {
    @Resource
    private AdContentMapper adContentMapper;



}
