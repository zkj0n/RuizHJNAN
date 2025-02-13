package es.albarregas.DAOFactory;

import es.albarregas.DAO.GenericoDAO;
import es.albarregas.DAO.IGenericoDAO;

public class MySQLDAOFactory extends DAOFactory {

    @Override
    public IGenericoDAO getGenericoDAO() {
        return new GenericoDAO();
    }
}