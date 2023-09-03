package com.example.demo.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tools {
    @SuppressWarnings("unchecked")
    public static Map<String, Object> obj2Map(Object obj) {
        String jsonStr = JSON.toJSONString(obj);
        return (Map<String, Object>) JSONObject.parse(jsonStr);
    }

    // 过滤特殊字符
    public static String StringFilter(String str) {
        // 清除掉所有特殊字符
        try {
            String regEx = "[`~!@#$%^&*()+=|{}':;',//[//].<>/\\?~！@#￥%&*（）——+|{}【】‘；：”“’。，、？\"? ]";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(str);
            return m.replaceAll("").trim();
        } catch (Throwable t) {
            return null;
        }
    }

    public static boolean verifyIp(String ipConfig, String ipRequest) {
        String splitChar = ",";
        if (ipConfig.indexOf(splitChar) == -1) {
            return ipConfig.equals(ipRequest);
        }
        String[] ipConfigs = ipConfig.split(splitChar);
        for (String ip : ipConfigs) {
            if (ipRequest.equals(ip)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 按规则替换参数
     * @param strWithRule  需要换参的str 如： 尊敬的客户，你的银行卡${cardNo}到账${amount}元
     * @param pBegin 参数开始标识   如：${
     * @param pEnd   参数结束标识  如：}
     * @param params 要替换的具体参数
     * @return 成功返回替换参数后字符串，失败返回null
     */
    public static  String strLoadParams(String strWithRule,String pBegin,String pEnd,Map<String,String> params){
        StringBuffer sb = new StringBuffer(strWithRule);

        int fromIndex = 0;
        try {
            while(true){
                int beginIndex = sb.indexOf(pBegin,fromIndex);
                int endIndex = sb.indexOf(pEnd,fromIndex);

                if(beginIndex == -1 || endIndex ==-1){
                    break;
                }
                if(endIndex<beginIndex){
                    return null;
                }

                String key = sb.substring(beginIndex+pBegin.length(), endIndex+1-pEnd.length());
                sb.replace(beginIndex,endIndex+1, params.get(key));
                fromIndex = beginIndex;
            }
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String msg = "尊敬的客户，你的银行卡${cardNo}到账${amount}元";
        Map<String, String> params = new HashMap<>();
        params.put("cardNo", "331");
        params.put("amount", "100");
        String s = Tools.strLoadParams(msg, "${", "}", params);
        System.out.println(s);
    }
}
