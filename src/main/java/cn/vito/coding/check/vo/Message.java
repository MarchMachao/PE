package cn.vito.coding.check.vo;

public class Message {

	private boolean isSuccess;
	private Object content;

	public Message(boolean isSuccess, Object content) {
		super();
		this.isSuccess = isSuccess;
		this.content = content;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Message [isSuccess=" + isSuccess + ", content=" + content + "]";
	}

}
