import java.util.HashMap;

class OrderNode {
    long orderId;
    double price;
    OrderNode left, right;

    OrderNode(long orderId, double price) {
        this.orderId = orderId;
        this.price = price;
    }
}

public class NSEOrderBook {

    static HashMap<Long, OrderNode> byId = new HashMap<>();

    static OrderNode insert(OrderNode root,
                            long id,
                            double price) {

        if (root == null) {
            OrderNode node =
                    new OrderNode(id, price);

            byId.put(id, node);
            return node;
        }

        if (price > root.price)
            root.left =
                    insert(root.left, id, price);
        else
            root.right =
                    insert(root.right, id, price);

        return root;
    }

    static void inorder(OrderNode root) {

        if (root != null) {

            inorder(root.left);

            System.out.println(
                    "Order " + root.orderId +
                    " Price " + root.price);

            inorder(root.right);
        }
    }

    static OrderNode bestBid(OrderNode root) {

        while (root.left != null)
            root = root.left;

        return root;
    }

    public static void main(String[] args) {

        OrderNode root = null;

        root = insert(root,101,2980);
        root = insert(root,102,2965);
        root = insert(root,104,2985);
        root = insert(root,105,2970);
        root = insert(root,107,2978);

        System.out.println(
                "Active Orders:");

        inorder(root);

        OrderNode best =
                bestBid(root);

        System.out.println(
                "\nBest Bid = "
                + best.price);
    }
}