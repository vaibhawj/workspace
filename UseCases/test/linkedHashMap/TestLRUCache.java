package linkedHashMap;

import org.junit.Assert;
import org.junit.Test;

public class TestLRUCache {

	@Test
	public void testLRUCacheBhaviour() {
		LRUCache<String, String> cache = new LRUCache<String, String>(2);
		cache.put("key1", "value1");
		cache.put("key2", "value2");

		cache.get("key1");
		cache.put("key3", "value3");

		Assert.assertEquals("Size of cache", 2, cache.size());
		Assert.assertTrue(cache.containsKey("key3"));
		Assert.assertTrue(cache.containsKey("key1"));
		Assert.assertFalse(cache.containsKey("key2"));

	}

}
