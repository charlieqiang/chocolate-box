package cn.charlie.member.info.service;

import cn.charlie.member.info.entity.MemberInfo;
import cn.charlie.member.info.mapper.MemberInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author charlie
 * @date 3/5/2023 10:42 PM
 **/
@Service
public class MemberInfoServiceImpl implements MemberInfoService {
    @Autowired
    private MemberInfoMapper memberInfoMapper;

    @Override
    public List<MemberInfo> getAllMemberInfo() {
        return memberInfoMapper.selectAll();
    }
}
