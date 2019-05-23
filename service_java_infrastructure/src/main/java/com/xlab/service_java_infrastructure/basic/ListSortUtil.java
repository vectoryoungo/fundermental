/*
 * module: fundermental
 * file: ListSortUtil.java
 * date: 5/19/19 3:51 PM
 * author: VectorJu
 */

/**
 * @create 2019-05-19 15:51
 * @desc
 **/
package com.xlab.service_java_infrastructure.basic;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ListSortUtil<T> {

    public void mySort(List<T> list, final String sortField, final String sortRule) {

        Collections.sort(list, new Comparator<T>() {

            @Override
            public int compare(T o1, T o2) {
                // 通过反射获取方法名称，如getId
                String methodName = "get" + sortField.substring(0, 1).toUpperCase() + sortField.substring(1, sortField.length());
                String flag = null;
                try {
                    Field[] fields = o1.getClass().getDeclaredFields();
                    for (Field f : fields) {
                        if (sortField.equals(f.getName())) {
                            System.out.println(f.getName() + "  GenericType:  " + f.getGenericType().toString());
                            if (f.getGenericType().toString().equals("class java.util.Date")) {
                                flag = "Date";
                                break;
                            }
                            if (f.getGenericType().toString().equals("class java.lang.String")) {
                                flag = "String";
                                break;
                            }
                            if (f.getGenericType().toString().equals("int")) {
                                flag = "int";
                                break;
                            }
                            if (f.getGenericType().toString().equals("class java.lang.Integer")) {
                                flag = "Integer";
                                break;
                            }
                            if (f.getGenericType().toString().equals("double")) {
                                flag = "double";
                                break;
                            }
                            if (f.getGenericType().toString().equals("class java.lang.Double")) {
                                flag = "Double";
                                break;
                            }
                            if (f.getGenericType().toString().equals("float")) {
                                flag = "float";
                                break;
                            }
                            if (f.getGenericType().toString().equals("class java.lang.Float")) {
                                flag = "Float";
                                break;
                            }
                        }
                    }

                    Method method1 = o1.getClass().getMethod(methodName, null);
                    Method method2 = o2.getClass().getMethod(methodName, null);
                    // System.out.println(method1.invoke(o1, null));
                    // System.out.println(method2.invoke(o2, null));
                    if ("Date".equals(flag)) {
                        if ("desc".equals(sortRule)) {
                            return ((Date) method1.invoke(o1, null)).getTime() < ((Date) method2.invoke(o2, null)).getTime() ? 1 : -1;
                        } else {
                            return ((Date) method1.invoke(o1, null)).getTime() < ((Date) method2.invoke(o2, null)).getTime() ? -1 : 1;
                        }
                    } else if ("String".equals(flag)) {
                        if ("desc".equals(sortRule)) {
                            return method2.invoke(o2, null).toString().compareTo(method1.invoke(o1, null).toString());
                        } else {
                            System.out.println("compare result : " + method1.invoke(o1, null).toString().compareTo(method2.invoke(o2, null).toString()));
                            return method1.invoke(o1, null).toString().compareTo(method2.invoke(o2, null).toString());
                        }
                    } else if ("int".equals(flag) || "Integer".equals(flag)) {
                        if ("desc".equals(sortRule)) {
                            return ((Integer) method2.invoke(o2, null)).compareTo((Integer) method1.invoke(o1, null));
                        } else {
                            return ((Integer) method1.invoke(o1, null)).compareTo((Integer) method2.invoke(o2, null));
                        }
                    } else if ("double".equals(flag) || "Double".equals(flag)) {
                        if ("desc".equals(sortRule)) {
                            return ((Double) method2.invoke(o2, null)).compareTo((Double) method1.invoke(o1, null));
                        } else {
                            return ((Double) method1.invoke(o1, null)).compareTo((Double) method2.invoke(o2, null));
                        }
                    } else if ("float".equals(flag) || "Float".equals(flag)) {
                        if ("desc".equals(sortRule)) {
                            return ((Float) method1.invoke(o1, null)) < ((Float) method2.invoke(o2, null)) ? 1 : -1;
                        } else {
                            return ((Float) method1.invoke(o1, null)) < ((Float) method2.invoke(o2, null)) ? -1 : 1;
                        }
                    }
                } catch (NoSuchMethodException | SecurityException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                return 0;
            }
        });

    }

    public static void main(String[] args) throws ParseException {
        // TODO Auto-generated method stub
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        ChannelSituationBean cs = new ChannelSituationBean();
        cs.setId(1);
        cs.setDate(sdf.parse("2012-10-09"));
        cs.setRegistCount(15);
        cs.setFee(3f);
        cs.setInvestMoney(300.00);
        cs.setRegistChannel("android");
        cs.setMyFee(3f);
        cs.setMyInvestMoney(299.99);

        //
        ChannelSituationBean cs1 = new ChannelSituationBean();
        cs1.setId(2);
        cs1.setDate(sdf.parse("2016-10-09"));
        cs1.setRegistCount(8);
        cs1.setFee(6f);
        cs1.setInvestMoney(600.00);
        cs1.setRegistChannel("android");
        cs1.setMyFee(5.8f);
        cs1.setMyInvestMoney(588.23);

        //
        ChannelSituationBean cs2 = new ChannelSituationBean();
        cs2.setId(3);
        cs2.setDate(sdf.parse("2014-10-09"));
        cs2.setRegistCount(6);
        cs2.setFee(9f);
        cs2.setInvestMoney(500.05);
        cs2.setRegistChannel("weixin");
        cs2.setMyFee(8.88f);
        cs2.setMyInvestMoney(488.00);

        //
        ChannelSituationBean cs3 = new ChannelSituationBean();
        cs3.setId(4);
        cs3.setDate(sdf.parse("2015-02-15"));
        cs3.setRegistCount(10);
        cs3.setFee(8f);
        cs3.setInvestMoney(500.02);
        cs3.setRegistChannel("ios");
        cs3.setMyFee(7.99f);
        cs3.setMyInvestMoney(488.99);

        List<ChannelSituationBean> m_list = new ArrayList<ChannelSituationBean>();
        m_list.add(cs);
        m_list.add(cs1);
        m_list.add(cs2);
        m_list.add(cs3);

        new ListSortUtil<ChannelSituationBean>().mySort(m_list, "myFee", "desc");

        // Collections.sort(m_list, new Comparator<ChannelSituationBean>() {
        // @Override
        // public int compare(ChannelSituationBean o1, ChannelSituationBean o2) {
        // return o1.getRegistCount() < o2.getRegistCount() ? 1 : -1;
        // }
        // });
        System.out.println("--------------");
        for (ChannelSituationBean csb : m_list) {
            System.out.println("myFee : " + csb.getMyFee() + "----" + "myInvestMoney : " + csb.getMyInvestMoney() + "----" + sdf.format(csb.getDate()));
            // System.out.println("registCount : " + csb.getRegistCount() + "----" + csb.getRegistChannel() + "----id :"
            // + csb.getId());
        }

    }
}

