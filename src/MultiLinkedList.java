public class MultiLinkedList<T> {
    private Node<T> head;

    // counters for bingo and tombola operations
    private int counter1 = 0;
    private int counter2 = 0;
    private int counter3 = 0;

    // add first row of the card to the linked list
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // add second row of the card to the linked list
    public void addChild(T data) {
        Node<T> newNode = new Node<>(data);
        if (head.child == null) {
            head.child = newNode;
        } else {
            Node<T> temp = head.child;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // add third row of the card to the linked list
    public void addGrandChild(T data) {
        Node<T> newNode = new Node<>(data);
        if (head.grandChild == null) {
            head.grandChild = newNode;
        } else {
            Node<T> temp = head.grandChild;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // check the first line and if it has the same number increase the counter1
    public void checkFirstLine(T data) {
        Node<T> temp = head;
        while (temp != null) {
            if (temp.data == data) {
                this.counter1++;
                temp = temp.next;
            } else {
                temp = temp.next;
            }
        }
    }

    // check the second line and if it has the same number increase the counter2
    public void checkSecondLine(T data) {
        Node<T> temp = head;
        if (temp != null) {
            temp = temp.child;
            while (temp != null) {
                if (temp.data == data) {
                    this.counter2++;
                    temp = temp.next;
                } else {
                    temp = temp.next;
                }
            }
        }
    }

    // check the third line and if it has the same number increase the counter3
    public void checkThirdLine(T data) {
        Node<T> temp = head;
        if (temp != null) {
            temp = temp.grandChild;
            while (temp != null) {
                if (temp.data == data) {
                    this.counter3++;
                    temp = temp.next;
                } else {
                    temp = temp.next;
                }
            }
        }
    }

    // perform all the above operations in a single method
    public void addCardToLinkedList(MultiLinkedList<Integer> player, int[][] card1) {
        for (int i = 0; i < card1.length; i++) {
            for (int j = 0; j < card1[i].length; j++) {
                if (card1[i][j] > 0) {
                    switch (i) {
                        case 0:
                            player.add(card1[i][j]);
                            break;
                        case 1:
                            player.addChild(card1[i][j]);
                            break;
                        case 2:
                            player.addGrandChild(card1[i][j]);
                            break;
                    }
                }
            }
        }
    }

    // check bingo or tombola
    public boolean checkBingoOrTombola(String player) {
        // if counter1 is equals to 5
        if (counter1 == 5) {
            // check the other counters if they are equal to '0' it means they are 'Bingo'
            // and with the counter1 that means 'Tombola' and return true to stop the game loop
            if (counter2 == 0 && counter3 == 0) {
                System.out.println("*************************************");
                System.out.println("*                                   *");
                System.out.println("          " + player + " Tombola          ");
                System.out.println("*                                   *");
                System.out.println("*************************************");
                System.out.println("-------------------------------------");
                return true;
                // if other counters are not equal to '0' that means this row is 'Bingo' and continue to game
            } else {
                System.out.println("*************************************");
                System.out.println("*                                   *");
                System.out.println("          " + player + " Bingo          ");
                System.out.println("*                                   *");
                System.out.println("*************************************");
                System.out.println("-------------------------------------");
            }
            // if it is bingo set the counter to '0'
            counter1 = 0;
        } else if (counter2 == 5) {
            if (counter1 == 0 && counter3 == 0) {
                System.out.println("*************************************");
                System.out.println("*                                   *");
                System.out.println("          " + player + " Tombola          ");
                System.out.println("*                                   *");
                System.out.println("*************************************");
                System.out.println("-------------------------------------");
                return true;
            } else {
                System.out.println("*************************************");
                System.out.println("*                                   *");
                System.out.println("          " + player + " Bingo          ");
                System.out.println("*                                   *");
                System.out.println("*************************************");
                System.out.println("-------------------------------------");
            }
            counter2 = 0;
        } else if (counter3 == 5) {
            if (counter1 == 0 && counter2 == 0) {
                System.out.println("*************************************");
                System.out.println("*                                   *");
                System.out.println("          " + player + " Tombola          ");
                System.out.println("*                                   *");
                System.out.println("*************************************");
                System.out.println("-------------------------------------");
                return true;
            } else {
                System.out.println("*************************************");
                System.out.println("*                                   *");
                System.out.println("          " + player + " Bingo          ");
                System.out.println("*                                   *");
                System.out.println("*************************************");
                System.out.println("-------------------------------------");
            }
            counter3 = 0;
        }
        return false;
    }

    // get number from permutation list to check the tombola cards
    public int removeAndGetData() {
        int data = (int) (head.data);
        head = head.next;
        return data;
    }

}