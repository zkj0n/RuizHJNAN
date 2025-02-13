package es.albarregas.DAOFactory;

import es.albarregas.DAO.IGenericoDAO;

public abstract class DAOFactory {

    public abstract IGenericoDAO getGenericoDAO();

    public static DAOFactory getDAOFactory() {
        DAOFactory daof = new MySQLDAOFactory();

        return daof;
    }

}