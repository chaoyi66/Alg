package util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;


public class MySortList<E> {

	private int cmp(Object obj1, Object obj2) {
		int result = 0;
		if (obj1 instanceof String) {
			// 字符串
			result = obj1.toString().compareTo(obj2.toString());
		} else if (obj1 instanceof Date) {
			// 日期
			long l = ((Date) obj1).getTime() - ((Date) obj2).getTime();
			if (l > 0) {
				result = 1;
			} else if (l < 0) {
				result = -1;
			} else {
				result = 0;
			}
		} else if (obj1 instanceof Integer) {
			result = (Integer) obj1 - (Integer) obj2;
		} else if (obj1 instanceof Long) {
			// Long整型
			result = ((Long) obj1).compareTo((Long) obj2);
		} else if (obj1 instanceof Double) {
			// Double整型
			result = ((Double) obj1).compareTo((Double) obj2);
		} else {
			// 目前尚不支持的对象，直接转换为String，然后比较，后果未知
			result = obj1.toString().compareTo(obj2.toString());

			System.err.println("MySortList.sortByMethod方法接受到不可识别的对象类型，转换为字符串后比较返回...");
		}
		return result;
	}

	public void sortByMethod(List<E> list, final String method,
	                         final boolean reverseFlag) {
		Collections.sort(list, new Comparator<Object>() {
			@SuppressWarnings("unchecked")
			public int compare(Object arg1, Object arg2) {
				int result = 0;
				try {
					Method m1 = ((E) arg1).getClass().getMethod(method, null);
					Method m2 = ((E) arg2).getClass().getMethod(method, null);
					Object obj1 = m1.invoke(((E) arg1), null);
					Object obj2 = m2.invoke(((E) arg2), null);
					result = cmp(obj1, obj2);
					if (reverseFlag) {
						// 倒序
						result = -result;
					}
				} catch (NoSuchMethodException nsme) {
					nsme.printStackTrace();
				} catch (IllegalAccessException iae) {
					iae.printStackTrace();
				} catch (InvocationTargetException ite) {
					ite.printStackTrace();
				}

				return result;
			}

		});
	}

	public void sortByValue(List<E> list, final String field,
	                        final boolean reverseFlag) {
		Collections.sort(list, new Comparator<Object>() {
			@SuppressWarnings("unchecked")
			public int compare(Object arg1, Object arg2) {
				int result = 0;
				try {
					Object obj1 = ((E) arg1).getClass().getField(field);
					Object obj2 = ((E) arg2).getClass().getField(field);
					result = cmp(obj1, obj2);
					if (reverseFlag) {
						// 倒序
						result = -result;
					}
				} catch (NoSuchFieldException e) {
					e.printStackTrace();
				}

				return result;
			}
		});
	}
}
