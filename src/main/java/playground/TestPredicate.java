package playground;

import java.util.ArrayList;
import java.util.Optional;

public class TestPredicate {

	public static void main(String[] args) {
		// int n = 10;
		// int[] nums = new int[n];
		// for (int i = 0; i < n; i++) {
		// nums[i] = i;
		// }
		// List<Integer> list = Arrays.asList(ArrayUtils.toObject(nums));
		// System.out.println(list);
		// list.stream().filter(x -> x > 5).forEach(x -> System.out.println(x));
		//
		// // System.out.println(list);
		// list.add(100);
		// System.out.println(list);
//		List<Integer> nums = Arrays.asList(1, 1, null, 2, 3, 4, null, 5, 6, 7, 8, 9, 10);
//
//		System.out.println("sum is:" + nums.stream().filter(num -> num != null).distinct()
//				.mapToInt(num -> num * 2).peek(System.out::println).skip(2).limit(4).sum());
//
//		List<Integer> numsWithoutNull = nums.stream().filter(num -> num != null).collect(
//				() -> new ArrayList<Integer>(), (list, item) -> list.add(item),
//				(list1, list2) -> list1.addAll(list2));
//		
//		List<Integer> numsWithoutNull1 = nums.stream().filter(num -> num != null)
//				.collect(Collectors.toList());
//
//		System.out.println(numsWithoutNull);
		
		Optional< String > fullName = Optional.ofNullable(null );
		
		System.out.println( "Full Name is set? " + fullName.isPresent() );       
		
		System.out.println( "Full Name: " + fullName.orElseGet( () -> "[none]" ) );
		
		System.out.println( fullName.map( s -> "Hey " + s + "!" ).orElse( "Hey Stranger!" ) );

		Runtime runtime=Runtime.getRuntime();
		System.out.println(runtime.maxMemory());
		System.out.println(runtime.freeMemory());
		System.out.println(runtime.totalMemory());
		System.out.println(runtime.availableProcessors());
		
		ArrayList<String> al=new ArrayList<>();
		al.add("q");
		al.add("w");
		al.add("e");
		al.add("r");
		
		System.out.println(al);
		al.remove(3);
		System.out.println(al);
		

	}

}
