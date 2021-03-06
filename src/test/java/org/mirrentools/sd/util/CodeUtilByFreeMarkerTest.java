package org.mirrentools.sd.util;

import java.util.Map;

import org.mirrentools.sd.ScrewDriverCode;
import org.mirrentools.sd.constant.CommonConstant;
import org.mirrentools.sd.constant.MySqlConstant;
import org.mirrentools.sd.impl.ScrewDriverCodeImpl;
import org.mirrentools.sd.models.SdBean;
import org.mirrentools.sd.models.SdTemplate;
import org.mirrentools.sd.options.ScrewDriverOptions;

/**
 * FreeMarker模板生成文件的测试
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class CodeUtilByFreeMarkerTest {
	public static void main(String[] args) {
		// 创建一个实体描述
		SdBean bean = MySqlConstant.studentBean;
		// 设置实体生成模板
		Map<String, SdTemplate> templates = CommonConstant.templates;

		// 初始化代码执行生成工具
		ScrewDriverCode codeUtil = new ScrewDriverCodeImpl(new ScrewDriverOptions(templates, MySqlConstant.databaseOptions));
		codeUtil.execute(bean);
	}
}
