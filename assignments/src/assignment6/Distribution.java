package assignment6;
	
public class Distribution {
	
		
		//variable declarations
		private int min, max;
		private int[] arr;
		
		//constructor
		public Distribution(int max, int min){
			this.max=max;
			this.min=min;
			arr=new int[(max-min)+1];
		}	
		//setters and getters
		public int getMin() {
			return min;
		}

		public void setMin(int min) {
			this.min = min;
		}

		public int getMax() {
			return max;
		}

		public void setMax(int max) {
			this.max = max;
		}
			
		public int[] getArr() {
			return arr;
		}

		public void setArr(int[] arr) {
			this.arr = arr;
		}

		//methods
		public void insert(int x){
			if(x >= min && x <= max){
				arr[x-min]=arr[x-min]+1;
			}
		}
		
		public int freq(int y){
			return arr[y-min]; 
		} 
		
		public double average(){
			int num=0,sum=0;
			for(int i=min;i<max+1;i++){
				num=num+(arr[i-min]*i);
				sum=sum+arr[i-min];
			}
			if(sum==0)
				return 0;
			else{
				
				return (double)num/sum;
			
			}
		}
		
		public int total(){
			int sum=0;
			for(int i=min;i<max+1;i++){
				sum=sum+arr[i-min];
			}
			return sum;
		}
	}

