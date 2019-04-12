package Filter;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.dom4j.DocumentException;

import com.ttms.domain.Customer;
import com.ttms.service.Cuser_Service;


public class object_Cokile implements Filter {


    public object_Cokile() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	    HttpServletRequest req = (HttpServletRequest) request;
	    HttpServletRequest res = (HttpServletRequest) request;
	    String usename = null;
	    String password=null;
	    
		Cookie[] cookies = req.getCookies();
		if (cookies!=null) {
			for(Cookie cookie : cookies) {
				if ("usename".equals(cookie.getName())) {
					usename = cookie.getValue();
				}
				if ("password".equals(cookie.getName())) {
					password = cookie.getValue();
				}
			}
		}
		if(usename!=null&password!=null) {
		String use = URLDecoder.decode(usename, "UTF-8");
			Cuser_Service cuseter = new Cuser_Service();
			Customer login = null;
			try {
				login = cuseter.cuseter_login(use, password);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (login!=null) {
				
				HttpSession session = req.getSession();
				session.setAttribute("user", login);
			
		}
		}
		
		
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
