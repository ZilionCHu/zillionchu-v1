package com.github.zillionchu.zillionchucompanybiz.thirdparty.test;

import com.netflix.hystrix.HystrixCommand;

/**
 * @类名称 Test12
 * @类描述
 * @作者 chuyuefeng@tansun.cn
 * @创建时间 2019/10/29 16:45
 * @版本 1.00
 */
public class Test12 extends HystrixCommand {

    protected Test12(Setter setter) {
        super(setter);
    }

    @Override
    protected Object run() throws Exception {
        return null;
    }
}
