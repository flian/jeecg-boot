package org.jeecg.modules.system.rule;

import com.alibaba.fastjson.JSONObject;
import org.jeecg.common.handler.IFillRuleHandler;
import org.jeecg.common.util.SpringContextUtils;
import org.jeecg.modules.system.mapper.CommonMapper;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <h3>jeecg-boot-parent</h3>
 * <p>生成项目流程单号</p>
 *
 * @author : foy
 * @date : 2023-11-16 15:34
 **/
public class ProjectIdRule implements IFillRuleHandler {
    @Override
    public Object execute(JSONObject params, JSONObject formData) {
        String tableName = params.getString("tableName");
        String column = params.getString("column");
        CommonMapper commonMapper = SpringContextUtils.getBean(CommonMapper.class);
        String lastOne = commonMapper.maxColumnVal(tableName, column);
        String year = year();
        if (null == lastOne) {
            return newYearStart(year);
        }
        String lastOneYear = lastOne.substring(0, 2);
        if (year.equals(lastOneYear)) {
            int lastCnt = Integer.parseInt(lastOne.substring(2)) + 1;
            return year + lastCnt;
        }

        return newYearStart(year);
    }

    private String newYearStart(String year) {
        return year + "1001";
    }

    private String year() {
        SimpleDateFormat sd = new SimpleDateFormat("yy");
        return sd.format(new Date());
    }
}
