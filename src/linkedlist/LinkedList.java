package linkedlist;

import java.util.Arrays;
import java.util.List;

public class LinkedList {

    Node head;
    Node tail;


    public void insert(int data)
    {
        Node node = new Node();
        node.data = data;
        node.next = null;

        if(head==null) {
            head = node;
        }
        else {
            Node tempNode = head;
            while(tempNode.next!=null)
            {
                tempNode = tempNode.next;
            }
            tempNode.next = node;
            tail = node;
        }
    }
    public void show()
    {
        Node node = head;
        while(node.next!=null)
        {
            System.out.print(node.data+"->");
            node=node.next;
        }
        System.out.print(node.data);
        System.out.println();
    }

    public void insertLast(int data)
    {
        Node node = new Node();
        node.data=data;
        node.next=null;

        tail.next=node;
        tail=node;
    }

    public int length()
    {
        if(head==null) {
            return  0;
        }
        Node node = head;
        int count=0;
        while(node.next!=null)
        {
            node = node.next;
            count++;
        }
        return ++count;
    }

    public Node reverse(Node list)
    {
        Node curr = list;
        Node prev = null;
        while(curr!=null)
        {
            Node temp = curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        list=prev;
        return list;
    }

    public void KReverse(LinkedList list, int k)
    {
        Node prevTail = null;
        Node prevHead = null;
        Node currTail = null;
        Node currHead = null;
        Node finalHead = null;
        int size = list.length()/k;

        for(int i=0;i<size;i++)
        {
            if(i==0)
            {
                List<Node> nodes = reverseAndReturnHeadAndTail(list.head, k);
                currHead = nodes.get(0);
                currTail = nodes.get(1);
                finalHead = currHead;
            }
            else {
                List<Node> nodes = reverseAndReturnHeadAndTail(currTail.next, k);
                prevHead = currHead;
                prevTail = currTail;
                currHead = nodes.get(0);
                currTail = nodes.get(1);
                prevTail.next=currHead;
            }
        }
        while(finalHead!=null)
        {
            System.out.print(finalHead.data+"->");
            finalHead=finalHead.next;
        }
    }


    public List<Node> reverseAndReturnHeadAndTail(Node head,int k)
    {
        Node p1 = head;
        Node p2 = head.next;
        p1.next = null;
        int count=1;
        Node tail = head;
        while(p2!=null && count<k)
        {
            Node temp = p2.next;
            p2.next = p1;
            p1=p2;
            p2=temp;
            count++;
        }
        tail.next = p2;
        return Arrays.asList(p1,tail);
    }

    public Node reorderList(Node list)
    {
        Node temp = list;
        Node midNode = findMid(temp);
        Node reverseHead = reverse(midNode);
        int count=0;

        Node p1 = list;
        Node p2 = reverseHead;
        while(p1.next!=null )
        {
            Node temp1 = p1.next;
            p1.next=p2;
            Node temp2 = p2.next;
            p2.next=temp1;
            p1=temp1;
            p2=temp2;
            count++;
        }
        if(count%2==0)
        {
            p1.next=p2;
            p2.next=null;
        }
        System.out.println(count);
        return list;
    }

    public Node findMid(Node list)
    {
        Node head = list;
        Node p1= head;
        Node p2 = head;
        while(p2.next!=null && p2.next.next!=null)
        {
            p1=p1.next;
            p2=p2.next.next;
        }

        return p1;
    }

}
