package com.enableets.edu.enable.cloud.exam.framework.core;

import com.enableets.edu.framework.core.dao.datasource.DruidProperties;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author caleb_liu@enable-ets.com
 * @date 2021/05/21
 **/

@Data
@Accessors(chain = true)
public class DruidCustomProperties extends DruidProperties {
    private String mapperLocations;
}
