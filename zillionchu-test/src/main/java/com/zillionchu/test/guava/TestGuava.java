package com.zillionchu.test.guava;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019/12/3 15:04
 * @Description:
 */
public class TestGuava {
    public static void main(String[] args) {
        TestGuava testGuava=new TestGuava();
        testGuava.get("bbb","1001");

    }

    public void get(String type,String name) {
        ArrayList<String> strings = Lists.newArrayList(PermissionType.create_namespace, PermissionType.create_role);
        List<Integer> ll = strings.stream().map(s -> s.length()).collect(Collectors.toList());
        System.out.println(ll);
        Set<Permission> collect =
                Stream.of(PermissionType.create_namespace, PermissionType.create_role).map(p -> createPermission(type
                        ,p)).collect(Collectors.toSet());
        System.out.println(collect);
    }


    public Permission createPermission(String type,String name ) {
        Permission permission = new Permission();
        permission.setPermissionType(type);
        permission.setName(name);
        return permission;
    }
}
