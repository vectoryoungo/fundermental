/*
 * module: fundermental
 * file: UnsafeCASSimulator.java
 * date: 9/7/19 4:03 PM
 * author: VectorJu
 */

/**
 * @create 2019-09-07 16:03
 * @desc simulate unsafe operate
 **/
package com.xlab.service_java_infrastructure.basic.unsafe;

import com.xlab.service_java_infrastructure.basic.oom.World;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * the address is
 * object memory address is 16
 * diversion memory address is 20
 * diversity memory address is 12
 * but compare and swap method use 12 to 16 or 12 to 24 or 20 to 24 I tried many times it always return false
 */

public class UnsafeCASSimulator {

    public static void main(String[] args) {
        //instantiate with reflection
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            Unsafe unsafe = (Unsafe) f.get(null);

            //instantiate world object
            World world = (World) unsafe.allocateInstance(World.class);
            world.setDiversion("vector cover me to escape into a new world ");
            world.setObject(new String("fucking stupid ccp......"));
            world.setDiversity(88);
            //world.setContains(new ArrayList<>(0));

            for (Field field:World.class.getDeclaredFields()) {
                System.out.println("" + field.getName() + " memory address is " + unsafe.objectFieldOffset(field));
            }

            System.out.println("$$$$$$$$$$$$$$$");
            int modifyOffset = 24;
            System.out.println("before swap world diversity " + world.getDiversity());
            System.out.println(unsafe.compareAndSwapInt(world,modifyOffset,32,40));
            System.out.println("after modify value is " + world.getDiversity());
            System.out.println("%%%%%%%%%%%%%%%");


        }catch (NoSuchFieldException e) {
            e.printStackTrace();
        }catch (IllegalStateException e) {
            e.printStackTrace();
        }catch (IllegalAccessException e) {
            e.printStackTrace();
        }catch (InstantiationException e) {
            e.printStackTrace();
            //unsafe.allocateInstance(World.class) will lead this exception
        }

        UnsafeCASSimulator unsafeCASSimulator = new UnsafeCASSimulator();
        unsafeCASSimulator.simulator();

    }

    public void simulator() {
        World world = new World();
        Field theUnsafe = null;
        try {
            theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        theUnsafe.setAccessible(true);
        Unsafe UNSAFE = null;
        try {
            UNSAFE = (Unsafe) theUnsafe.get(null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(UNSAFE.toString());
        Field filed = null;
        try {
            filed = world.getClass().getDeclaredField("diversity");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        long worldOffset = UNSAFE.objectFieldOffset(filed);
        System.out.println("value worldOffset is " + worldOffset);
        UNSAFE.putInt(world, worldOffset, 100);
        System.out.println(world.getDiversity());
    }
}

