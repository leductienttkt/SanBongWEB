package bo;

import java.util.List;

import org.json.JSONException;

import bean.San;
import dao.DanhSachSanDAO;

public class DanhSachSanBO {

	public static List<San> getDanhSachSan(String diaChi, String loai, String gioBatDau, String gioKetThuc,
			String ngay) throws JSONException {
		
		return DanhSachSanDAO.getDanhSachSan(diaChi, loai, gioBatDau, gioKetThuc, ngay);
	}

}
