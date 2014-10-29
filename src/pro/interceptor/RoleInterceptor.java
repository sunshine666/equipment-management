package pro.interceptor;
import java.util.Map;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class RoleInterceptor extends MethodFilterInterceptor  
{
    public String doIntercept(ActionInvocation ai) throws Exception  
    {
    	Map session = ai.getInvocationContext().getSession();
        String roleID = (String) session.get("roleId");
        if ( null != roleID)
        {
        	if(roleID.equals("1"))
        		return ai.invoke();
        	else 
        		return Action.LOGIN;
        }
        else  
             return Action.LOGIN;       
   } 
}
