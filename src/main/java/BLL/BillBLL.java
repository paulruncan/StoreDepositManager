package BLL;

import DAO.BillDAO;

/**
 * The Bussiness Logic level of the Bill Class
 */
public class BillBLL {
    private BillDAO billDAO;

    public BillBLL(){
        this.billDAO=new BillDAO();
    }

    public BillDAO getBillDAO() {
        return billDAO;
    }
}
