package indexing.foo2;

public class Data{
	private String str;
	private int number;

	public Data(int number, String str){
		this.number=number;
		this.str=str;
	}
	public String getString(){
		return this.str;
	}
	public int getNumber(){
		return this.number;
	}
}
