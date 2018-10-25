package demo.springboot.Collectors;

import jdk.nashorn.internal.parser.JSONParser;
import netscape.javascript.JSObject;
import springfox.documentation.spring.web.json.Json;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Testing the order of execution.
 *
 * @author Benjamin Winterberg
 */
public class Streams {


    /**
     * 1----
     * 11---
     * ----111
     * ----112
     * 12---
     * ---121
     * ---122
     * ---123
     * 13---
     * ---131
     * ---132
     * ---133
     * 2----
     * 21---
     * ----211
     * ----212
     * 22---
     * ---221
     * ---222
     * ---223
     * 3----
     * 31---
     * ----311
     * ----312
     */


    private static void test77() {
        //1-(全选)  21-(全选)
        //3-(全选)
        List<Long> cateIds = Arrays.asList(3L, 31L, 311L, 312L);
        List<GoodsCate> cateList = Arrays.asList(
                new GoodsCate(3L, "3L", null),
                new GoodsCate(31L, "31L", 3L),
                new GoodsCate(311L, "311L", 31L),
                new GoodsCate(312L, "312L", 31L)
        );
        List<GoodsCate> base =cateList;
        cateList = cateList.stream().filter(item -> base.stream().noneMatch(i -> item.getCateParentId() == i.getCateId())).collect(Collectors.toList());
        List<String> scopeNames = (cateList.stream().map(GoodsCate::getCateName).collect(Collectors.toList()));

        System.out.println(scopeNames);
    }


    private static void test88() {
        //(123)  21-(全选)  3-(全选)
        List<Long> cateIds = Arrays.asList(3L, 31L, 311L, 312L);
        List<GoodsCate> cateList = Arrays.asList(
                new GoodsCate(123L, "123L", 12L),
//                * 21---
//                * ----211
//                * ----212
                new GoodsCate(21L, "21L", 2L),
                new GoodsCate(211L, "211L", 21L),
                new GoodsCate(212L, "212L", 21L),

                new GoodsCate(3L, "3L", null),
                new GoodsCate(31L, "31L", 3L),
                new GoodsCate(311L, "311L", 31L),
                new GoodsCate(312L, "312L", 31L)
        );
//        cateList.add(new GoodsCate(412L, "412L", 41L));
        List<GoodsCate> base =cateList;

        cateList = cateList.stream().filter(item -> base.stream().noneMatch(i -> item.getCateParentId() == i.getCateId())).collect(Collectors.toList());
        List<String> scopeNames = (cateList.stream().map(GoodsCate::getCateName).collect(Collectors.toList()));

        System.out.println(scopeNames);
    }
    public static void main(String[] args) {
        test77();
        test88();
    }
}