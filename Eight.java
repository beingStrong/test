package com.imooc.suanfa;
//leetcode 92
public class Eight {
    //第一种方法
    public ListNode reverseBetween1(ListNode head, int m, int n) {
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;//声明一个头结点，让它指向需求解的链表
        ListNode prev=dummyHead;
        ListNode fina=dummyHead;
        for(int i=0;i<m-1;i++){
            prev=prev.next;
        }//声明一个节点prev使他指向m位置的前一个节点
        for(int i=0;i<n+1;i++){
            fina=fina.next;
        }
        ListNode tail=prev.next;//声明一个节点tail使他为要倒置的节点的头结点,即为尾结点
        prev.next=reverse1(prev.next,n-m);
        tail.next=fina;
        ListNode ret=dummyHead.next;
        return ret;
    }
    private ListNode reverse1(ListNode head,int num){
       if(num==0){
           return head;
       }//递归的终止条件
        ListNode tail=head.next;//相当于声明了另一个ret
        ListNode ret=reverse1(head.next,--num);//这里当时犯了一个错误，就是写成了num--，这样只会先执行方法，再减减num，因此会发生空指针的异常
        tail.next=head;//这两条语句用来翻转指定的链表
        return ret;
    }
    //第二种方法
    public ListNode reverseBetween2(ListNode head, int m, int n) {
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;
        ListNode prev=dummyHead;
        ListNode fina=dummyHead;
        for(int i=0;i<m-1;i++){
            prev=prev.next;
        }
        for(int i=0;i<n+1;i++){
            fina=fina.next;
        }
        ListNode tail=prev.next;
        prev.next=reverse2(prev.next,n-m);
        tail.next=fina;
        ListNode ret=dummyHead.next;
        return ret;
    }
    private ListNode reverse2(ListNode head,int num){
        if(head==null||head.next==null||num==0){
            return head;
        }
        ListNode pre=head;
        ListNode cur=head.next;
        while(num!=0){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
            num--;
        }
        return pre;
    }
}
