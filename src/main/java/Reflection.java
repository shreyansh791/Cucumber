import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class A {
	private void abc() {
		System.out.println(100);
	}
}

public class Reflection {
	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException,
			SecurityException, IllegalArgumentException, InvocationTargetException {
		Class c = Class.forName("A");
		A obj = (A) c.newInstance();
		Method m = c.getDeclaredMethod("abc", null);
		m.setAccessible(true);
		m.invoke(obj, null);
	}
}
