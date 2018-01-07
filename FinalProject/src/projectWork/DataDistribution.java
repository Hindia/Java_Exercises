package projectWork;
// distribution class to use the object of this class to calculate the max, min, total and average as well as clearing purposes
public class DataDistribution {

	//variable declarations
	private int min, max;
	private int[] MonArr;

	//constructor
	public DataDistribution(int max, int min){
		this.max=max;
		this.min=min;
		this.MonArr=new int[(max-min)+1];
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

	public int[] getMonArr() {
		return MonArr;
	}

	public void setMonArr(int[] MonArr) {
		this.MonArr = MonArr;
	}

	//methods
	public void insert(int x,int m){
		if(m>=min && m<=max){
			MonArr[m-1]=MonArr[m-1]+x;
		}
	}
	//returns the value in the array
	public int val(int y){
		return MonArr[y]; 
	} 

	public double average(){
		int sum=0;
		for(int i=0;i<12;i++){
			sum=sum+MonArr[i];
		}
		return (double)sum/12;
	}

	public int total(){
		int sum=0;
		for(int i=0;i<12;i++){
			sum=sum+MonArr[i];
		}
		return sum;
	}

	public int Min(){
		int minim=300;	
		for(int i=0;i<12;i++){
			if(minim>MonArr[i])
				minim=MonArr[i];
		}
		return minim;
	}
	
	public int Max(){
		int maxim=0;
		for(int i=0;i<12;i++){
			if(maxim<MonArr[i])
				maxim=MonArr[i];
		}
		return maxim;
	}
	//resets the sack
	public void clear(){
		for(int i=0;i<12;i++){
			if(MonArr[i]!=0)
				MonArr[i]=MonArr[i]*0;
		}
	}
}



