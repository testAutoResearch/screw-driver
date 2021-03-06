package org.mirrentools.sd.options;

import java.util.LinkedHashMap;
import java.util.Map;

import org.mirrentools.sd.common.SdUtil;

/**
 * 数据库连接的配置文件
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public class SdDatabaseOptions {
	/** 模式的连接超时时间 */
	public static final int DEFAULT_LOGIN_TIMEOUTS_SECONDS = 60;

	/** 连接超时时间 单位秒 */
	private int loginTimeout = DEFAULT_LOGIN_TIMEOUTS_SECONDS;
	/** 数据库驱动 */
	private String driverClass;
	/** 数据库连接地址 */
	private String url;
	/** 数据库连接用户 */
	private String user;
	/** 数据库连接密码 */
	private String password;
	/** 模式 */
	private String schema;
	/** 拓展属性 */
	private Map<String, Object> extensions;

	/**
	 * 初始化一个数据库配置
	 * 
	 * @param driverClass
	 *          驱动类
	 * @param url
	 *          完整的数据库连接地址
	 */
	public SdDatabaseOptions(String driverClass, String url) {
		super();
		this.driverClass = driverClass;
		this.url = url;
	}

	/**
	 * 初始化一个数据库配置
	 * 
	 * @param driverClass
	 *          驱动类
	 * @param url
	 *          完整的数据库连接地址
	 * @param user
	 *          用户名
	 * @param password
	 *          密码
	 */
	public SdDatabaseOptions(String driverClass, String url, String user, String password) {
		super();
		this.driverClass = driverClass;
		this.url = url;
		this.user = user;
		this.password = password;
	}

	/**
	 * 初始化一个数据库配置
	 * 
	 * @param loginTimeout
	 *          请求连接数据库超时时间,单位秒
	 * @param driverClass
	 *          驱动类
	 * @param url
	 *          完整的数据库连接地址
	 * @param user
	 *          用户名
	 * @param password
	 *          密码
	 */
	public SdDatabaseOptions(int loginTimeout, String driverClass, String url, String user, String password) {
		super();
		this.loginTimeout = loginTimeout;
		this.driverClass = driverClass;
		this.url = url;
		this.user = user;
		this.password = password;
	}

	/**
	 * 获取连接超时的时间,单位秒
	 * 
	 * @return
	 */
	public int getLoginTimeout() {
		return loginTimeout;
	}

	/**
	 * 设置连接超时的时间,单位秒
	 * 
	 * @param loginTimeout
	 * @return
	 */
	public SdDatabaseOptions setLoginTimeout(int loginTimeout) {
		this.loginTimeout = loginTimeout;
		return this;
	}

	/**
	 * 获取数据库连接驱动
	 * 
	 * @return
	 */
	public String getDriverClass() {
		return driverClass;
	}

	/**
	 * 设置数据库连接驱动
	 * 
	 * @param driverClass
	 * @return
	 */
	public SdDatabaseOptions setDriverClass(String driverClass) {
		this.driverClass = driverClass;
		return this;
	}

	/**
	 * 获取数据库连接语句
	 * 
	 * @return
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 设置数据库连接语句
	 * 
	 * @param url
	 * @return
	 */
	public SdDatabaseOptions setUrl(String url) {
		this.url = url;
		return this;
	}

	/**
	 * 获取数据库连接用户名
	 * 
	 * @return
	 */
	public String getUser() {
		return user;
	}

	/**
	 * 设置数据库连接用户名
	 * 
	 * @param user
	 * @return
	 */
	public SdDatabaseOptions setUser(String user) {
		this.user = user;
		return this;
	}

	/**
	 * 获取用户密码
	 * 
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 设置用户密码
	 * 
	 * @param password
	 * @return
	 */
	public SdDatabaseOptions setPassword(String password) {
		this.password = password;
		return this;
	}

	/**
	 * 获取模式
	 * 
	 * @return
	 */
	public String getSchema() {
		return schema;
	}

	/**
	 * 设置模式
	 * 
	 * @param schema
	 * @return
	 */
	public SdDatabaseOptions setSchema(String schema) {
		this.schema = schema;
		return this;
	}

	/**
	 * 获得拓展属性值
	 * 
	 * @return
	 */
	public Object getExtension(String key) {
		if (SdUtil.isNullOrEmpty(getExtensions())) {
			return null;
		}
		return getExtensions().get(key);
	}

	/**
	 * 添加附加属性
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public SdDatabaseOptions addExtension(String key, Object value) {
		if (getExtensions() == null) {
			setExtensions(new LinkedHashMap<String, Object>());
		}
		this.extensions.put(key, value);
		return this;
	}

	/**
	 * 获取拓展属性
	 * 
	 * @return
	 */
	public Map<String, Object> getExtensions() {
		return extensions;
	}

	/**
	 * 设置拓展属性
	 * 
	 * @param extensions
	 * @return
	 */
	public SdDatabaseOptions setExtensions(Map<String, Object> extensions) {
		this.extensions = extensions;
		return this;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("SdDatabaseOptions:" + "\n");
		result.append("  ┣━loginTimeout= " + getLoginTimeout() + "\n");
		result.append("  ┣━driverClass= " + getDriverClass() + "\n");
		result.append("  ┣━url= " + getUrl() + "\n");
		result.append("  ┣━schema= " + getSchema() + "\n");
		result.append("  ┣━user= " + getUser() + "\n");
		result.append("  ┣━password= " + getPassword() + "\n");
		result.append("  ┗━extensions= " + getExtensions());
		return result.toString();
	}

}
