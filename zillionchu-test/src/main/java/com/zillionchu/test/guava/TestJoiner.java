package com.zillionchu.test.guava;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019/12/4 16:06
 * @Description:
 */
public class TestJoiner {

    private static final Joiner STRING_JOINER = Joiner.on("+").skipNulls();
    // public static final String MASTER = "Master";

    private static final Splitter STRING_SPLITTER = Splitter.on("+")
            .omitEmptyStrings().trimResults();

    public static void main(String[] args) {
        System.out.println(buildAppMasterRoleName("1001"));

//        Iterator<String> parts = STRING_SPLITTER.split("1+2+3").iterator();
//        if (parts.hasNext() && parts.next().equals("1") && parts.hasNext()) {
//           // return parts.next();
//            System.out.println(parts.next());
//        }

    }

    public static String buildAppMasterRoleName(String appId) {
        return STRING_JOINER.join("Master", appId, appId, appId);
    }

}
