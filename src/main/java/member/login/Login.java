package member.login;


import utils.RequestUtils;
import utils.callback.DataUtils;
import utils.callback.ResponseUtils;

public class Login {

    public static void login(LoginModel model, DataUtils callBack){
        String params = getRequestXml(model);
        RequestUtils.request(RequestUtils.RequestType.member, "UserLogin", "loginXml", params, new ResponseUtils() {
            @Override
            public void onResponse(String response) {
                if (response.contains("<retcode>00001</retcode>")){
                    int start = response.indexOf("<Descript>");
                    int end = response.indexOf("</Descript>");
                    String cardNo = response.substring(start + 10, end);
                    if (null != callBack){
                        callBack.onSuccess(cardNo);
                    }
                }else {
                    int start = response.indexOf("<retmsg>");
                    int end = response.indexOf("</retmsg>");
                    String msg = response.substring(start + 8, end);
                    if (null != callBack){
                        callBack.onFailure(msg);
                    }
                }
            }
        });
    }

    private static String getRequestXml(LoginModel model){
        StringBuffer buffer = new StringBuffer();
        buffer.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
        buffer.append("<Request>\n");
        buffer.append("<Head>\n");
        buffer.append("<transcode>10</transcode>\n");
        buffer.append("<reqtime>" + model.getRequestTime() + "</reqtime>\n");
        buffer.append("<systype>1001</systype>\n");
        buffer.append("<username> " + model.getUsername() + "</username>\n");
        buffer.append("<password> " + model.getPassword() + "</password>\n");
        buffer.append("</Head>\n");
        buffer.append("<Body>\n");
        buffer.append("<LoginObject>\n");
        buffer.append("<ID>" + model.getId() + "</ID> //卡号\n");
        buffer.append("<Password>" + model.getUserPassword() + "</Password> //密码\n");
        buffer.append("<Logintype>" + model.getCardType() + "</Logintype>  //登录方式 LOG_CARD(卡号)\n");
        buffer.append("<Cardtype>1</Cardtype> //卡类别\n");
        buffer.append("</LoginObject>\n");
        buffer.append("</Body>\n");
        buffer.append("</Request>");
        return buffer.toString();
    }
}
