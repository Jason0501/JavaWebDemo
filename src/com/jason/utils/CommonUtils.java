package com.jason.utils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CommonUtils {
    public static boolean isEmpty(List list) {
        return list == null || list.size() <= 0;
    }

    public static boolean isNotEmpty(List list) {
        return !isEmpty(list);
    }

    public static boolean isEmpty(Object[] array) {
        return array == null || array.length <= 0;
    }

    public static boolean isNotEmpty(Object[] array) {
        return !isEmpty(array);
    }

    public static boolean equals(CharSequence c1, CharSequence c2) {
        return isNotEmpty(c1) && c1.equals(c2);
    }

    public static boolean isEmpty(CharSequence... s) {
        for (CharSequence charSequence : s) {
            if (charSequence == null || charSequence.length() <= 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNotEmpty(CharSequence... s) {
        return !isEmpty(s);
    }

    public static String textLimited(String s, int maxLength) {
        if (isEmpty(s) || s.length() <= maxLength) {
            return s;
        }
        return s.substring(0, maxLength) + "...";
    }

    /**
     * 根据url截取文件名
     *
     * @param url
     * @return
     */
    public static String getFileNameByUrl(String url) {
        String substring = "";
        try {
            substring = url.substring(url.lastIndexOf("/") + 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return substring;
    }

    /**
     * 将换行符替换为<br/>
     *
     * @param content
     * @return
     */
    private static String parseContent(String content) {
        if (isNotEmpty(content)) {
            content = content.replace("\n", "<br/>");
        }
        return content;
    }

    /**
     * 随机指定范围内N个不重复的数 最简单最基本的方法，能取到min，不能取到max，0 < n <= max-min
     *
     * @param min 指定范围最小值
     * @param max 指定范围最大值
     * @param n   随机数个数
     */
    public static ArrayList<Integer> randomCommon(int min, int max, int n) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (n > (max - min + 1) || max < min) {
            return arrayList;
        }
        int count = 0;
        while (count < n) {
            int num = (int) (Math.random() * (max - min)) + min;
            boolean flag = true;
            int size = arrayList.size();
            for (int j = 0; j < size; j++) {
                if (num == arrayList.get(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                arrayList.add(num);
                count++;
            }
        }
        return arrayList;
    }

    /**
     * 生成随机数
     *
     * @param min 指定范围最小值
     * @param max 指定范围最大值
     */
    public static int randomCommon(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }

    /**
     * 将double数据格式化，如果没小数部分，就不显示小数部分，如果有小数就显示小数，有一位就显示一位，有两位就显示两位，超过两位则四舍五入显示两位
     *
     * @param number
     * @return
     */
    public static String decimalFormat(double number) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return decimalFormat.format(number);
    }
}
