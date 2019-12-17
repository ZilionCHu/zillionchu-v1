package com.zillionchu.common.utils.validate;


import org.springframework.util.StringUtils;

import java.util.regex.Pattern;


public class InputValidator {
    public static final String INVALID_CLUSTER_NAMESPACE_MESSAGE = "只允许输入数字，字母和符号 - _ .";
    public static final String INVALID_NAMESPACE_NAMESPACE_MESSAGE = "不允许以.json, .yml, .yaml, .xml, .properties结尾";
    public static final String CLUSTER_NAMESPACE_VALIDATOR = "[0-9a-zA-Z_.-]+";
    private static final String APP_NAMESPACE_VALIDATOR = "[a-zA-Z0-9._-]+(?<!\\.(json|yml|yaml|xml|properties))$";
    private static final Pattern CLUSTER_NAMESPACE_PATTERN =
            Pattern.compile(CLUSTER_NAMESPACE_VALIDATOR);
    private static final Pattern APP_NAMESPACE_PATTERN =
            Pattern.compile(APP_NAMESPACE_VALIDATOR);

    public static boolean isValidAppNamespace(String name) {
        if (StringUtils.isEmpty(name)) {
            return false;
        }
        return CLUSTER_NAMESPACE_PATTERN.matcher(name).matches() && APP_NAMESPACE_PATTERN.matcher(name).matches();
    }

//    public  class AppNamespace {
//
//        @NotBlank(message = "App Name cannot be blank")
//        @Pattern(
//                regexp = InputValidator.CLUSTER_NAMESPACE_VALIDATOR,
//                message = "Namespace格式错误: " + InputValidator.INVALID_CLUSTER_NAMESPACE_MESSAGE + " & " + InputValidator
//                        .INVALID_NAMESPACE_NAMESPACE_MESSAGE
//        )
//        //@Column(name = "Name", nullable = false)
//        private String name;
//
//        @NotBlank(message = "AppId cannot be blank")
//        //@Column(name = "AppId", nullable = false)
//        private String appId;
//
//
//        public AppNamespace() {
//        }
//    }
}
