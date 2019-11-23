package utils;

public class XMLUtils {

    public static String requestXml(String xmlName, String name, String xml){
        StringBuffer buffer = new StringBuffer();
        buffer.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">");
        buffer.append("<soapenv:Header/>\n");
        buffer.append("<soapenv:Body>\n");
        buffer.append("<tem:" + name + ">");
        buffer.append("<tem:" + xmlName + ">" + "<![CDATA[" + xml + "]]></tem:" + xmlName + ">");
        buffer.append("</tem:" + name + ">");
        buffer.append("</soapenv:Body>");
        buffer.append("</soapenv:Envelope>");
        return buffer.toString();
    }

}
