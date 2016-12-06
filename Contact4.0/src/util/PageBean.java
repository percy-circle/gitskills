package util;

import java.util.List;

public class PageBean<T> {

	private int current = 1;
	private int maxResult = 4;
	private int total;
	private List<T> list;

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public int getMaxResult() {
		return maxResult;
	}

	public void setMaxResult(int maxResult) {
		this.maxResult = maxResult;
	}

	public int getTotal() {
		int CountPage = total % maxResult == 0 ? total / maxResult : total / maxResult + 1;
		return CountPage;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public PageBean() {
		super();
		// TODO Auto-generated constructor stub
	}


}
