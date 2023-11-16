package org.jeecg.modules.system.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * <h3>jeecg-boot-parent</h3>
 * <p>通用mapper</p>
 *
 * @author : foy
 * @date : 2023-11-16 15:52
 **/
public interface CommonMapper {
    String maxColumnVal(@Param("tableName") String tableName, @Param("column") String column);
}
