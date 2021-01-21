package com.lyx.demo.access;

/**
 * @author Ryan
 */
public class GenericResponse<T> {

	/**
	 * 错误编码
	 */
	private String errNo = "0";

	/**
	 * 错误描述
	 */
	private String errMsg = "SUCCESS";

	/**
	 * 数据对象
	 */
	private T data;

	/**
	 * 构建成功对象
	 *
	 * @return
	 */
	public static GenericResponse<Void> success() {
		return responseOf(null);
	}

	/**
	 * 构建应答信息
	 *
	 * @param data
	 * @param <T>
	 * @return
	 */
	public static <T> GenericResponse<T> responseOf(T data) {
		return responseOf("0", "SUCCESS", data);
	}

	/**
	 * 构建应答信息
	 *
	 * @param errNo
	 * @param errMsg
	 * @return
	 */
	public static <T> GenericResponse<T> responseOf(String errNo, String errMsg) {
		return responseOf(errNo, errMsg, null);
	}

	/**
	 * 构建应答信息
	 *
	 * @param errNo
	 * @param errMsg
	 * @param data
	 * @param <T>
	 * @return
	 */
	public static <T> GenericResponse<T> responseOf(String errNo, String errMsg, T data) {
		GenericResponse<T> response = new GenericResponse<>();
		response.setErrNo(errNo);
		response.setErrMsg(errMsg);
		response.setData(data);

		return response;
	}

	public String getErrNo() {
		return errNo;
	}

	public void setErrNo(String errNo) {
		this.errNo = errNo;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
