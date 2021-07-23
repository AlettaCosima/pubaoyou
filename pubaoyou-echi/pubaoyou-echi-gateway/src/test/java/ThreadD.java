import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: eric
 * @Date: 2021/7/13 16:37
 * @Version 1.0
 */
@Slf4j
public class ThreadD extends Thread {

    String humbasNo = "0001405388";

    Map<String, Object> resultData = new HashMap<String, Object>();
    HttpClient httpClient = null;
    HttpPost httpPost = null;
    String result = "";
    String jsonstr = "{\"service\":\"https://mp.fsgplus.com/\",\"tgtId\":\"TGT-27554-AX6zxa7B4clYla2bedGso1WghSNTofkLf200KNFxFUkIm5LNRW-cas01.example.org\"}";


    public static String accese_token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzeXNDb2RlIjoiNWMyNWZiZTdlIiwiY2xpZW50SWQiOiJmNjhmZGZiYzMiLCJpc3MiOiJpYW0tc2VydmljZSIsImNsaWVudFNlY3JldCI6ImIwYmYxOTUwYTMxZTQ3ZDNhOGE4ZmZjNmY5MGFhZGRkIiwiZXhwIjoxNjI2MjQ5NTU4LCJpYXQiOjE2MjYxNjMxNTgsImp0aSI6Ijg0NDgxYmQ3LTRhOWEtNDg3ZS1hZGFkLTY5OGJjMDU4ZGY2MyJ9.WvsMf5TvAHQFrBAHX8KfXY1bLojAa9ayXxHOQs7ZjBw";

    @Override
    public void run() {

        try{
            httpClient = new SSLClient();
            httpPost = new HttpPost("http://gateway.fsgplus.inner/cas/v1/tickets/getST");
            httpPost.addHeader("Content-Type", "application/json;charset=utf-8");
            httpPost.addHeader("sysCode", "5c25fbe7e");
            httpPost.addHeader("access_token", accese_token);

            StringEntity se = new StringEntity(jsonstr, "utf-8");
            se.setContentType("text/json");
            se.setContentEncoding(new BasicHeader("Content-Type", "application/json;charset=utf-8"));
            httpPost.setEntity(se);
            HttpResponse response = httpClient.execute(httpPost);
            if (response != null) {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    result = EntityUtils.toString(resEntity, "utf-8");
                    Gson gson = new Gson();
                    resultData = gson.fromJson(result, Map.class);
                }
                Map<String, String> m2 = new HashMap<String, String>();
                m2.put("service", "https://mp.fsgplus.com/");
                m2.put("ticket", resultData.get("stId").toString());
                httpPost = new HttpPost("http://gateway.fsgplus.inner/cas/v1/tickets/validateService");
                httpPost.addHeader("Content-Type", "application/json;charset=utf-8");
                httpPost.addHeader("sysCode", "5c25fbe7e");
                httpPost.addHeader("access_token", accese_token);

                try {
                    System.out.println("STID:++++++"+resultData.get("stId"));
                    String jsonstr1 = "{\"service\":\"https://mp.fsgplus.com/\",\"ticket\":\""+resultData.get("stId")+"\"}";
                    se = new StringEntity(jsonstr1, "utf-8");
                    se.setContentType("text/json");
                    se.setContentEncoding(new BasicHeader("Content-Type", "application/json;charset=utf-8"));
                    httpPost.setEntity(se);
                    response = httpClient.execute(httpPost);
                    /* 若状态码为200 ok */
                    if (response.getStatusLine().getStatusCode() == 200) {
                        /* 取出响应字符串 */
                        result = EntityUtils.toString(response.getEntity(), "UTF-8");
                        Gson gson = new Gson();
                        resultData = gson.fromJson(result, Map.class);
                        Map<String, String> item = (Map<String, String>) resultData.get("attributes");
                        if(!item.get("userId").equals(humbasNo)){
                            System.out.println("error"+item.get("userId"));
                        }

                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }


    }
}
