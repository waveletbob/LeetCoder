package com.bob.listnode;

import com.bob.struct.ListNode;

public class hascycle{
    //快慢指针
    public boolean hashcycle(ListNode head){
        if(head==null || head.next==null)return false;
        ListNode slow=head;
        ListNode fast=head.next;
        while (slow!=fast){
            if(fast==null || fast.next==null)return false;
            else {
                fast=fast.next.next;
                slow=slow.next;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        
    }
}