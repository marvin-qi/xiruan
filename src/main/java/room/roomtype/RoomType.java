package room.roomtype;

import utils.RequestUtils;
import utils.callback.DataUtils;
import utils.callback.ResponseUtils;

public class RoomType {

    public static void search(RoomTypeModel model, DataUtils callBack){
        RequestUtils.request(RequestUtils.RequestType.room, "SearchRoomType", "xml", getRequestXml(model), new ResponseUtils() {
            @Override
            public void onResponse(String response) {

            }
        });
    }

    public static String getRequestXml(RoomTypeModel model){
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
}
