package com.zillionchu.test.json;

import lombok.Data;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019/12/13 15:42
 * @Description:
 */
@Data
public class JsonUser {
    private String user;
    private String age;

    public JsonUser(String user, String age) {
        this.user = user;
        this.age = age;
    }
}
