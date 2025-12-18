package kr.co.sist.user.restarea;

import java.sql.SQLException;
import java.util.List;


public class RestareaDetailService {

    private static RestareaDetailService service;
    private RestareaDetailDAO dao;

    private RestareaDetailService() {
        dao = RestareaDetailDAO.getInstance();
    }

    public static RestareaDetailService getInstance() {
        if (service == null) {
            service = new RestareaDetailService();
        }
        return service;
    }

    public RestareaDetailDTO getRestareaDetail(int rest_area_code) throws SQLException {
        return dao.selectDetail(rest_area_code);
    }
    
    /** 전체 휴게소 목록을 노선별로 가져옵니다. */
    public List<RestareaDetailDTO> getAllRestareas() throws SQLException {
        return dao.selectAllRestareas();
    }

    public List<ExtraFacilitiesDTO> getLookPlace(int rest_area_code) throws SQLException {
        return dao.selectLookPlace(rest_area_code);
    }

    public List<ExtraFacilitiesDTO> getFoodPlace(int rest_area_code) throws SQLException {
        return dao.selectFoodPlace(rest_area_code);
    }

    public List<ExtraFacilitiesDTO> getConveniencePlace(int rest_area_code) throws SQLException {
        return dao.selectConveniencePlace(rest_area_code);
    }
}