package reflect;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * created by chaoyi on 2018/8/24
 */
public class TT {
    public static Field[] getDeclaredFields(Class<?> clazz) {
        List<Field> fields = new ArrayList<>();
        while (clazz != null) {
            Field[] fs = clazz.getDeclaredFields();
            if (fs != null) {
                for (Field f : fs) {
                    fields.add(f);
                }
            }

            clazz = clazz.getSuperclass();
        }
        Field[] ret = new Field[fields.size()];
        return fields.toArray(ret);
    }

    public static void main(String[] args) {
        Field[] declaredFields = getDeclaredFields(String.class);
        for (int i = 0; i < declaredFields.length; i++) {
            System.out.println(declaredFields[i].getName());
        }
    }

}
