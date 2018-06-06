package com.example.demo.handler.util;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/**
 * 校验和生成jwt token
 * Created by PengHongfu 2018-06-01 11:00
 */

public class JwtUtil {
    static final String SECRET = "ThisIsASecret";
    // 过期时间5分钟  24 hour 60 * 60 * 1000 * 24
    private static final long EXPIRE_TIME = 5 * 60 * 1000;

    /*
        当用户更改密码时，记录更改密码时间，和令牌创建时间对比，
     */
    public static String generateToken(String username) {
        HashMap<String, Object> map = new HashMap<>();
        //you can put any data in the map
        map.put("username", username);
        map.put("iat",System.currentTimeMillis()/ 1000);//创建时间
        String jwt = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setClaims(map)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        return "Bearer " + jwt; //jwt前面一般都会加Bearer
    }

    public static void validateToken(String token) {
        try {
            // parse the token.会判断
            Map<String, Object> body = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace("Bearer ", ""))
                    .getBody();

        } catch (Exception e) {
            throw new IllegalStateException("Invalid Token. " + e.getMessage());
        }
    }
}