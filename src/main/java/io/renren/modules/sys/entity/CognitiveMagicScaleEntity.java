package io.renren.modules.sys.entity;

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
 * @date 2020-12-19 17:40:11
 */
@Data
@TableName("tb_cognitive_magic_scale")
public class CognitiveMagicScaleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 用户
	 */
	private String username;
	/**
	 * 推荐人
	 */
	private String recommender;
	/**
	 * 提交时间
	 */
	private String createTime;
	/**
	 * 用户ip
	 */
	private String ipAddress;
	/**
	 * 果断
	 */
	private Integer i1;
	/**
	 * 分析
	 */
	private Integer i2;
	/**
	 * 创意
	 */
	private Integer i3;
	/**
	 * 理想
	 */
	private Integer i4;
	/**
	 * 掌控
	 */
	private Integer i5;
	/**
	 * 事物
	 */
	private Integer i6;
	/**
	 * 感觉
	 */
	private Integer i7;
	/**
	 * 人际
	 */
	private Integer i8;
	/**
	 * 外向
	 */
	private Integer extroversion;
	/**
	 * 内向
	 */
	private Integer diffidence;
	/**
	 * 理性
	 */
	private Integer reason;
	/**
	 * 感性
	 */
	private Integer sensibility;
	/**
	 * 行动
	 */
	private Integer behavior;
	/**
	 * 思考
	 */
	private Integer consider;
	/**
	 * 理智
	 */
	private Integer intellect;
	/**
	 * 开创
	 */
	private Integer initiate;
	/**
	 * 组织
	 */
	private Integer organization;
	/**
	 * 情感
	 */
	private Integer emotion;
	/**
	 * 用户设备
	 */
	private String useragent;

}
