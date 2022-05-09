package com.likou;

public class ExchangeLinkNodes_5_8 {
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
        int[] data = {1, 2, 3, 4, 5, 6};
        ExchangeLinkNodes_5_8 delLinkNodes = new ExchangeLinkNodes_5_8();
        ListNode init = delLinkNodes.init(data, 0);
        init = delLinkNodes.swapPairs(init);

        System.out.println(init.val);
        System.out.println(init.next.val);
        System.out.println(init.next.next.val);
        System.out.println(init.next.next.next.val);
        System.out.println(init.next.next.next.next.val);
        System.out.println(init.next.next.next.next.next.val);
    }

    private ListNode init(int[] data, int i) {

        ListNode result = new ListNode();
        if (i < data.length) {
            result.val = data[i];
            result.next = init(data, ++i);
        }
        return result;
    }

    public ListNode swapPairs(ListNode head) {
        if (head== null || head.next== null){
            return head;
        }
        ListNode p = head, q = head.next, h = q, r;
        while (true) {
            p.next = q.next;
            r = p;
            q.next = p;

            if (p.next != null) {
                p = p.next;
                if (p.next != null) {
                    q = p.next;
                } else {
                    break;
                }

            } else {
                break;
            }

            r.next = q;

        }
        return h;
    }


}

