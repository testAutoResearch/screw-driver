package org.mirrentools.sd.templateutil;

import java.util.HashMap;

import org.mirrentools.sd.ScrewDriver;
import org.mirrentools.sd.models.SdTemplate;
import org.mirrentools.sd.options.ScrewDriverOptions;

public class FreeMarkerTest {
	public static void main(String[] args) {
		HashMap<String, SdTemplate> templates = new HashMap<String, SdTemplate>();
		templates.put("entity", new SdTemplate()
//				.setPath("D:/TempJect/freemarker")
				.setFile("JavaEntity.ftl")
				.setPackageName("entity")
				.setClassName("User"));

		// 初始化执行工具
		ScrewDriverOptions options = new ScrewDriverOptions(templates, Constant.DATABASEOPTIONS);
		options.setOutputPath("D:/TempJect/freemarker");
		ScrewDriver screwDriver = ScrewDriver.instance(options);
		screwDriver.createCode(Constant.BEAN);

	}
}