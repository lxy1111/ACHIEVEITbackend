package com.apriltechnology.achieveit.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.reflection.ExceptionUtil;

import java.io.UnsupportedEncodingException;
import java.util.Date;


/**
 * @Description jwt工具类
 * @Author fjm
 * @Date 2020/3/8
 */
@Slf4j
public class JWTUtil {

    // 过期时间 24 小时
    private static final long EXPIRE_TIME = 60 * 24 * 60 * 1000;

    /**
     * 生成token
     * @param username
     * @param password
     * @return
     */
    public static String sign(String username,String password) {
        try {
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(password);
            return JWT.create()
                    .withClaim("username",username)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            log.error("sign", ExceptionUtils.getStackTrace(e));
            return null;
        }

    }


    /**
     * 校验token
     * @param token
     * @param username
     * @param password
     * @return
     */
    public static boolean verify(String token,String username,String password){

        try {
            Algorithm algorithm = Algorithm.HMAC256(password);
            JWTVerifier verifier = JWT.require(algorithm).withClaim("username",username).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (UnsupportedEncodingException e) {
            log.error("verify",ExceptionUtils.getStackTrace(e));
            return false;
        }

    }

    /**
     * 获取用户名
     * @param token
     * @return
     */
    public static String getUsername(String token){
        if(null == token || "".equals(token)){
            return null;
        }

        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();
        } catch (JWTDecodeException e) {
            log.error("getUsername",ExceptionUtils.getStackTrace(e));
            return null;
        }
    }


}
