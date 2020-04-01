/*
 * module: fundermental
 * file: Node.java
 * date: 3/25/20 5:49 PM
 * author: VectorJu
 */

/**
 * @create 2020-03-25 17:49
 * @desc test node reverse
 **/
package com.xlab.service_java_infrastructure.algorithm;

import sun.nio.ch.DirectBuffer;

/**
 *  原文链接：https://blog.csdn.net/qq_42118253/article/details/90951011
 */
public class Node {
    //节点内容
    int data ;
    //下一节点
    Node next ;

    public Node(int data){
        this.data= data;
    }
    public Node append(Node node){
        //获取当前节点
        Node currentNode = this;
        //循环找到最后一个节点，并将参数node添加到最后一个节点的 next节点上
        while (true){
            //获取当前节点的下一个节点
            Node nextNode = currentNode.next;
            //判断当前节点的下一节点如果为空则 将 node 添加到当前节点(currentNode)的下一个节点(currentNode.next)
            if (nextNode == null){
                currentNode.next=node;
                break;
            }else {
                currentNode = nextNode;
            }

        }
        return this;
    }
    //获取下一节点
    public Node next(){
        return  this.next;
    }
    public void setNext(Node node ){
        this.next = node;
    }

    //获取当前节点的数值
    public int getData(){
        return this.data;
    }
    //打印该节点后面的全部节点
    public void showAllData(){
        //获取当前节点
        Node currentNode = this;
        while (true){
            System.out.print(currentNode.getData()+" ");
            Node nextNode = currentNode.next();
            if (nextNode == null){
                break;
            }else {
                currentNode = nextNode;
            }

        }
        System.out.println();
    }
    /**  链表倒置
     *
     *   实现思想：
     *      首先将原链表的开头节点下一节点置空。
     *      存储原链表后面的数据
     *      遍历链表，每次循环获取下一节点 ，然后将下一节点的next指向上一节点
     *      获取将需要倒置的链表的首节点headerNode，将首节点的下一节点是设置为空
     *    a -> b -> c -> d   (反)
     *    a -> null ;     ---》     b - c -d ;  首节a 的下一节点 置空 ，存储 b 后面的数据。
     *    b ->a ->null ;  ---》       c - d ;    获取b 设置下一节点为 a ，存储 c 后面的节点
     *    c ->b -> a ->null ;  ---》      d;      获取c 节点 将一下节点设置为 b ,存储 d后面的节点。
     *    d ->c -> b-> a ->null;
     *
     * @return
     */
    public Node reverse(){
        //原链表的开头节点 获取开头节点 a
        Node header = this;
        // 获取开头节点的下一节点，由于需要倒置 ，开头节点变为末节点 所以存储原链表中的数据 b - c- d
        Node newNode =header.next() ;
        //用于置换 null
        Node tempNode =null;
        //首先将开头节点 的下一节点置空 a-null
        header.setNext(null);
        while (newNode.next() != null){
            //提前存储好，下一节点的节点  tempNode = c; newNode = b
            tempNode = newNode.next();
            //将原节点的下一节点的next指向原节点 （此处实现倒置）newNOde =  b-a-null
            newNode.setNext(header);
            //将 新的链表复制给 header   header =  b-a-null
            header = newNode;
            // 重新再来一遍 剩下的节点赋值给 newNode :
            newNode = tempNode;

        }
        //原链表中的最后一个 node 的 next 为空 会直接跳出循环， 此时将原链表中的最后一个node的下一个节点添加 重新排序的链表的首节点
        newNode.setNext(header);
        //返回的节点相当于原链表的最后一个节点
        return newNode;
    }
}

