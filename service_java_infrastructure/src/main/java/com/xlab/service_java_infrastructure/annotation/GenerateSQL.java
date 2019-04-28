/*
 * module: fundermental
 * file: GenerateSQL.java
 * date: 4/28/19 4:40 PM
 * author: VectorJu
 */

/**
 * @create 2019-04-28 16:40
 * @desc test of generate sql and bind with annotation
 **/
package com.xlab.service_java_infrastructure.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GenerateSQL {

    public static void main(String[] args) {
        User stallman = new User();
        stallman.setId(001);
        User rich = new User();
        rich.setName("dannis rich");
        generateSql(rich);
        generateSql(stallman);
    }


    private static String generateSql(User user) {

        Class clazz = user.getClass();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from ");

        if (clazz.isAnnotationPresent(Table.class)) {
            Table table = (Table) clazz.getAnnotation(Table.class);
            String tableName = table.value();
            stringBuilder.append(tableName).append(" where 1=1 and ");
        }

        Field[] fields = clazz.getDeclaredFields();

        for (Field field: fields) {
            String columnName;
            if (field.isAnnotationPresent(Column.class)) {
                Column column = field.getAnnotation(Column.class);
                columnName = column.value();
            }else {
                continue;
            }

            String fieldName = field.getName();
            String methodName = "get" + fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);

            try {
                Method method = clazz.getMethod(methodName);
                Object fieldValue = method.invoke(user);

                if (fieldValue == null || ((fieldValue instanceof Integer) && (Integer)fieldValue == 0)) {
                    continue;
                }

                if (fieldValue instanceof Integer) {
                    stringBuilder.append(columnName +"="+fieldValue);
                }

                if (fieldValue instanceof String) {
                    stringBuilder.append(columnName + "="+"'"+fieldValue+"'");
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }
}

