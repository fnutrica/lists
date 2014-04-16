package org.macalester.edu.comp124.lists;

public class DestructiveList<T>
        extends MyLinkedList<T> {

    public void removeEvery(int every) {
        removeEvery(every, 0);
    }


    public void removeEvery(int every, int from) {
        System.out.println("  ");
        System.out.println("  ");
        System.out.println("  ");
        System.out.println("NEW CYCLE ");
        System.out.println("Current method: removeevery");
        System.out.println(this);
        int count = 0;
        System.out.println("Every= " + every);
        System.out.println("From= " + from);


        MyLinkedNode currentnode = getHead().getNext();
        for (int iter = 0; iter < from; iter++) {

            currentnode = currentnode.getNext();

        }

        while (currentnode != getTail()) {


            MyLinkedNode prev = currentnode.getPrev();
            MyLinkedNode next = currentnode.getNext();

            int remainder = (count + 1) % every;
            System.out.println("current = " + currentnode);
            System.out.println("current.prev = " + currentnode.getPrev());
            System.out.println("current.next = " + currentnode.getNext());
            System.out.println("remainder= " + remainder);
            System.out.println("count before moving = " + count);


            //  if (((count!=0)&&(remainder==0))||((count==0)&&(every==1))){
            if (remainder == 0) {
                System.out.println("About to remove " + currentnode.getValue() + " from " + this);

                currentnode.getNext().setPrev(currentnode.getPrev());
                currentnode.getPrev().setNext(currentnode.getNext());

                numElements--;
            }
            count = count + 1;
            System.out.println("updadated count = " + count);

            currentnode = currentnode.getNext();

            System.out.println("");
            System.out.println("");
            System.out.println("");


        }
        System.out.println("final list: ");
        System.out.print("head - ");
        System.out.println(this);
        System.out.println(" - tail ");
    }


    public int removeGroupsOf(int thislarge) {
        int destroyed = 0;
        int count = this.getSize();
        System.out.println("The list is this long: " + count);
        int check = 1;
        int index = 0;
        System.out.println("Looking for groups of: " + thislarge + " elements");


        MyLinkedNode position = getHead().getNext();
        MyLinkedNode after;
        MyLinkedNode before;
        System.out.println(this);


        while (position != getTail()) {
            Object value = position.getValue();
            System.out.println("Current value is: " + value.toString());
            after = position.getNext();
            before = position.getPrev();
            while (check < thislarge) {
                System.out.println(this);
                System.out.println("index before moving: " + index);
                System.out.println(position.getValue().toString());
                if (after.getValue() == value) {
                    check++;
                    position = after;
                    after = position.getNext();
                    before = position.getPrev();
                } else if (after.getValue() != null)  {

                    System.out.println("Restarting check...");

                    position = after;
                    after = position.getNext();
                    before = position.getPrev();
                    value = position.getValue();
                    check = 1;

                }
                else if (check<thislarge){
                    return(destroyed);
                }
                index++;
                System.out.println("currently at " + check + " elements");
                System.out.println("New index: " + index);
            }


            System.out.println("Trying to delete group of " + thislarge + " " + value + " starting at index: " + (index - thislarge + 1));
            System.out.println("Starting at index: " + index);
            System.out.println("Going back of " + thislarge);
            for (int i = thislarge - 1; i > 0; i--) {

                System.out.println(before);
                before = before.getPrev();

            }

            System.out.println("before: " + before);
            System.out.println("after: " + after);
            System.out.println(this);


            if ((index - thislarge) == -1) {
                getHead().setNext(after);
                after.setPrev(getHead());
            } else {
                before.setNext(after);
                after.setPrev(before);
            }
            System.out.println("Updated list: ");
            System.out.println(this);
            destroyed++;
            numElements = numElements - thislarge;
            check = 1;
            position = position.getNext();
            while (position.getValue() == value) {
                MyLinkedNode futureposition = position.getNext();
                position.getNext().setPrev(position.getPrev());
                position.getPrev().setNext(position.getNext());
                position = futureposition;
                numElements--;

            }


        }

        return (destroyed);
    }


    public int persistentlyRemoveGroupsOf(int thislarge) {
        int totalgroups = 0;
        int localgroups = removeGroupsOf(thislarge);
        while (localgroups != 0) {
            System.out.println("localgroups = " + localgroups);
            totalgroups = totalgroups + localgroups;
            localgroups = removeGroupsOf(thislarge);
            System.out.println("totalgroups = " + totalgroups);

        }
        return (totalgroups);
    }



    public void rotate(int size) {
        System.out.println(this);
        System.out.println("size: "+size);
        MyLinkedNode position = getHead().getNext();
        int count = size();
        System.out.println("count: " + count);
        int index = 0;
        while (index < count - size+1) {
            System.out.println("Rotating...");
            MyLinkedNode before = position.getPrev();
            MyLinkedNode after = position.getNext();
            for (int i = size-1; i > 0; i--) {
                after = after.getNext();
            }
            MyLinkedNode next= position.getNext();
            next.setPrev(before);
            before.setNext(next);
            position.setPrev(after.getPrev());
            after.getPrev().setNext(position);
            position=position.getNext();
            index=index+size;
            System.out.println(this);
        }
    }








    public int getSize() {
        return size();
    }









    public String toString() {
        String output = "";
        MyLinkedNode<T> current = getHead().getNext();
        while (current != getTail()) {
            output += current.getValue() + " -> ";
            current = current.getNext();
            if (current == null && current != getTail()) {
                System.out.println(" ERROR: node not pointing to Tail or another node. We broke the list somehow");
            }
        }
        if (output.length() > 4) {
            output = output.substring(0, output.length() - 4);
        }
        return output;
    }
}



