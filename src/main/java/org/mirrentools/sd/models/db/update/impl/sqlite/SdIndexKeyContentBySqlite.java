package org.mirrentools.sd.models.db.update.impl.sqlite;

import org.mirrentools.sd.common.SdUtil;
import org.mirrentools.sd.models.db.update.SdBasicIndexKeyContent;

/**
 * 索引属性SQLite版实现
 * 
 * @author <a href="http://mirrentools.org">Mirren</a>
 *
 */
public class SdIndexKeyContentBySqlite extends SdBasicIndexKeyContent {

	@Override
	public String createSQL() {
		StringBuilder result = new StringBuilder();
		result.append(" CREATE ");
		if (isUnique()) {
			result.append(" UNIQUE ");
		}
		result.append(" INDEX ");
		result.append(" IF NOT EXISTS ");
		result.append(getName());
		result.append(" ON ");
		result.append(getTable());
		result.append(" ( ");
		result.append(SdUtil.join(getColumns(), ","));
		result.append(" ); ");
		return result.toString();
	}

	@Override
	public String deleteSQL() {
		return " DROP INDEX " + getRemoveIndexName();
	}

}
