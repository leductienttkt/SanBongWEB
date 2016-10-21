package dao;
import java.io.IOException;
import com.google.gson.Gson;

import bean.NguoiDung;
import taolao.MyReader;

public class DoLoginDAO {

	public static NguoiDung getLogin(String userName, String password) throws NumberFormatException, IOException {
		String url = "http://localhost:35353/api/nguoidung?tenDangNhap="+userName+"&matKhau="+password;
		String method = "GET";
		Gson gson = new Gson();
		NguoiDung nguoidung = new NguoiDung();
		String json = (MyReader.readFromUrl(url, method));
		System.out.println(json);
		System.out.println(url);    
        nguoidung = gson.fromJson(json, NguoiDung.class);
        System.out.println(nguoidung.getTen());
        return nguoidung;    
	}
}
