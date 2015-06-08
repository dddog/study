package magic;

import java.lang.reflect.Method;
import org.springframework.beans.factory.support.MethodReplacer;

public class Tiger implements MethodReplacer {
	public Object reimplement(Object target, Method method, Object[] args)
			throws Throwable {
		return "난 호랑이다 어흥~!!";
	}
}