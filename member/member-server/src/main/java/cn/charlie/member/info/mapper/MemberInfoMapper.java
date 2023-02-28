package cn.charlie.member.info.mapper;

import cn.charlie.member.info.entity.MemberInfo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author charlie
 * @date 2/28/2023 3:47 PM
 **/
@Repository
public interface MemberInfoMapper extends Mapper<MemberInfo> {
}