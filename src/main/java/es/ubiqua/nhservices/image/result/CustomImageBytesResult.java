package es.ubiqua.nhservices.image.result;

import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import es.ubiqua.nhservices.image.action.ImageAction;

public class CustomImageBytesResult implements Result {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void execute(ActionInvocation invocation) throws Exception {
 
		ImageAction action = (ImageAction) invocation.getAction();
		HttpServletResponse response = ServletActionContext.getResponse();

		response.setContentType(action.getCustomContentType());
		response.getOutputStream().write(action.getCustomImageInBytes());
		response.getOutputStream().flush();
		
	}

}