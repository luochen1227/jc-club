package com.jingdianjichi.wx.controller;

import com.jingdianjichi.wx.utils.SHA1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class CallBackController {
    private static final String token = "123";

    @RequestMapping("/text")
    public String test() {
        return "suc";
    }

    /**
     * @param signature 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
     * @param timestamp 时间戳
     * @param nonce     随机数
     * @param echostr   随机字符串
     * @return String
     * @description 回调消息校验
     * @date 2024/4/11 21:16
     * @author 坤
     */
    @GetMapping("/callback")
    public String callBack(@RequestParam("signature") String signature,
                           @RequestParam("timestamp") String timestamp,
                           @RequestParam("nonce") String nonce,
                           @RequestParam("echostr") String echostr) {
        log.info("get验签请求参数：signature：{}，timestamp:{}，nonce:{}，echostr:{}",
                signature, timestamp, nonce, echostr);
        String shaStr = SHA1.getSHA1(token, timestamp, nonce, "");
        if (signature.equals(shaStr)) {
            return echostr;
        }
        return "unknown";
    }

    @PostMapping(value = "/callback",produces = "application/xml;charset=UTF-8")
    public String callBack(
            @RequestBody String requestBody,
            @RequestParam("signature") String signature,
            @RequestParam("timestamp") String timestamp,
            @RequestParam("nonce") String nonce,
            @RequestParam(value = "msg_signature",required = false) String msgSignature) {
        log.info("get验签请求参数：requestBody：{}，signature：{}，timestamp:{}，nonce:{}，echostr:{}",requestBody,
                signature, timestamp, nonce);
        System.out.println(requestBody);
        return "unknown";
    }
}
