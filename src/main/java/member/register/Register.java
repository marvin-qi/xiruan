package member.register;

import utils.RequestUtils;
import utils.callback.DataUtils;
import utils.callback.ResponseUtils;

public class Register {
    public static void request(RegisterModel params, final DataUtils callBack){
        RequestUtils.request(RequestUtils.RequestType.member,"Register", "xml", getRequestXml(params), new ResponseUtils() {
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
    private static String getRequestXml(RegisterModel model){
        StringBuffer buffer = new StringBuffer();
        buffer.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
        buffer.append("<Request xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n");
        buffer.append("xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
        buffer.append("<Head>\n");
        buffer.append("<transcode>10</transcode>\n");
        buffer.append("<reqtime>" + model.getRequestTime() +"</reqtime>\n");
        buffer.append("<systype>1002</systype>\n");
        buffer.append("<username> " + model.getUsername() + "</username>\n");
        buffer.append("<password> " + model.getPassword() + "</password>\n");
        buffer.append("</Head>\n");
        buffer.append("<Body>\n");
        buffer.append("<Profile profileType=\"GUEST\" gender=\"" + model.getGender() + "\">\n");
        buffer.append("<IndividualName>\n");
        buffer.append("<nameTitle>" + model.getNameTitle() + "</nameTitle>\n");
        buffer.append("<nameFirst>" + model.getNameFirst() + "</nameFirst>\n");
        buffer.append("<nameSur>" + model.getNameLast() + "</nameSur>\n");
        buffer.append("</IndividualName>\n");
        buffer.append("<primaryLanguageID>C</primaryLanguageID>\n");
        buffer.append("<Memberships>\n");
        buffer.append("<Membership>\n");
        buffer.append("<programCode>1</programCode>\n");
        buffer.append("<VipTag>" + model.getVipTag() + "</VipTag>\n");
        buffer.append("<programType>" + model.getProgramType() + "</programType>\n");
        buffer.append("<password>" + model.getUserPassword() + "</password>\n");
        buffer.append("<accountSno>" + model.getAccountSno() + "</accountSno>\n");
        buffer.append("</Membership>\n");
        buffer.append("</Memberships>\n");
        buffer.append("<PhoneNumbers>\n");
        buffer.append("<PhoneNumber phoneNumberType=\"HOME\">\n");
        buffer.append("<phoneNumber>" + model.getPhoneNumber() + "</phoneNumber>\n");
        buffer.append("<mfPrimaryYN>Y</mfPrimaryYN>");
        buffer.append("</PhoneNumber>\n");
        buffer.append("</PhoneNumbers>\n");
        buffer.append("</Profile>\n");
        buffer.append("</Body>\n");
        buffer.append("</Request>");
        return buffer.toString();
    }
}
