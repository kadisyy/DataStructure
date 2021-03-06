/**
 * @author Administrator
 *
 */
package com.localhost.part05.tree;
/*
 * 树是一种典型的非线性结构；
 * 一棵树是N个节点和N-1条边的集合。这个集合可以是空集；若不是空集，则树由根节点(root)以及0个或多个非空的子树T1、T2、T3、...、Tn组成。
 * 
 * 
 * 													  A
 * 													/ | \
 * 												   /  |  \
 * 												  /   |   \
 * 												 /    |    \
 * 												/     |     \
 * 											   B      C      D
 * 											  / \    /      / \
 * 											 E   F  G      H   I
 * 												/    \
 * 											   J      K
 * 
 * 术语：
 * 1.根节点(root)：是一个没有双亲节点的节点。一棵树最多只有一个根节点。(如上图的节点A就是根节点)
 * 2.边(edge)：表示从双亲节点到孩子节点的链接。(如上图中节点之间所有的链接)
 * 3.叶子节点(leaf)：没有孩子节点的节点。(如上图中E、J、K、H和I节点)
 * 4.兄弟节点(siblings)：具有相同双亲节点的节点。(如上图中B、C、D具有相同双亲节点A,所以B、C、D是兄弟节点)
 * 5.祖先节点(ancestor)：如果存在一条从根节点到节点q的路径，且节点p出现在这条路径上，那么就可以把节点p叫做节点q的祖先节点(ancestor)，节点q也叫作节点p的子孙结点(descendant)。(如上图中A、C和G都是K的祖先节点)
 * 6.节点的大小：是指子孙的个数，包括自身。(如上图子树C的大小为3)
 * 7.节点的深度(depth)：是指根节点到该节点的路径长度。(如上图中G的深度为2，A-C-G)
 * 8.节点的高度(height)：是指该节点到最深节点的路径长度。(如上图中B的高度为2，B-F-J)
 * 9.树的层(level order)：位于相同深度的所有节点的集合。(如上图中E、F、G、H、I具有相同的层；根节点位于0层)
 * 10.树的高度是指根节点到树中最深节点的路径长度。只含根节点的树的高度为0。(如上图中树的高度为3，A-C-G-K)
 * 11.树的深度是指树中所有节点深度的最大值。
 *    对于同一棵树，其深度和高度是相同的；但对于各个节点，其深度和高度不一定相同。
 * 
 * 二叉树(binary tree)
 * 定义：如果一棵树中的每一个节点最多只有2个节点，那么这棵树就称做二叉树。
 * 空树也是一棵有效的二叉树。一棵二叉树可以看做由根节点和两棵不相交的子树(左子树和右子树)组成。
 * 类型：
 * 严格二叉树：二叉树中的每一个节点只有0个节点或2个节点。
 * 满二叉树：二叉树中的每个节点都有2个节点，且叶子节点都在同一层。
 * 完全二叉树：假设二叉树高度为h,除h层外，1~h-1层的节点都是满的，第h层的节点都连续集中在左边。
 * 
 * 二叉树性质
 * 1.满二叉树的节点个数n为2的（h+1）次方加1。
 *   因为该树共有h层，所以每一层的节点个数都是满的，即有2(0) + 2(1) + 2(2) + ... + 2(h) = 2(h+1) + 1
 * 2.完全二叉树的节点个数为2(h) ~ 2(h+1) - 1
 * 3.满二叉树的叶子节点个数是2(h) 
 * 4.对于n个节点的完全二叉树，空指针的个数为n+1
 */


/*----------------------- 2017.05.15 -----------------------*/	

/**
 * 通用树(N叉树)
 * 使用孩子兄弟表示法来展示通用树
 * 1.同一个双亲节点(即兄弟节点)从左至右排列
 * 2.双亲节点只指向第一个孩子，删除双亲结点到其他孩子的链接
 * 
 *					 A 										A
 *		 /	 /   /   |	 \	 \							   /
 *		B   C   D    E    F   G						      B —— C —— D —— E —— F —— G
 *			   /    / \ / | \  \			=====>     		 	   /    /    /		\
 *			  H    I  J K L  M  N							      H	   I——J K——L——M  N
 *					 / \												 /	
 *					P   Q												P——Q
 *
 * 注意：由于二叉树能够表示任意的通用树，所以实际中仅使用二叉树
 */

/**
 * 表达式树
 * 用来表示表达式的树叫作表达式树。
 * 在表达式树中，叶子节点是操作数，而非叶子节点是操作符。也就是说，表达式树是一棵内部节点为操作符，叶子节点为操作数的二叉树。
 * 下图为表达式：(A+B*C)/D 所对应的简单表达式树
 * 
 * 					/
 * 				   / \
 * 				  +   D
 * 				 / \
 * 				A   *
 * 				   / \
 * 				  B   C
 */

/**
 * 二叉搜索树(BinarySearchTree)
 * 在二叉搜索树中，所有的左子树节点的元素小于根节点的元素数据，所有的右子树节点的元素大于根节点的元素数据。
 * 1.一个节点的左子树只能包含值小于该节点数据的节点
 * 2.一个节点的右子树只能包含值大于该节点数据的节点
 * 3.左右子树必须也为二叉搜索树
 * 
 * 							根
 * 						   / \
 * 				          小于根的数据       大于根的数据
 * 
 * 二叉搜索树的声明与一般二叉树声明一致，只是存储的数据不同。
 */















