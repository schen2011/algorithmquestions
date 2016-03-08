package TreeProblems;


/**
 * Created by stephen.chen on 3/8/2016.
 */
public class BinaryTree {
    private TNode root;

    private static class TNode
    {
        TNode leftChild;
        TNode rightChild;
        int data;
        TNode(int newData)
        {
            leftChild = null;
            rightChild = null;
            data = newData;
        }
    }

    public void BinaryTree()
    {
        root = null;
    }

    public boolean lookUp(int data)
    {
        return lookUp(root, data);
    }

    public void insert(int data)
    {
        root = insert(root, data);
    }

    private boolean lookUp(TNode node, int data)
    {
        if (node == null)
        {
            return false;
        }

        if (data == node.data)
        {
            return true;
        }
        else if(data < node.data)
        {
            return lookUp(node.leftChild, data);
        }
        else
        {
            return lookUp(node.rightChild, data);
        }
    }

    private TNode insert(TNode node, int data)
    {
        if (node == null)
        {
            node = new TNode(data);
        }
        else
        {
            if (data <= node.data)
            {
                node.leftChild = insert(node.leftChild, data);
            }
            else
            {
                node.rightChild = insert(node.rightChild, data);
            }
        }
        return node;
    }

    public int size()
    {
        return size(root);
    }

    public int maxDepth()
    {
        return maxDepth(root);
    }

    public int minValue()
    {
        return minValue(root);
    }

    public void printTree()
    {
        return printTree(root);
    }

    public void doubleTree()
    {
        return doubleTree(root);
    }


    private void doubleTree(TNode node)
    {
        TNode preNode;
        if (node == null)
        {
            return;
        }
        else
        {
            doubleTree(node.leftChild);
            doubleTree(node.rightChild);
        }
        preNode = node.leftChild;
        node.leftChild = new TNode(node.data);
        node.leftChild.leftChild = preNode;
    }

    public boolean hasPathSum(int sum)
    {
        return hasPathSum(root, sum);
    }

    public void mirror()
    {
        mirror(root);
    }

    private int size(TNode node)
    {
        if (node == null) {
            return 0;
        }
        else
        {
            return (size(node.leftChild)
                    + 1 + size(node.rightChild));
        }
    }

    private int maxDepth(TNode node)
    {
        if (node == null)
            return 0;
        else
        {
            int lDepth = maxDepth(node.leftChild);
            int rDepth = maxDepth(node.rightChild);
            return (Math.max(lDepth, rDepth) + 1);
        }
    }

    private int minValue(TNode node)
    {
        TNode current = node;
        while (current.leftChild != null) {
            current = current.leftChild;
        }
        return current.data;
    }

    private void printTree(TNode node)
    {
        if (node == null)
        {
            return;
        }
        printTree(node.leftChild);
        System.out.println(node.data + " ");
        printTree(node.rightChild);
    }

    private boolean hasPathSum(TNode node, int sum)
    {
        if (node == null)
        {
            return true;
        }
        else
        {
            int subSum = sum - node.data;
            return (hasPathSum(node.leftChild, subSum)
            || hasPathSum(node.rightChild, subSum));
        }
    }

    private void mirror(TNode node)
    {
        if (node != null)
        {
            mirror(node.leftChild);
            mirror(node.rightChild);
            TNode tmp = node.leftChild;
            node.leftChild = node.rightChild;
            node.rightChild = tmp;
        }
    }


    public void Build123A()
    {
        root = new TNode(2);
        TNode lChild = new TNode(1);
        TNode rChild = new TNode(3);
        root.leftChild = lChild;
        root.rightChild = rChild;
    }





}
