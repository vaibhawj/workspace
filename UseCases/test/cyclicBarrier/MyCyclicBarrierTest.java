package cyclicBarrier;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class MyCyclicBarrierTest {

	private MyCyclicBarrier cb;

	@Before
	public void before() {
		cb = new MyCyclicBarrier(3);
	}

	@Test
	public void testAwait() {
		fail("Not yet implemented");
	}

	@Test
	public void testReset() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNumberWaiting() {
		fail("Not yet implemented");
	}

}
