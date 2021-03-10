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
 * @date 2020-11-19 17:32:54
 */
@Data
@TableName("tb_businesslog")
public class BusinesslogEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 创建时间
	 */
	private Long created;
	/**
	 * 花费时间
	 */
	private Long time;
	/**
	 * 源代码class路径名称
	 */
	private String classname;
	/**
	 * controller函数名
	 */
	private String methodname;
	/**
	 * 提交的参数
	 */
	private String params;
	/**
	 * 用户IP
	 */
	private String userip;
	/**
	 * 用户UserAgent
	 */
	private String useragent;
	/**
	 * get和post提交
	 */
	private String method;
	/**
	 * controller访问路径
	 */
	private String uri;
	/**
	 * 完整路径
	 */
	private String url;
	/**
	 * 主机地址和端口
	 */
	private String domain;

}
