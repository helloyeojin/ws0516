package com.myadmin.controller;

import com.myadmin.dto.Marker;
import com.myadmin.service.MarkerService;
import com.myadmin.util.GptUtil;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class RestsController {

    @Autowired
    MarkerService markerService;

    @RequestMapping("/giveid")
    public String giveid(Model model){
        String result = "";
        try {
            result = GptUtil.getResult("5-10글자 영문, 숫자 아이디를 하나만 만들려고 해. 추천해줘. " +
                    "답변은 글자만 출력해줘. 특수문자는 출력하지마. " +
                    "만약 같은 질문을 보내도 답변만 해");
        } catch(Exception e){
            result = "천천히 누르세요......";
        }
        return result;
    }

    @RequestMapping("/givemarker")
    public JSONArray givemarker(Model model) throws Exception {
        JSONArray result = new JSONArray();
        try {
            List<Marker> list = markerService.get();
            for(Marker obj : list){
                JSONObject marker = new JSONObject();
                marker.put("content", "<div>" +obj.getTitle() +"</div>");
                JSONObject latlng = new JSONObject();
                latlng.put("lat", obj.getLat());
                latlng.put("lng", obj.getLng());
                marker.put("latlng", latlng);
                result.add(marker);
            }
        } catch (Exception e) {
            throw new Exception("restcontroller marker error");
        }
        return result;
    }
//             [{ content: '<div>카카오</div>',
//                latlng: new kakao.maps.LatLng(33.450705, 126.570677) }];
}
