package bo;

import java.util.List;

import org.json.JSONException;

import bean.KhuyenMai;
import dao.DanhSachKhuyenMaiDao;

public class DanhSachKhuyenMaiBO {

	public static List<KhuyenMai> getKhuyenMaiList() throws JSONException {
		
		return DanhSachKhuyenMaiDao.getKhuyenMaiList();
	}
}
