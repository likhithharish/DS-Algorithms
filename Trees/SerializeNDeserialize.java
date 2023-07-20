package Trees;

public class SerializeNDeserialize {

    public String serialize(Node root) {
        return serial(root, "");
    }

    public String serial(Node root, String str) {
        if (root == null) {
            str += "null,";
        } else {
            str += String.valueOf(root.key) + ",";
            str = serial(root.left, str);
            str = serial(root.right, str);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    int size;
    int index;

    public Node deserialize(String data) {
        index = 0;
        String[] s = data.split(",");
        size = s.length;
        return deserial(s);
    }

    public Node deserial(String[] s) {
        if (index == size) {
            return null;
        }
        int value = 0;
        if (s[index].equals("null")) {
            index++;
            return null;
        } else {
            value = Integer.valueOf(s[index]);
        }
        index++;
        Node root = new Node(value);
        root.left = deserial(s);
        root.right = deserial(s);
        return root;
    }

    public static void main(String[] args) {

    }
}
