package cn.bdqn.util;

/**
 * ��ҳ�Ĺ�����
 */
public class PageUtil {
	private int totalCount;// �ܼ�¼�� ͨ��sql�����ݿ��л�ȡ
	private int pageSize = 3;// ҳ��С ÿҳ��ʾ������
	private int pageCount;// ��ҳ��
	private int pageIndex;// ��ǰҳ

	public int getTotalCount() {
		return totalCount;
	}

	/**�����ڻ�ȡ�ܼ�¼��֮�󣬿϶����Եó� ��ҳ��
	 * 001.�ܼ�¼��ͨ��sql�����ݿ��л�ȡ
	 * 002.��Ԫ���ʽ �����ж� ����ֵ��ҳ��pageCount
	 * 
	 * ��ҳ��=(�ܼ�¼��%ҳ��С==0)?(�ܼ�¼��/ҳ��С):(�ܼ�¼��/ҳ��С+1);
	 * 
	 * @param totalCount �ܼ�¼��
	 */
	public void setTotalCount(int totalCount) {
		if (totalCount > 0) {
			this.totalCount = totalCount;
			this.pageCount = (totalCount % pageSize == 0) ? (totalCount / pageSize)
					: (totalCount / pageSize + 1);// ��ҳ��
		}
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public PageUtil(int totalCount, int pageSize, int pageCount, int pageIndex) {
		super();
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.pageCount = pageCount;
		this.pageIndex = pageIndex;
	}

	public PageUtil() {
		super();
	}

	@Override
	public String toString() {
		return "PageUtil [totalCount=" + totalCount + ", pageSize=" + pageSize
				+ ", pageCount=" + pageCount + ", pageIndex=" + pageIndex + "]";
	}

}
