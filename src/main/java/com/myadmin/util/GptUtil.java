package com.myadmin.util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GptUtil {
    private static final String API_KEY = "";
    private static final String API_ENDPOINT = "https://api.openai.com/v1/chat/completions";

    public static String getResult(String msg) throws URISyntaxException, IOException, InterruptedException, ParseException {
        String result = "";
        HttpClient client = HttpClient.newHttpClient();
        //OpenAI API에 요청을 보낼 http객체를 생성

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(API_ENDPOINT))
                //요청보낼 URI를 먼저 넣는다.
                .header("Content-Type", "application/json")
                //헤더에 요청보내는 형식이 json임을 설정.
                .header("Authorization", "Bearer " + API_KEY)
                //헤더에 권한이 있음을 api key로 증빙함.
                .POST(HttpRequest.BodyPublishers.ofString("{\"model\":\"gpt-3.5-turbo\"" +
                        ",\"messages\":[{\"role\":\"system\",\"content\":\"You are a helpful assistant.\"}" +
                        ",{\"role\":\"user\",\"content\":\"" + msg + "\"}]}"))
                //본문을 작성할 거야. model, message, role, content를 보내는데 매개변수 msg가 들어간다.
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        //만들어진 http request를 send로 보낸다. send의 두번째 매개변수는 응답본문을 문자열로 바꾸는 bodyHandler를 생성하는 메서드
        String responseBody = response.body();
        result = GptUtil.getData(responseBody);
        System.out.println(result.toString());
        client = null;
        return result;
    }

    public static String getData(String str) throws ParseException {
        JSONParser jsonParser = new JSONParser();
        //string은 파싱이 안되므로 jsonParser를 이용하여 캐스팅함.
        JSONObject json = (JSONObject)jsonParser.parse(str);
        JSONArray choices = (JSONArray) json.get("choices");
        JSONObject obj = (JSONObject) choices.get(0);
        JSONObject message = (JSONObject) obj.get("message");
        String result = message.get("content").toString();
        return result;
    }
}
