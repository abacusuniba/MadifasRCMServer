package d_utils;

import java.util.ArrayList;

import c_dto.c_enum.Stato;


public class StringBuilderQuery {
	
	private int[] indexes;
	private int[] swap;
	private String string;
	
	public StringBuilderQuery(String s){
		string = s;
	}
	
	public void setField(int index, String field){
//		String swap=string;
		
		//ricavo tutte le posizioni delle occorrenze desiderate
		swap = getAllPositions("?");
		
		if (indexes==null){
			indexes=swap;
		}
		else{
			int start = indexes.length-swap.length;
			
			for (int i = start; i < indexes.length;i++){
				indexes[i]=swap[i-start];
			}
			
		}
		
		String firstHalf=string.substring(0, indexes[index-1]);
		String secondHalf=string.substring(indexes[index-1]+1,string.length());
		
		
		string = firstHalf + field + secondHalf;
		
		
//		String[] arrayString = string.split("_");
//		string="";
//		for (int i=0; i< arrayString.length; i++){
//			string = string + arrayString[i];
//			if (i==(index-1))
//				string = string + field;
////			else{
////				string = string + arrayString[i];
////			}
//		}
		
	}
	
	public void append (String s){
		string+=s;
	}
	
	public void setTable(int index, String field){
		setField(index, field);
	}
	
	public void setValue(int index, String value){
		setField(index, "'" + value + "'");
	}
	public void setValue(int index, Stato value){
		setField(index, ""+value);
	}
	public void setValue(int index, int value){
		setField(index, ""+value);
	}
	public void setValue(int index, long value){
		setField(index, ""+value);
	}
	
	
	
//	@Deprecated
//	public void append(String value){
////		long index = getFirstPosition();
//		
//		insertText(value);
//	}
//	
//	@Deprecated
//	public void append(int value){
////		long index = getFirstPosition();
//		
//		insertText("" + value);
//	}
//	
//	@Deprecated
//	public void append(long value){
////		long index = getFirstPosition();
//		
//		insertText("" + value);
//	}
//	
//	private int getFirstPosition() {
//		return string.indexOf('?');
//	}
	
	private int[] getAllPositions(String ch){
		
		ArrayList<Integer> indexes = new ArrayList<>();
		
		int index = string.indexOf(ch);
		while (index>=0){
			indexes.add(index);
			index= string.indexOf(ch, index+1);
		}
		
		int[] indxs = new int[indexes.size()];
		for (int i=0; i< indxs.length;i++){
			indxs[i] = indexes.get(i).intValue();
		}
		
		
		return indxs;
	}
	
	
//	private void insertText(String text){
//		int index = getFirstPosition();
//		
//		String firstHalf=string.substring(0, index);
//		String secondHalf=string.substring(index+1,string.length());
//		
//		string = firstHalf + text + secondHalf;
//	}
	
	public void replaceAll(String oldChar, long newChar){
		replaceAll(oldChar, newChar + "");
	}
	public void replaceAll(String oldChar, String newChar){
		string = string.replace(oldChar, newChar);
	}

	
	@Override
	public String toString() {
		return string;
	}


}
