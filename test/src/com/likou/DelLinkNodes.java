package com.likou;

import sun.applet.Main;

public class DelLinkNodes {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }


        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5};
        DelLinkNodes delLinkNodes = new DelLinkNodes();
        ListNode init = delLinkNodes.init(data, 0);
//        System.out.println(init.val);
//        System.out.println(init.next.val);
//        System.out.println(init.next.next.val);
//        System.out.println(init.next.next.next.val);
//        System.out.println(init.next.next.next.next.val);
        init = delLinkNodes.removeNthFromEnd(init, 2);
        System.out.println();
        System.out.println(init.val);
        System.out.println(init.next.val);
        System.out.println(init.next.next.val);
        System.out.println(init.next.next.next.val);
        System.out.println(init.next.next.next.next.val);
    }

    private ListNode init(int[] data, int i) {

        ListNode result = new ListNode();
        if (i < data.length) {
            result.val = data[i];
            result.next = init(data, ++i);
        }
        return result;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {


        int length = 0;
        ListNode head2 = head;
        ListNode head3 = head;
        ListNode head4;
        ListNode head5;

        while (head2 != null) {
            head2 = head2.next;
            length++;
        }

        if (n == length) return head.next;

        int i = length - n + 1;
        System.out.println("iiiii=====>" + i);
        while (i > 2) {
            head3 = head3.next;
            i--;
        }
        System.out.println("head3.val====>" + head3.val);
        head4 = head3.next;
        head5 = head4.next;
        head3.next = head5;


        return head;


    }


}

