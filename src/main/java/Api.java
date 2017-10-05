import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;

public class Api {

    private String url = "https://ib.rencredit.ru/rencredit.server.portal.app/rest/public/auth/login";

    public String getErrorMessage(String username, String password) throws IOException {
        Request request = Request.Post(url);
        request.setHeader("X-XSRF-TOKEN","0f2256d8-fe5a-4b66-ba02-b032b4281b19");
        request.setHeader("Cookie","XSRF-TOKEN=0f2256d8-fe5a-4b66-ba02-b032b4281b19; JSESSIONID=0000w5cb-YqF8YGNfa0xSWqW5r3:n1");
        request.bodyString("username="+username+"&password="+password, ContentType.APPLICATION_FORM_URLENCODED);
        HttpResponse response = request.execute().returnResponse();
        String responseEntity = EntityUtils.toString(response.getEntity(), "UTF-8");
        JSONObject error = new JSONObject(responseEntity);
        String errorMsg = error.getJSONObject("errorResponseMo").getString("errorMsg");
        System.out.println(errorMsg);
        return errorMsg;
    }
}
