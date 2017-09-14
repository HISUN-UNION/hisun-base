package com.hisun.base.auth.service;

import com.hisun.base.auth.vo.PasswordSecurity;
import com.hisun.base.entity.AbstractUser;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * 
 * <p>Title: TODO</p>
 * <p>Description: 密码加密加盐值</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 湖南海数互联信息技术有限公司</p>
 * @author Jason
 * @email jason4j@qq.com
 * @date 2015年3月25日 下午5:03:40 
 * @version
 */
@Service
public class PasswordHelper {

    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    private String algorithmName = "md5";
    private int hashIterations = 2;

    public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public void setHashIterations(int hashIterations) {
        this.hashIterations = hashIterations;
    }

    /**
     * 加密
     * @param user
     */
    public void encryptPassword(AbstractUser user) {

        user.setSalt(randomNumberGenerator.nextBytes().toHex());

        String newPassword = new SimpleHash(
                algorithmName,
                user.getPassword(),
                ByteSource.Util.bytes(user.getSalt()),
                hashIterations).toHex();

        user.setPassword(newPassword);
    }
    
    /**
     * 校验输入的原密码是否正确
     * @param user
     * @param confirmPassword
     * @return
     */
    public boolean credentialsPassword(AbstractUser user,String confirmPassword){
		String newCredentials = new SimpleHash(algorithmName, confirmPassword, ByteSource.Util.bytes(user.getSalt()), hashIterations).toHex();
    	return Arrays.equals(user.getPassword().getBytes(),newCredentials.getBytes());
    }

    public PasswordSecurity encryptPassword(String originalPassword){
        String salt = randomNumberGenerator.nextBytes().toHex();

        String newPassword = new SimpleHash(
                algorithmName,
                originalPassword,
                ByteSource.Util.bytes(salt),
                hashIterations).toHex();

        PasswordSecurity security = new PasswordSecurity();
        security.setPassword(newPassword);
        security.setSalt(salt);
        return security;
    }
}