/**
 * 
 */
package com.qfedu.esys.vo;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * @author cailei
 *
 */
public class GridEuiVo<T> {
@SuppressWarnings("unused")
private final static Logger LOG = LogManager.getLogger(GridEuiVo.class);
	@SuppressWarnings("unused")
	private long total;
	
	public GridEuiVo(long total, List<T> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}

	private List<T> rows;

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}
}
