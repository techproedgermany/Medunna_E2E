package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties (ignoreUnknown = true)

public class RoomPojo implements Serializable {

	private String description;
	private int price;
	private int roomNumber;
	private String roomType;
	private boolean status;

	//ADD constructor without parameter
	public RoomPojo() {
	}

	//ADD constructor with parameter
	public RoomPojo(int roomNumber, String roomType, boolean status, int price, String description) {
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.status = status;
		this.price = price;
		this.description = description;
	}


//	public void setCreatedBy(String createdBy){
//		this.createdBy = createdBy;
//	}
//
//	public String getCreatedBy(){
//		return createdBy;
//	}
//
//	public void setCreatedDate(String createdDate){
//		this.createdDate = createdDate;
//	}
//
//	public String getCreatedDate(){
//		return createdDate;
//	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

//	public void setId(int id){
//		this.id = id;
//	}
//
//	public int getId(){
//		return id;
//	}

	public void setPrice(int price){
		this.price = price;
	}

	public int getPrice(){
		return price;
	}

	public void setRoomNumber(int roomNumber){
		this.roomNumber = roomNumber;
	}

	public int getRoomNumber(){
		return roomNumber;
	}

	public void setRoomType(String roomType){
		this.roomType = roomType;
	}

	public String getRoomType(){
		return roomType;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"RootPojo{" + 
//			"createdBy = '" + createdBy + '\'' +
//			",createdDate = '" + createdDate + '\'' +
			",description = '" + description + '\'' + 
//			",id = '" + id + '\'' +
			",price = '" + price + '\'' + 
			",roomNumber = '" + roomNumber + '\'' + 
			",roomType = '" + roomType + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}