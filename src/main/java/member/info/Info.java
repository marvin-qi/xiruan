package member.info;

import utils.RequestUtils;
import utils.callback.DataUtils;
import utils.callback.ResponseUtils;

public class Info {

    public static void info(InfoModel model, DataUtils callBack){
        RequestUtils.request(RequestUtils.RequestType.member, "GetMemberInfo", "xml", getRequestXml(model), new ResponseUtils() {
            public void onResponse(String response) {

            }
        });

    }

    private static String getRequestXml(InfoModel model){
        StringBuffer buffer = new StringBuffer();
        buffer.append("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n");
        buffer.append("<Request xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n");
        buffer.append("xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" >\n");
        buffer.append("<Head>\n");
        buffer.append("<transcode>10001</transcode>\n");
        buffer.append("<reqtime>" + model.getRequestTime() + "</reqtime>\n");
        buffer.append("<systype>1003</systype>\n");
        buffer.append("<username> " + model.getUsername() + "</username>\n");
        buffer.append("<password> " + model.getPassword() + "</password>\n");
        buffer.append("</Head>\n");
        buffer.append("<Body>\n");
        buffer.append("<MemberQuery>\n");
        buffer.append("<AccountID>" + model.getAccountId() + "</AccountID>//没有openid，则取AccountID的值 卡号\n");
        buffer.append("</MemberQuery>\n");
        buffer.append("</Body>\n");
        buffer.append("</Request>");
        return buffer.toString();
    }
}
