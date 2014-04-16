package org.macalester.edu.comp124.lists;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author baylor
 */
public class DestructiveListTest
{

	@Test
	public void testRemoveEvery()
	{

		DestructiveList<String> instance;

		//--- Try it once with an even number of nodes
		instance = getSampleListSize16();
		instance.removeEvery(1);
    		assertEquals(0, instance.getSize());

		//--- Try it again with an odd number of nodes
		instance = getSampleListSize17();
		instance.removeEvery(1);
		assertEquals(0, instance.getSize());

		instance = getSampleListSize16();
		instance.removeEvery(2);
		assertEquals("A", instance.get(0));
		assertEquals("C", instance.get(1));
		assertEquals("E", instance.get(2));
		assertEquals("G", instance.get(3));
		assertEquals("I", instance.get(4));

		instance = getSampleListSize17();
		instance.removeEvery(2);
		assertEquals("A", instance.get(0));
		assertEquals("C", instance.get(1));
		assertEquals("E", instance.get(2));
		assertEquals("G", instance.get(3));
		assertEquals("I", instance.get(4));

		instance = getSampleListSize16();
		instance.removeEvery(3);
		assertEquals("A", instance.get(0));
		assertEquals("B", instance.get(1));
		assertEquals("D", instance.get(2));
		assertEquals("E", instance.get(3));
		assertEquals("G", instance.get(4));
		assertEquals("H", instance.get(5));
		assertEquals("J", instance.get(6));
		assertEquals("K", instance.get(7));
		assertEquals("M", instance.get(8));
		assertEquals("N", instance.get(9));
		assertEquals("P", instance.get(10));

		instance = getSampleListSize17();
		instance.removeEvery(3);
		assertEquals("A", instance.get(0));
		assertEquals("B", instance.get(1));
		assertEquals("D", instance.get(2));
		assertEquals("E", instance.get(3));
		assertEquals("G", instance.get(4));
		assertEquals("H", instance.get(5));
		assertEquals("J", instance.get(6));
		assertEquals("K", instance.get(7));
		assertEquals("M", instance.get(8));
		assertEquals("N", instance.get(9));
		assertEquals("P", instance.get(10));
	}

	@Test
	public void testRemoveEvery_int_int()
	{
		DestructiveList<String> instance;
        System.out.println("removeeverywithtwoparameters");

		//--- Try it once with an even number of nodes
		instance = getSampleListSize16();
		instance.removeEvery(1,4);
		assertEquals(4, instance.getSize());
		assertEquals("A", instance.get(0));
		assertEquals("B", instance.get(1));
		assertEquals("C", instance.get(2));
		assertEquals("D", instance.get(3));

		//--- Try it again with an odd number of nodes
		instance = getSampleListSize17();
		instance.removeEvery(1,6);
		assertEquals(6, instance.getSize());
		assertEquals("A", instance.get(0));
		assertEquals("B", instance.get(1));
		assertEquals("C", instance.get(2));
		assertEquals("D", instance.get(3));
		assertEquals("E", instance.get(4));
		assertEquals("F", instance.get(5));


		instance = getSampleListSize16();
		instance.removeEvery(2,3);
		assertEquals("A", instance.get(0));
		assertEquals("B", instance.get(1));
		assertEquals("C", instance.get(2));
		assertEquals("D", instance.get(3));
		assertEquals("F", instance.get(4));
		assertEquals("H", instance.get(5));
		assertEquals("J", instance.get(6));
		assertEquals("L", instance.get(7));
		assertEquals("N", instance.get(8));
		assertEquals("P", instance.get(9));

		instance = getSampleListSize17();
		instance.removeEvery(2,3);
		assertEquals("A", instance.get(0));
		assertEquals("B", instance.get(1));
		assertEquals("C", instance.get(2));
		assertEquals("D", instance.get(3));
		assertEquals("F", instance.get(4));
		assertEquals("H", instance.get(5));
		assertEquals("J", instance.get(6));
		assertEquals("L", instance.get(7));
		assertEquals("N", instance.get(8));
		assertEquals("P", instance.get(9));


		instance = getSampleListSize16();
		instance.removeEvery(3,7);
		assertEquals("A", instance.get(0));
		assertEquals("H", instance.get(7));
		assertEquals("I", instance.get(8));
		assertEquals("K", instance.get(9));
		assertEquals("L", instance.get(10));
		assertEquals("N", instance.get(11));
		assertEquals("O", instance.get(12));

		instance = getSampleListSize17();
		instance.removeEvery(3,7);
		assertEquals("A", instance.get(0));
		assertEquals("H", instance.get(7));
		assertEquals("I", instance.get(8));
		assertEquals("K", instance.get(9));
		assertEquals("L", instance.get(10));
		assertEquals("N", instance.get(11));
		assertEquals("O", instance.get(12));
		assertEquals("Q", instance.get(13));
	}

	@Test
	public void testRemoveGroupsOf()
	{
		DestructiveList<String> instance;
        System.out.println("removegroupsof");
		int numberOfGroupsRemoved;

		//--- Blocks of 3
		instance = getGroupList3s();
		numberOfGroupsRemoved = instance.removeGroupsOf(2);
		assertEquals(6, numberOfGroupsRemoved);
		assertEquals(0, instance.getSize());

		instance = getGroupList3s();
		numberOfGroupsRemoved = instance.removeGroupsOf(3);
		assertEquals(5, numberOfGroupsRemoved);
		assertEquals(2, instance.getSize());
		assertEquals("F", instance.get(0));
		assertEquals("F", instance.get(1));

		instance = getGroupList3s();
		numberOfGroupsRemoved = instance.removeGroupsOf(4);
		assertEquals(0, numberOfGroupsRemoved);
		assertEquals(17, instance.getSize());
		assertEquals("A", instance.get(0));
		assertEquals("A", instance.get(1));
		assertEquals("A", instance.get(2));
		assertEquals("B", instance.get(3));
		assertEquals("B", instance.get(4));
		assertEquals("B", instance.get(5));
		assertEquals("C", instance.get(6));
		assertEquals("C", instance.get(7));
		assertEquals("C", instance.get(8));
		assertEquals("F", instance.get(15));
		assertEquals("F", instance.get(16));


		//--- Groups nested in other groups
		instance = getNestedGroupsList();
		numberOfGroupsRemoved = instance.removeGroupsOf(2);
		assertEquals(3, numberOfGroupsRemoved);
		assertEquals(2, instance.getSize());
		assertEquals("B", instance.get(0));
		assertEquals("A", instance.get(1));

		instance = getNestedGroupsList();
		numberOfGroupsRemoved = instance.removeGroupsOf(3);
		assertEquals(1, numberOfGroupsRemoved);
		assertEquals(6, instance.getSize());
		assertEquals("A", instance.get(0));
		assertEquals("A", instance.get(1));
		assertEquals("B", instance.get(2));
		assertEquals("B", instance.get(3));
		assertEquals("B", instance.get(4));
		assertEquals("A", instance.get(5));

		instance = getNestedGroupsList();
		numberOfGroupsRemoved = instance.removeGroupsOf(4);
		assertEquals(1, numberOfGroupsRemoved);
		assertEquals(6, instance.getSize());
		assertEquals("A", instance.get(0));
		assertEquals("A", instance.get(1));
		assertEquals("B", instance.get(2));
		assertEquals("B", instance.get(3));
		assertEquals("B", instance.get(4));
		assertEquals("A", instance.get(5));
	}


	@Test
	public void testPersistentlyRemoveGroupsOf()
	{
		DestructiveList<String> instance;
		int numberOfGroupsRemoved;

		//--- Blocks of 3
        System.out.println("persistently");
		instance = getGroupList3s();
		numberOfGroupsRemoved = instance.persistentlyRemoveGroupsOf(2);
		assertEquals(6, numberOfGroupsRemoved);
		assertEquals(0, instance.getSize());

		instance = getGroupList3s();
		numberOfGroupsRemoved = instance.persistentlyRemoveGroupsOf(3);
		assertEquals(5, numberOfGroupsRemoved);
		assertEquals(2, instance.getSize());
		assertEquals("F", instance.get(0));
		assertEquals("F", instance.get(1));

		instance = getGroupList3s();
		numberOfGroupsRemoved = instance.persistentlyRemoveGroupsOf(4);
		assertEquals(0, numberOfGroupsRemoved);
		assertEquals(17, instance.getSize());
		assertEquals("A", instance.get(0));
		assertEquals("A", instance.get(1));
		assertEquals("A", instance.get(2));
		assertEquals("B", instance.get(3));
		assertEquals("B", instance.get(4));
		assertEquals("B", instance.get(5));
		assertEquals("C", instance.get(6));
		assertEquals("C", instance.get(7));
		assertEquals("C", instance.get(8));
		assertEquals("F", instance.get(15));
		assertEquals("F", instance.get(16));


		//--- Groups nested in other groups
		instance = getNestedGroupsList();
		numberOfGroupsRemoved = instance.persistentlyRemoveGroupsOf(2);
		assertEquals(3, numberOfGroupsRemoved);
		assertEquals(2, instance.getSize());
		assertEquals("B", instance.get(0));
		assertEquals("A", instance.get(1));

		instance = getNestedGroupsList();
		numberOfGroupsRemoved = instance.persistentlyRemoveGroupsOf(3);
		assertEquals(3, numberOfGroupsRemoved);
		assertEquals(0, instance.getSize());

		instance = getNestedGroupsList();
		numberOfGroupsRemoved = instance.persistentlyRemoveGroupsOf(4);
		assertEquals(1, numberOfGroupsRemoved);
		assertEquals(6, instance.getSize());
		assertEquals("A", instance.get(0));
		assertEquals("A", instance.get(1));
		assertEquals("B", instance.get(2));
		assertEquals("B", instance.get(3));
		assertEquals("B", instance.get(4));
		assertEquals("A", instance.get(5));
	}



	@Test
	public void testRotate()
	{
		DestructiveList<String> instance;
        System.out.println("rotate");

		//--- Try it once with an even number of nodes
		instance = getSampleListSize2();

		instance.rotate(2);
		assertEquals("B", instance.get(0));
		assertEquals("A", instance.get(1));

		instance = getSampleListSize16();
		instance.rotate(2);
		assertEquals("B", instance.get(0));
		assertEquals("A", instance.get(1));
		assertEquals("D", instance.get(2));
		assertEquals("C", instance.get(3));
		assertEquals("F", instance.get(4));
		assertEquals("E", instance.get(5));
		assertEquals("H", instance.get(6));
		assertEquals("G", instance.get(7));
		assertEquals("J", instance.get(8));
		assertEquals("I", instance.get(9));
		assertEquals("L", instance.get(10));
		assertEquals("K", instance.get(11));
		assertEquals("N", instance.get(12));
		assertEquals("M", instance.get(13));
		assertEquals("P", instance.get(14));
		assertEquals("O", instance.get(15));

		//--- Try it once with an odd number of nodes
		instance = getSampleListSize3();
		instance.rotate(2);
		assertEquals("B", instance.get(0));
		assertEquals("A", instance.get(1));
		assertEquals("C", instance.get(2));

		instance = getSampleListSize17();
		instance.rotate(2);
		assertEquals("B", instance.get(0));
		assertEquals("A", instance.get(1));
		assertEquals("D", instance.get(2));
		assertEquals("C", instance.get(3));
		assertEquals("F", instance.get(4));
		assertEquals("E", instance.get(5));
		assertEquals("H", instance.get(6));
		assertEquals("G", instance.get(7));
		assertEquals("J", instance.get(8));
		assertEquals("I", instance.get(9));
		assertEquals("L", instance.get(10));
		assertEquals("K", instance.get(11));
		assertEquals("N", instance.get(12));
		assertEquals("M", instance.get(13));
		assertEquals("P", instance.get(14));
		assertEquals("O", instance.get(15));
		assertEquals("Q", instance.get(16));


		//--- Rotate 3s
		instance = getSampleListSize16();
		instance.rotate(3);
		assertEquals("B", instance.get(0));
		assertEquals("C", instance.get(1));
		assertEquals("A", instance.get(2));
			assertEquals("E", instance.get(3));
			assertEquals("F", instance.get(4));
			assertEquals("D", instance.get(5));
		assertEquals("H", instance.get(6));
		assertEquals("I", instance.get(7));
		assertEquals("G", instance.get(8));
			assertEquals("K", instance.get(9));
			assertEquals("L", instance.get(10));
			assertEquals("J", instance.get(11));
		assertEquals("N", instance.get(12));
		assertEquals("O", instance.get(13));
		assertEquals("M", instance.get(14));
			assertEquals("P", instance.get(15));

		instance = getSampleListSize17();
		instance.rotate(3);
		assertEquals("B", instance.get(0));
		assertEquals("C", instance.get(1));
		assertEquals("A", instance.get(2));
			assertEquals("E", instance.get(3));
			assertEquals("F", instance.get(4));
			assertEquals("D", instance.get(5));
		assertEquals("H", instance.get(6));
		assertEquals("I", instance.get(7));
		assertEquals("G", instance.get(8));
			assertEquals("K", instance.get(9));
			assertEquals("L", instance.get(10));
			assertEquals("J", instance.get(11));
		assertEquals("N", instance.get(12));
		assertEquals("O", instance.get(13));
		assertEquals("M", instance.get(14));
			assertEquals("P", instance.get(15));
			assertEquals("Q", instance.get(16));

			
		//--- 5s
		instance = getSampleListSize16();
		instance.rotate(5);
		assertEquals("B", instance.get(0));
		assertEquals("C", instance.get(1));
		assertEquals("D", instance.get(2));
		assertEquals("E", instance.get(3));
		assertEquals("A", instance.get(4));
			assertEquals("G", instance.get(5));
			assertEquals("H", instance.get(6));
			assertEquals("I", instance.get(7));
			assertEquals("J", instance.get(8));
			assertEquals("F", instance.get(9));
		assertEquals("L", instance.get(10));
		assertEquals("M", instance.get(11));
		assertEquals("N", instance.get(12));
		assertEquals("O", instance.get(13));
		assertEquals("K", instance.get(14));
			assertEquals("P", instance.get(15));

		instance = getSampleListSize17();
		instance.rotate(5);
		assertEquals("B", instance.get(0));
		assertEquals("C", instance.get(1));
		assertEquals("D", instance.get(2));
		assertEquals("E", instance.get(3));
		assertEquals("A", instance.get(4));
			assertEquals("G", instance.get(5));
			assertEquals("H", instance.get(6));
			assertEquals("I", instance.get(7));
			assertEquals("J", instance.get(8));
			assertEquals("F", instance.get(9));
		assertEquals("L", instance.get(10));
		assertEquals("M", instance.get(11));
		assertEquals("N", instance.get(12));
		assertEquals("O", instance.get(13));
		assertEquals("K", instance.get(14));
			assertEquals("P", instance.get(15));
			assertEquals("Q", instance.get(16));
	}

	//<editor-fold defaultstate="collapsed" desc="sample data">
	private DestructiveList<String> getSampleListSize2()
	{
		DestructiveList<String> instance = new DestructiveList<>();
		instance.add("A");
		instance.add("B");
		return instance;
	}

	private DestructiveList<String> getSampleListSize3()
	{
		DestructiveList<String> instance = new DestructiveList<>();
		instance.add("A");
		instance.add("B");
		instance.add("C");
		return instance;
	}

	private DestructiveList<String> getSampleListSize16()
	{
		DestructiveList<String> instance = new DestructiveList<>();
		instance.add("A");
		instance.add("B");
		instance.add("C");
		instance.add("D");
		instance.add("E");
		instance.add("F");
		instance.add("G");
		instance.add("H");
		instance.add("I");
		instance.add("J");
		instance.add("K");
		instance.add("L");
		instance.add("M");
		instance.add("N");
		instance.add("O");
		instance.add("P");
		return instance;
	}

	private DestructiveList<String> getSampleListSize17()
	{
		DestructiveList<String> instance = new DestructiveList<>();
		instance.add("A");
		instance.add("B");
		instance.add("C");
		instance.add("D");
		instance.add("E");
		instance.add("F");
		instance.add("G");
		instance.add("H");
		instance.add("I");
		instance.add("J");
		instance.add("K");
		instance.add("L");
		instance.add("M");
		instance.add("N");
		instance.add("O");
		instance.add("P");
		instance.add("Q");
		return instance;
	}

	private DestructiveList<String> getGroupList3s()
	{
		DestructiveList<String> instance = new DestructiveList<>();

		instance.add("A");
		instance.add("A");
		instance.add("A");
			instance.add("B");
			instance.add("B");
			instance.add("B");
		instance.add("C");
		instance.add("C");
		instance.add("C");
			instance.add("D");
			instance.add("D");
			instance.add("D");
		instance.add("E");
		instance.add("E");
		instance.add("E");
			instance.add("F");
			instance.add("F");

		return instance;
	}

	private DestructiveList<String> getNestedGroupsList()
	{
		DestructiveList<String> instance = new DestructiveList<>();

		instance.add("A");
		instance.add("A");
			instance.add("B");
				instance.add("C");
				instance.add("C");
				instance.add("C");
				instance.add("C");
				instance.add("C");
			instance.add("B");
			instance.add("B");
		instance.add("A");

		return instance;
	}
	//</editor-fold>
}
