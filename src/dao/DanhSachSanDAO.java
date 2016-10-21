package dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import bean.NguoiDung;
import bean.San;
import taolao.MyReader;

public class DanhSachSanDAO {

	public static List<San> getDanhSachSan(String diaChi, String loai, String gioBatDau, String gioKetThuc,
			String ngay) throws JSONException {
		String url = "http://localhost:35353/api/san";
		url += "?diaChi="+diaChi+"&loai="+loai+"&gioBatDau="+gioBatDau+"&gioKetThuc="+gioKetThuc+"&ngay="+ngay;
		String method = "GET";
		System.out.println(url);
		List<San> sans = new ArrayList<San>();
		try {
			String json = MyReader.readFromUrl(url, method);
			JSONArray a = null;
			Gson gson = new Gson();
			JSONObject j = null;
			JSONObject jj = null;
			San san = new San();
			NguoiDung nguoiDung = new NguoiDung();
						
            a = new JSONArray(json);
            for (int i = 0; i < a.length(); i++) {
                j = a.getJSONObject(i);
                jj = j.getJSONObject("NguoiDung");
                san = gson.fromJson(j.toString(), San.class);
                nguoiDung = gson.fromJson(jj.toString(), NguoiDung.class);
                san.setChuSan(nguoiDung);
                sans.add(san);
                System.out.println(san.getTen());
            }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sans;
	}

}
