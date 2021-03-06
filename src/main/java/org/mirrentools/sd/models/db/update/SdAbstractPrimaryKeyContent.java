package org.mirrentools.sd.models.db.update;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 抽象主键属性,用于新建与修改
 * 
 * @author <a href="http://szmirren.com">Mirren</a>
 *
 */
public abstract class SdAbstractPrimaryKeyContent {
	/** 主键的名字 */
	private String name;
	/** 索引的注释 */
	private String remark;
	/** 主键的列名 */
	private List<String> columns;
	/** 拓展属性 */
	private Map<String, Object> extensions;
	/** 模式 */
	private String schema;
	/** 表 */
	private String table;
	/**
	 * 创建的SQL语句
	 * 
	 * @return
	 */
	public abstract String createSQL();

	/**
	 * 修改的SQL语句,仅可以添加或删除
	 * 
	 * @return
	 */
	public abstract String updateSQL();

	/**
	 * 删除的SQL语句
	 * 
	 * @return
	 */
	public abstract String deleteSQL();

	/**
	 * 转换拓展字段,该方法用户转换拓展字段,如果基础的getBasicSQL方法可以用但是需要用到拓展字段时可以重写该方法,给方法的内容如果不为空会被追加到最后
	 * 
	 * @return
	 */
	public String converterExtensions() {
		return null;
	}

	/**
	 * 获取主键的名字
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置主键的名字
	 * 
	 * @param name
	 */
	public SdAbstractPrimaryKeyContent setName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * 获取主键的注释
	 * 
	 * @return
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 设置主键的注释
	 * 
	 * @param remark
	 * @return
	 */
	public SdAbstractPrimaryKeyContent setRemark(String remark) {
		this.remark = remark;
		return this;
	}

	/**
	 * 获取主键列
	 * 
	 * @return
	 */
	public List<String> getColumns() {
		return columns;
	}

	/**
	 * 添加主键列
	 * 
	 * @param column
	 */
	public SdAbstractPrimaryKeyContent addColumn(String column) {
		if (getColumns() == null) {
			setColumns(new ArrayList<String>());
		}
		getColumns().add(column);
		return this;
	}

	/**
	 * 设置主键列
	 * 
	 * @param columns
	 */
	public SdAbstractPrimaryKeyContent setColumns(List<String> columns) {
		this.columns = columns;
		return this;
	}

	/**
	 * 获得拓展属性
	 * 
	 * @return
	 */
	public Map<String, Object> getExtensions() {
		return extensions;
	}

	/**
	 * 获得拓展属性值
	 * 
	 * @return
	 */
	public Object getExtension(String key) {
		return getExtensions().get(key);
	}

	/**
	 * 添加附加属性
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public SdAbstractPrimaryKeyContent addExtension(String key, Object value) {
		if (getExtensions() == null) {
			setExtensions(new LinkedHashMap<String, Object>());
		}
		getExtensions().put(key, value);
		return this;
	}

	/**
	 * 设置附加属性
	 * 
	 * @param extensions
	 * @return
	 */
	public SdAbstractPrimaryKeyContent setExtensions(Map<String, Object> extensions) {
		this.extensions = extensions;
		return this;
	}
	/**
	 * 获取索引的模式
	 * 
	 * @return
	 */
	public String getSchema() {
		return schema;
	}
	/**
	 * 设置索引模式
	 * 
	 * @param columns
	 */
	public SdAbstractPrimaryKeyContent setSchema(String schema) {
		this.schema = schema;
		return this;
	}
	/**
	 * 获取索引的表
	 * 
	 * @return
	 */
	public String getTable() {
		return table;
	}
	/**
	 * 设置索引的表
	 * 
	 * @param columns
	 */
	public SdAbstractPrimaryKeyContent setTable(String table) {
		this.table = table;
		return this;
		
	}


	@Override
	public String toString() {
		return "SdAbstractPrimaryKeyContent [name=" + name + ", remark=" + remark + ", columns=" + columns + ", extensions="
				+ extensions + ", schema=" + schema + ", table=" + table + "]";
	}

}
