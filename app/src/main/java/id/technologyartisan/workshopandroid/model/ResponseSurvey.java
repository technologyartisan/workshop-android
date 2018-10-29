package id.technologyartisan.workshopandroid.model;

import com.google.gson.annotations.SerializedName;

public class ResponseSurvey{

	@SerializedName("is_answer")
	private boolean isAnswer;

	@SerializedName("nama")
	private String nama;

	@SerializedName("tahun")
	private String tahun;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("tanggal_akhir")
	private String tanggalAkhir;

	@SerializedName("rating")
	private double rating;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("bulan")
	private String bulan;

	public void setIsAnswer(boolean isAnswer){
		this.isAnswer = isAnswer;
	}

	public boolean isIsAnswer(){
		return isAnswer;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setTahun(String tahun){
		this.tahun = tahun;
	}

	public String getTahun(){
		return tahun;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setTanggalAkhir(String tanggalAkhir){
		this.tanggalAkhir = tanggalAkhir;
	}

	public String getTanggalAkhir(){
		return tanggalAkhir;
	}

	public void setRating(double rating){
		this.rating = rating;
	}

	public double getRating(){
		return rating;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setBulan(String bulan){
		this.bulan = bulan;
	}

	public String getBulan(){
		return bulan;
	}

	@Override
 	public String toString(){
		return 
			"ResponseSurvey{" + 
			"is_answer = '" + isAnswer + '\'' + 
			",nama = '" + nama + '\'' + 
			",tahun = '" + tahun + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",tanggal_akhir = '" + tanggalAkhir + '\'' + 
			",rating = '" + rating + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",id = '" + id + '\'' + 
			",bulan = '" + bulan + '\'' + 
			"}";
		}
}