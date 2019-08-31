package org.mirrentools.sd.models.db.update.impl.db2;

import org.apache.commons.lang.StringUtils;
import org.mirrentools.sd.models.db.update.SdAbstractPrimaryKeyContent;

public class SdPrimaryKeyContentByDB2 extends SdAbstractPrimaryKeyContent {
	@Override
	public String createSQL() {
		return "ALTER TABLE "+getSchema()+"."+getTable() +" ADD constraint "+getName()+" primary key("+	StringUtils.join(getColumns(),",")+")";
	}
	@Override
	public String updateSQL() {
		return deleteSQL() + " , " + createSQL();
	}
	@Override
	public String deleteSQL() {
		return " DROP PRIMARY KEY";
	}
}
