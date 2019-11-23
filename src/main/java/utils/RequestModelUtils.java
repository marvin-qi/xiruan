package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RequestModelUtils {

    //zcgqj5owr++IX75dv87qJA==
    //DFSdGoxv8aJ3kERUuZtAaQ==
    public static final String username = "zcgqj5owr++IX75dv87qJA==";
    public static final String password = "/dQ9f2gWlyYS77LRx7+fkA==";
    public static final String cusNo = "";//协议单位号

    public static String getRequestTimeString(RequestUtils.RequestType type){
        String formatter = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat format = new SimpleDateFormat(formatter);//设置日期格式
        System.out.println(format.format(new Date()));// new Date()为获取当前系统时间
        String time = format.format(new Date());
        if (type == RequestUtils.RequestType.room) time = time.replaceAll(" ", "T");
        return time;
    }
}
