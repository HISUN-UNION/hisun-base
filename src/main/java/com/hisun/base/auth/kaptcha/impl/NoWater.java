package com.hisun.base.auth.kaptcha.impl;

import com.google.code.kaptcha.GimpyEngine;
import com.google.code.kaptcha.util.Configurable;

import java.awt.image.BufferedImage;

/**
 * 
 * <p>Title: NoWater</p>
 * <p>Description: 验证码無模糊</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 湖南海数互联信息技术有限公司</p>
 * @author Jason
 * @email jason4j@qq.com
 * @date 2015年9月11日 上午11:22:40 
 * @version
 */
public class NoWater extends Configurable implements GimpyEngine {
	public BufferedImage getDistortedImage(BufferedImage baseImage) {
		return baseImage;
	}
}
