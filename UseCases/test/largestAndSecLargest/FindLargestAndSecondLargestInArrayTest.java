package largestAndSecLargest;

import largestAndSecLargest.FindLargestAndSecondLargestInArray.Result;

import org.junit.Assert;
import org.junit.Test;

public class FindLargestAndSecondLargestInArrayTest {

	@Test
	public void testFindLargestAndSecondLargest() {
		int[] unsortedArr = { 4, 6, 1, 5, 3, 2 };
		FindLargestAndSecondLargestInArray f = new FindLargestAndSecondLargestInArray();
		Result res = f.findLargestAndSecondLargest(unsortedArr);

		Assert.assertEquals(6, res.getLargest());
		Assert.assertEquals(5, res.getSecondLargest());
	}

}
