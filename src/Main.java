package indexing.foo2;

import java.io.IOException;

public class Main{
	//args[0]: pathThatAlreadyHasTheFiles/, args[1]: amountOfFiles, args[2]: informationToGet
	//example: java indexing.foo2.Main "/path/to/the/files/" 3 7
	//read more on the Indexing.java file
	public static void main(String[] args) throws IOException{
		Indexing i=new Indexing(args[0]);

		i.loadData(Integer.parseInt(args[1]));
		i.printData();
		System.out.println(i.getStoredInformation(Integer.parseInt(args[2])));
	}
}
//aluno guilherme alves
