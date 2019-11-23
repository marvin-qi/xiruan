package room.roomtype;

import utils.RequestUtils;
import utils.callback.DataUtils;
import utils.callback.ResponseUtils;

import java.util.ArrayList;
import java.util.List;

public class RoomType {

    public static void search(RoomTypeModel model, DataUtils callBack){
        RequestUtils.request(RequestUtils.RequestType.room, "SearchRoomType", "xml", getRequestXml(model), new ResponseUtils() {
            public void onResponse(String response) {
                if (response.contains("<retcode>0</retcode>")){
                    int start = response.indexOf("<ResponseBodyRmtype>");
                    int end = response.indexOf("</ResponseBodyRmtype>");
                    String data = response.substring(start + 20, end);
                    if (null != callBack){
                        callBack.onSuccess(unzip(data));
                    }
                }else {
                    if (null != callBack){
                        callBack.onFailure("获取房型失败");
                    }
                }
            }
        });
    }

    private static String getRequestXml(RoomTypeModel model){
        StringBuffer buffer = new StringBuffer();
        buffer.append("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n");
        buffer.append("<Request>\n");
        buffer.append("<Head>\n");
        buffer.append("<transcode>10</transcode>\n");
        buffer.append("<reqtime>" + model.getRequestTime() + "</reqtime>\n");
        buffer.append("<systype>1017</systype>\n");
        buffer.append("<username> " + model.getUsername() + "</username>\n");
        buffer.append("<password> " + model.getPassword() + "</password>\n");
        buffer.append("</Head>\n");
        buffer.append("<Body>\n");
        buffer.append("</Body>\n");
        buffer.append("</Request>");
        return buffer.toString();
    }

    private static List<RoomTypeResponseModel> unzip(String xml){
        String[] rooms = xml.split("</Rmtype>");
        List<String> rms = new ArrayList<>();
        for (int i = 0; i < rooms.length; i++) {
            String sub_xml = rooms[i];
            if (sub_xml.contains("<Rmtype>")){
                sub_xml = rooms[i].replaceAll("<Rmtype>", "");
                rms.add(sub_xml);
            }
        }
        List<RoomTypeResponseModel> roomModels = new ArrayList<>();
        for (String room : rms) {
            int start = room.indexOf("<rmtype>");
            int end = room.indexOf("</rmtype>");
            String rmtype = room.substring(start + 8, end);
            start = room.indexOf("<descript>");
            end = room.indexOf("</descript>");
            String chinese = room.substring(start + 10, end);
            start = room.indexOf("<descript1>");
            end = room.indexOf("</descript1>");
            String english = room.substring(start + 11, end);
            RoomTypeResponseModel model = new RoomTypeResponseModel();
            model.setRmtype(rmtype);
            model.setDescript(chinese);
            model.setDescript1(english);
            roomModels.add(model);
        }
        return roomModels;
    }

}
