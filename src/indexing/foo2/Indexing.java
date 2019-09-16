package indexing.foo2;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Indexing{
	String path;
	Data[][] data;
	int[][] numbers;

	public Indexing(String pathThatAlreadyHasTheFiles){
		path=pathThatAlreadyHasTheFiles+"file_";
	}

	//there must be no empty lines
	private int getAmountOfLinesOnFile(int fileNumber) throws IOException{
		FileReader fr=new FileReader(path+fileNumber);
		BufferedReader br=new BufferedReader(fr);
		int amountOfLines=0;

		for(;br.ready();amountOfLines++)
			br.readLine();

		br.close();
		fr.close();

		return amountOfLines;
	}

	//all files must have the same amount of lines
	//files must be named: file_1, file_2, ...
	//data inside each file must be, on each line: "somethingStored", "somethingElseStored", ...
	public void loadData(int amountOfFiles) throws IOException{
		int amountOfLines=getAmountOfLinesOnFile(1);
		data=new Data[amountOfFiles][amountOfLines];
		numbers=new int[amountOfFiles][2];

		for(int eachFile=0;eachFile<amountOfFiles;eachFile++){
			FileReader fr=new FileReader(path+(eachFile+1));
			BufferedReader br=new BufferedReader(fr);

			for(int i=0;i<amountOfLines;i++)
				data[eachFile][i]=new Data((i+1)+(eachFile*amountOfLines), br.readLine());

			br.close();
			fr.close();

			numbers[eachFile][0]=amountOfLines*(eachFile+1);
			numbers[eachFile][1]=eachFile;
		}
	}
	public void printData(){ //not needed, just to print
		for(int i=0;i<data.length;i++){
			for(int j=0;j<data[0].length;j++)
				System.out.print("   "+data[i][j].getNumber()+"-"+data[i][j].getString());

			System.out.println();
		}
	}
	public String getStoredInformation(int search){
		int sector=-1;
		String information=null;

		for(int i=0;i<numbers.length && sector==-1;i++)
			if(numbers[i][0]>=search) sector=numbers[i][1];

		if(sector>-1){
			Data[] aux=data[sector];
			Data temp=null;

			for(int i=0;i<aux.length;i++)
				if(aux[i].getNumber()==search) temp=aux[i];

			if(temp!=null) information=temp.getString();
			else System.out.println("ERROR! Information not found.");
		}
		else System.out.println("ERROR! Invalid sector.");

		return information;
	}
}
