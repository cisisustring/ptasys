package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author Reed
 * @email 271203819@qq.com
 * @date 2020-11-17 22:44:46
 */
@Data
@TableName("tb_loginidentifycode")
public class LoginidentifycodeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private String code;
	/**
	 * 
	 */
	private String phone;
	/**
	 * 
	 */
	private String phonekey;
	/**
	 * 
	 */
	private String password;
	/**
	 * 
	 */
	private Integer userid;
	/**
	 * 
	 */
	private String openid;
	/**
	 * 1:原生 2:QQ 3:微信 4: 微博
	 */
	private Integer platformtype;
	/**
	 * 1:win 2:mac 17:ios 18:android
	 */
	private Integer clienttype;
	/**
	 * 
	 */
	private Integer created;
	/**
	 * 
	 */
	private Integer logintime;
	/**
	 * 0:注册 1:忘记密码
	 */
	private Integer type;
	/**
	 * 验证码错误次数限制，最多5次
	 */
	private Integer tries;

}
