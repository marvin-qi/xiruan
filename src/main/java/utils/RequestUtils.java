package utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import utils.callback.ResponseUtils;

import java.io.IOException;
import java.nio.charset.Charset;

public class RequestUtils {

    public enum RequestType{member, room};

    private static String MEMBER_HOST = "http://x60301.itf.foxhis.com/PMSDataInterface/MemberService/";
    private static String ROOM_HOST = "http://x60301.itf.foxhis.com/PMSDataInterface/ReservationService/";

    public static void request(RequestType type, String actionName,String xmlName, String xml, ResponseUtils callBack){
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(type == RequestType.member ? MEMBER_HOST : ROOM_HOST);
        post.setHeader("Content-Type", "text/xml; charset=utf-8");
        String header = "IMemberService";
        if (type == RequestType.room) header = "IReservationService";
        header = header + "/" + actionName;
        post.setHeader("SOAPAction", "http://tempuri.org/" + header);
        String params = XMLUtils.requestXml(xmlName, actionName, xml);
        System.out.println(params);
        post.setEntity(new StringEntity(params, Charset.defaultCharset()));
        HttpResponse response = null;
        try {
            response = client.execute(post);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String resp = EntityUtils.toString(entity);
                resp = resp.replaceAll("&lt;", "<");
                resp = resp.replaceAll("&gt;", ">");
                System.out.println(resp);
                if (null != callBack){
                    callBack.onResponse(resp);
                }
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("REQUEST FINISHED");
        }
    }

}
