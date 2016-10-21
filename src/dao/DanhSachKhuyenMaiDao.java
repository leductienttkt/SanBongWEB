package dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import bean.KhuyenMai;
import bean.NguoiDung;
import taolao.MyReader;

public class DanhSachKhuyenMaiDao {

	public static List<KhuyenMai> getKhuyenMaiList() throws JSONException {
		
		String url = "http://localhost:35353/api/khuyenmai";
		String method = "GET";
		List<KhuyenMai> khuyenMais = new ArrayList<KhuyenMai>();
		try {
			String json = MyReader.readFromUrl(url, method);
			JSONArray a = null;
			Gson gson = new Gson();
			JSONObject j = null;
			JSONObject jj = null;
			KhuyenMai khuyenMai = new KhuyenMai();
			NguoiDung nguoiDung = new NguoiDung();
						
            a = new JSONArray(json);
            for (int i = 0; i < a.length(); i++) {
                j = a.getJSONObject(i);
                jj = j.getJSONObject("NguoiDung");
                khuyenMai = gson.fromJson(j.toString(), KhuyenMai.class);
                nguoiDung = gson.fromJson(jj.toString(), NguoiDung.class);
                khuyenMai.setChuSan(nguoiDung);
                khuyenMais.add(khuyenMai);
                System.out.println(khuyenMai.getChuSan().getTen());
            }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return khuyenMais;
	}

}
