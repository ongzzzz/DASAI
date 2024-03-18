package com.example.xiyouji;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TranslateController {

    private final BaiduTranslateService baiduTranslateService;



    @GetMapping("/translate/en")
    public String translate_en() throws JsonProcessingException {
        String jsonStr = baiduTranslateService.translate("你好", "zh", "kor");
        ParseJson parseJson = new ParseJson(jsonStr);


        System.out.println(parseJson.parse()); // 출력: 안녕하세요.
        return parseJson.parse();
    }

}
