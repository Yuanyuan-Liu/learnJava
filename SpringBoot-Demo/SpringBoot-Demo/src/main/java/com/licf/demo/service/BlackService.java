package com.licf.demo.service;

import com.licf.demo.dao.BlackDeviceDAO;
import com.licf.demo.dao.BlackIpDAO;
import com.licf.demo.dao.BlackUserDAO;
import com.licf.demo.model.BlackDevice;
import com.licf.demo.model.BlackIp;
import com.licf.demo.model.BlackUser;
import com.licf.demo.model.request.BlackRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BlackService {
    @Resource
    private BlackUserDAO blackUserDAO;
    @Resource
    private BlackIpDAO blackIpDAO;
    @Resource
    private BlackDeviceDAO blackDeviceDAO;

    /**
     * 分页查询用户列表
     * @return
     */
    public Object list(BlackRequest[] blackRequests ){

/*        Set<String> uniqueIdSet = new HashSet<>();
        for (BlackRequest blackRequest : blackRequests) {

        }*/
        List<Map<String,Object>> list = new ArrayList<>();
        for (BlackRequest blackRequest : blackRequests) {
            Map<String,Object> map = new HashMap<>();
            //根据传入参数返回不同的结果
            map.put("id", blackRequest.getId());
            //获取相似度
            if (StringUtils.isBlank(blackRequest.getUniqueId()) && StringUtils.isBlank(blackRequest.getAppId()) && StringUtils.isBlank(blackRequest.getIp())) {
                map.put("number", 0);
                list.add(map);
                continue;
            }

            int blackUserNumber = 0, blackIpNumber = 0, blackDeviceNumber = 0;
            //查找黑名单库
            if (null != blackRequest.getUniqueId()) {
                BlackUser blackUser = blackUserDAO.selectByPrimaryKey(blackRequest.getUniqueId());
                if (null != blackUser) {
                    blackUserNumber = blackUser.getNumber();
                }
            }
            if (null != blackRequest.getIp()) {
                BlackIp blackIp = blackIpDAO.selectByPrimaryKey(blackRequest.getIp());
                if (null != blackIp) {
                    blackIpNumber = blackIp.getNumber();
                }
            }
            if (null != blackRequest.getAppId()) {
                BlackDevice blackDevice = blackDeviceDAO.selectByPrimaryKey(blackRequest.getAppId());
                if (null != blackDevice) {
                    blackDeviceNumber = blackDevice.getNumber();
                }
            }

            int finalNumber = blackUserNumber + blackIpNumber + blackDeviceNumber;
            if(finalNumber > 0) {
                double f1 = new BigDecimal((float)finalNumber/3).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                map.put("number", f1);
            } else {
                map.put("number", 0);
            }

            list.add(map);
        }
        return  list;
    }
}
