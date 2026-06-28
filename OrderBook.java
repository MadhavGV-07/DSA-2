import java.util.HashMap;

class OrderNode {
    int orderId;
    int price;
    int volume;

    OrderNode left, right;

    OrderNode(int orderId, int price, int volume) {
        this.orderId = orderId;
        this.price = price;
        this.volume = volume;
    }
}

public class OrderBook {

    static HashMap<Integer, OrderNode> map = new HashMap<>();

    OrderNode root;

    // Insert into BST (Higher price goes to left)
    public OrderNode insert(OrderNode node, int id, int price, int volume) {

        if (node == null) {
            OrderNode temp = new OrderNode(id, price, volume);
            map.put(id, temp);
            return temp;
        }

        if (price > node.price)
            node.left = insert(node.left, id, price, volume);
        else
            node.right = insert(node.right, id, price, volume);

        return node;
    }

    // Find Best Bid (Highest Price)
    public OrderNode bestBid(OrderNode node) {

        if (node == null)
            return null;

        while (node.left != null)
            node = node.left;

        return node;
    }

    // Delete Node
    public OrderNode delete(OrderNode root, int price) {

        if (root == null)
            return null;

        if (price > root.price)
            root.left = delete(root.left, price);

        else if (price < root.price)
            root.right = delete(root.right, price);

        else {

            if (root.left == null)
                return root.right;

            if (root.right == null)
                return root.left;

            OrderNode temp = minimum(root.right);

            root.price = temp.price;
            root.orderId = temp.orderId;
            root.volume = temp.volume;

            root.right = delete(root.right, temp.price);
        }

        return root;
    }

    OrderNode minimum(OrderNode node) {

        while (node.left != null)
            node = node.left;

        return node;
    }

    // Cancel Order using Order ID
    public void cancelOrder(int id) {

        if (!map.containsKey(id)) {
            System.out.println("Order Not Found");
            return;
        }

        OrderNode node = map.get(id);

        root = delete(root, node.price);

        map.remove(id);

        System.out.println("Order " + id + " Cancelled.");
    }

    // Display Orders
    public void inorder(OrderNode node) {

        if (node == null)
            return;

        inorder(node.left);

        System.out.println("Order ID : " + node.orderId +
                " Price : " + node.price +
                " Volume : " + node.volume);

        inorder(node.right);
    }

    public static void main(String[] args) {

        OrderBook ob = new OrderBook();

        ob.root = ob.insert(ob.root, 101, 2980, 100);
        ob.root = ob.insert(ob.root, 102, 2965, 80);
        ob.root = ob.insert(ob.root, 103, 2992, 120);
        ob.root = ob.insert(ob.root, 104, 2985, 60);
        ob.root = ob.insert(ob.root, 105, 2970, 90);
        ob.root = ob.insert(ob.root, 106, 2998, 110);
        ob.root = ob.insert(ob.root, 107, 2978, 70);
        ob.root = ob.insert(ob.root, 108, 2988, 140);

        System.out.println("Current Order Book\n");

        ob.inorder(ob.root);

        OrderNode best = ob.bestBid(ob.root);

        System.out.println("\nBest Bid");

        System.out.println("Order ID : " + best.orderId);
        System.out.println("Price : " + best.price);

        System.out.println();

        ob.cancelOrder(104);

        System.out.println("\nUpdated Order Book\n");

        ob.inorder(ob.root);
    }
}