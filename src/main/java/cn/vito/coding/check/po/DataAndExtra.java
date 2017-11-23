package cn.vito.coding.check.po;

public class DataAndExtra {

	private Data data;
	private Extras extras;

	public DataAndExtra() {
	}

	public DataAndExtra(Data data, Extras extras) {
		this.data = data;
		this.extras = extras;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public Extras getExtras() {
		return extras;
	}

	public void setExtras(Extras extras) {
		this.extras = extras;
	}

	@Override
	public String toString() {
		return "DataAndExtra [data=" + data + ", extras=" + extras + "]";
	}

}
