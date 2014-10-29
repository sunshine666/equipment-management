package pro.interceptor;
import java.util.Map;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor  
{
    public String doIntercept(ActionInvocation ai) throws Exception  
    {
    	Map session = ai.getInvocationContext().getSession();
        String loginname = (String) session.get("loginname");
        if ( null != loginname)
             return ai.invoke();
        else  
             return Action.LOGIN;       
   } 
}
