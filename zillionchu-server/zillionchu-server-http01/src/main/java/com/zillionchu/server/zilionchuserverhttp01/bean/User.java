package com.zillionchu.server.zilionchuserverhttp01.bean;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019/11/6 11:32
 * @Description:
 */
@Data
@ToString
@Builder
//@NoArgsConstructor
public class User {

    private String age;
    private String name;

}

