import acm.program.ConsoleProgram;

/**
 * @author pinakghosh
 * @version 1.0
 * @since 2020-02-17
 * 
 * 
 *        This class is a binary tree that sorts threw the inputed strings
 * 
 * 
 * 
 */
public class bTree {

	/**
	 * Declare variable that will link to buffer sort so that acm.jar can be used
	 */
	ConsoleProgram link;

	/**
	 * creates node variable that is called root and given no value
	 */
	bNode root = null;

	/**
	 * 
	 * adds node to the binary tree
	 * 
	 * @param data is string that is inputed by user
	 */
	public void addNode(String data) {

		bNode current;

		if (root == null) {
			root = makeNode(data);
		} else {
			current = root;
			while (true) {

				if ((data.compareTo(current.data) < 0)) {

					if (current.left == null) {
						current.left = makeNode(data);
						break;
					} else {
						current = current.left;
					}
				}

				else {
					if (current.right == null) {
						current.right = makeNode(data);
						break;
					} else {
						current = current.right;
					}
				}
			}
		}
	}

	/**
	 * 
	 * creates node for the binary tree
	 * 
	 * @param data is string value
	 * @return node that is in binary tree
	 */
	private bNode makeNode(String data) {
		bNode node = new bNode();
		node.data = data;
		node.left = null;
		node.right = null;

		return node;
	}

	/**
	 * this method hides recursion from user
	 */
	public void displayInOrder() {

		TraverseDisplayInOrder(root);
	}

	/**
	 * 
	 * follows a left root right traversal method. which will then display the
	 * values in ascending order
	 * 
	 * @param root is value at given point of binary tree
	 * 
	 */
	private void TraverseDisplayInOrder(bNode root) {

		if (root.left != null)
			TraverseDisplayInOrder(root.left);
		link.println(root.data);
		if (root.right != null)
			TraverseDisplayInOrder(root.right);

	}

	/**
	 * this method hides recursion from user
	 */
	public void displayInReverseOrder() {

		TraverseDisplayInReverseOrder(root);
	}

	/**
	 * 
	 * follows a right root left traversal method. which will then display the
	 * values in decending order
	 * 
	 * @param root is value at given point of binary tree
	 */
	public void TraverseDisplayInReverseOrder(bNode root) {

		if (root.right != null)
			TraverseDisplayInReverseOrder(root.right);
		link.println(root.data);
		if (root.left != null)
			TraverseDisplayInReverseOrder(root.left);

	}

	/**
	 * creates link to link Btree class to Buffer
	 * 
	 * @param link allows to link console program to bTree class
	 */
	public void setlink(ConsoleProgram link) {

		this.link = link;

	}

	/**
	 * 
	 * 
	 * Creates Nodes to be used in binary tree
	 * 
	 * @author pinakghosh
	 * @version 1.0
	 * @since 2020-02-17
	 */
	public class bNode {

		String data;
		bNode left = null;
		bNode right = null;
	}

}
