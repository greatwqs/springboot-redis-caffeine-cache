package com.jincou.cache.controller;

import com.jincou.cache.dto.UserDTO;
import com.jincou.cache.service.CaffeineCacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 测试
 *
 * http://localhost:8084/putUser?userId=1001
 *
 * http://localhost:8084/queryUser?userId=1001
 *
 * @author xub
 * @date 2022/3/16 下午3:13
 */
@Slf4j
@RestController
public class CaffeineCacheController {

    @Autowired
    CaffeineCacheService caffeineCacheService;


    @RequestMapping(value = "/queryUser")
    public UserDTO queryUser(String userId) {
        UserDTO userDTO = caffeineCacheService.queryUser(userId);

        return userDTO;
    }


    @RequestMapping(value = "/queryUserSyncList")
    public List<UserDTO> queryUserSyncList(String userId) {
        return caffeineCacheService.queryUserSyncList(userId);
    }

    @RequestMapping(value = "/putUser")
    public String putUser(String userId) {
        UserDTO userDTO = new UserDTO(userId, "addr");
        caffeineCacheService.putUser(userId, userDTO);
        return "success";
    }

    @RequestMapping(value = "/evictUserSync")
    public String evictUserSync(String userId) {
        return caffeineCacheService.evictUserSync(userId);
    }

}
