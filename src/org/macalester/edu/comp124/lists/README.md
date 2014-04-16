HW6DestructiveList
==================
Node Killer 
Remember that linked list you made? It is a parent class. Specifically, it is the parent of org.macalester.edu.comp124.lists.DestructiveList, an awful little child that breaks all the things we give it. Stupid kids.

org.macalester.edu.comp124.lists.DestructiveList<T>

+ persistentlyRemoveGroupsOf(size : int) : int
+ removeEvery(number : int) : void
+ removeEvery(number : int, startingIndex : int) : void
+ removeGroupsOf(size : int) : int
+ rotate(groupSize : int) : void

+ removeEvery	
  removeEvery(3) will remove every 3rd element (i.e., nodes 2, 5, 8, etc.). If a starting index is passed in, start counting from that node. removeEvery(2,3) will remove every 2nd node starting from node 3  (i.e., nodes 4, 6, 8, etc.).
+ removeGroupsOf	
  If several nodes in a row have the same value (as measured by toString()), they form a group. removeGroupsOf(3) will remove any group that has at least 3 nodes. Once the group has been removed, start looking for the next group starting from the next node, continuing until you reach the end of the list. Returns the number of groups removed.
+ persistentlyRemoveGroupsOf	
  Remove all groups of the specified size. This might create new groups. For example, in
    AABBBA
  if you remove BBB, the remaining nodes for the group AAA, meaning the list still has groups in it. This method removes all groups. Once it has done that, it does it again in case any new groups formed. It repeats this until it gets all the way through the list without finding any groups.  Returns total number of groups removed.
+ rotate	
  Rotate a subset of nodes clockwise. Once it is rotated, move to the next subset. Do not rotate a subset if it is too small. Example:
    AbcDefGh
  rotate(3) will create:
    bcAefDGh

