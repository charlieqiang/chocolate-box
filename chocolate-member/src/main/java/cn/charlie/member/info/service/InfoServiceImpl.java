package cn.charlie.member.info.service;

import cn.charlie.member.info.entity.Info;
import cn.charlie.member.info.mapper.InfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author charlie
 * @date 3/5/2023 10:42 PM
 **/
@Service
public class InfoServiceImpl implements InfoService {
    @Autowired
    private InfoMapper infoMapper;

    @Override
    public List<Info> getAllMemberInfo() {
        return infoMapper.selectAll();
    }
}
