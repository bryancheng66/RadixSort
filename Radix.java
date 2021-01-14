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

		for(int i = 0; i < data.size(); i++){
			if(length(data.get(i)) > digits){
				digits = length(data.get(i));
			}

			buckets[nth(data.get(i), 0)].add(data.get(i));
		}

		data = new SortableLinkedList();
		merge(data, buckets);

		for(int i = 1; i < digits; i++){
			for(int j = 0; i < data.size(); i++){
				if(length(data.get(j)) > digits){
					digits = length(data.get(j));
				}

				buckets[nth(data.get(j), i)].add(data.get(j));
			}
			data = new SortableLinkedList();
			merge(data, buckets);
		}
	}

	public static void radixSort(SortableLinkedList data){
	}
}
