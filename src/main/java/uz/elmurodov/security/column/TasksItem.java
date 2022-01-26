package uz.elmurodov.security.column;

import com.google.gson.annotations.SerializedName;

public class TasksItem{

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private long id;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(long id){
		this.id = id;
	}

	public long getId(){
		return id;
	}
}