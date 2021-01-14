public class Radix{
	public static int nth(int n, int col){
		return (int)((n / (Math.pow(10, col))) % 10);
	}

	public static int length(int n){
		if (n == 0){
			return 1;
		} else {
			return (int)Math.log10(n) + 1;
		}
	}

	public static void merge(SortableLinkedList original, SortableLinkedList[] buckets){
		for(int i = 0; i < buckets.length; i++){
			original.extend(buckets[i]);
		}
	}

	public static void radixSortSimple(SortableLinkedList data){
		int digits = 0;
		SortableLinkedList[] buckets = new SortableLinkedList[10];

		for(int i = 0; i < buckets.length; i++){
			buckets[i] = new SortableLinkedList();
		}
		for(int i = 0; i <= digits; i++){
			while(data.size() > 0){
				int currentValue = data.remove(0);
				if(i == 0){
					int currentLength = length(currentValue);
					digits = currentLength > digits ? currentLength : digits;
				}
				buckets[nth(currentValue, i)].add(currentValue);
			}
			merge(data, buckets);
		}
	}

	public static void radixSort(SortableLinkedList data){
	}
}
