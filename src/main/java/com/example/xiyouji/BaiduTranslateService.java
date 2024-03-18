package com.example.xiyouji;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class BaiduTranslateService implements Translator{
    @Value("${baidu.translate.appid}")
    private String appId;

    @Value("${baidu.translate.secret}")
    private String secretKey;

    private static final String TRANSLATE_URL = "https://api.fanyi.baidu.com/api/trans/vip/translate";

    public String translate(String query, String from, String to) {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> params = new HashMap<>();
        String salt = String.valueOf(new Random().nextInt());
        String sign = generateSign(query, salt);

        params.put("q", query);
        params.put("from", from);
        params.put("to", to);
        params.put("appid", appId);
        params.put("salt", salt);
        params.put("sign", sign);

        String response = restTemplate.getForObject(TRANSLATE_URL + "?q={q}&from={from}&to={to}&appid={appid}&salt={salt}&sign={sign}",
                String.class, params);
        return response; // 실제 응답 처리 로직은 여기에 구현
    }

    private String generateSign(String query, String salt) {
        String src = appId + query + salt + secretKey; // 애플리케이션 ID, 질의, 난수, 시크릿 키를 조합
        return DigestUtils.md5DigestAsHex(src.getBytes(StandardCharsets.UTF_8)).toLowerCase();
    }
}