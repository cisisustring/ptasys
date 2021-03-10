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
 * @date 2020-11-21 15:15:06
 */
@Data
@TableName("tb_femaleinf")
public class FemaleinfEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Integer id;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 生日
	 */
	private Date birthday;
	/**
	 * 年龄
	 */
	private Integer age;
	/**
	 * 电话号码
	 */
	private Long number;
	/**
	 * 邮箱地址
	 */
	private String email;
	/**
	 * 公司
	 */
	private String company;
	/**
	 * 年龄段
	 */
	private String ageGroup;
	/**
	 * 星座
	 */
	private String constellation;
	/**
	 * 地址
	 */
	private String addr;

}
