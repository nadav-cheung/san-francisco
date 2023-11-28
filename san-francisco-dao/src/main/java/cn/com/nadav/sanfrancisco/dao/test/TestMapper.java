package cn.com.nadav.sanfrancisco.dao.test;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author cheung nadav
 * @date 8/3/23
 */
@Mapper
public interface TestMapper {

    @Select("select 1 from dual")
    int test();

}
