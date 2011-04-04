package cn.edu.nju.software.timemachine.invocation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


public class LoginFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hRequest = (HttpServletRequest) request;
		String uri = hRequest.getRequestURI();
		ArrayList<String> excludePages = new ArrayList<String>();
		excludePages.add("/timemachine4/index.html");
		excludePages.add("/timemachine4/css/style.css");
		excludePages.add("/timemachine4/js/jquery-1.4.2.min.js");
		excludePages.add("/timemachine4/js/slider.js");
		excludePages.add("/timemachine4/js/jquery.bgiframe-2.1.2.js");
		excludePages.add("/timemachine4/js/jquery.ui.core.js");
		excludePages.add("/timemachine4/js/jquery.ui.dialog.js");
		excludePages.add("/timemachine4/js/jquery.ui.draggable.js");
		excludePages.add("/timemachine4/js/jquery.ui.mouse.js");
		excludePages.add("/timemachine4/js/jquery.ui.position.js");
		excludePages.add("/timemachine4/js/jquery.ui.resizable.js");
		excludePages.add("/timemachine4/js/jquery.ui.widget.js");
		excludePages.add("/timemachine4/fancybox/fancybox/jquery.fancybox-1.2.6.css");
		excludePages.add("/timemachine4/fancybox/fancybox/jquery.fancybox-1.2.6.pack.js");
		excludePages.add("/timemachine4/");
		excludePages.add("/timemachine4/");
		excludePages.add("/timemachine4/");
		excludePages.add("/timemachine4/");
		if (!excludePages.contains(uri)) {
			if(hRequest.getSession().getAttribute("userId")==null){
				PrintWriter out = response.getWriter();
				out.println("<script language='JavaScript'>");
				out.println("window.top.location.href='"
				+ hRequest.getContextPath() + "/index.html';");
				out.println("</script>");
				out.flush();
				out.close();
		    }
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
