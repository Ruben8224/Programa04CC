/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.programa04cc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ruben
 */
public class DAOEmpleado implements IDAOGeneral<Empleado, Long> {

    ConexionDB cx = null;
    TransactionDB tdb = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    @Override
    public Empleado create(Empleado p) {

        cx = ConexionDB.getInstance();

        tdb = new TransactionDB<Empleado>(p) {
            @Override
            public boolean execute(Connection con) {
                try {
                    String sql = "insert into ejemplo (id, nombre, direccion, telefono)"
                            + "values (?,?,?,?)";

                    pst = con.prepareStatement(sql);
                    pst.setLong(1, p.getClave());
                    pst.setString(2, p.getNombre());
                    pst.setString(3, p.getDireccion());
                    pst.setString(4, p.getTelefono());
                    pst.execute();
                    return true;
                } catch (SQLException ex) {
                    Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                } finally {
                    try {
                        if (pst != null) {
                            pst.close();
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            }
        };

        cx.execute(tdb);
        return null;
    }

    @Override
    public boolean delete(Long id) {
        cx = ConexionDB.getInstance();

        tdb = new TransactionDB<Long>(id) {
            @Override
            public boolean execute(Connection con) {
                try {
                    String sql = "delete from ejemplo where id = ?";

                    pst = con.prepareStatement(sql);
                    pst.setLong(1, id);
                    int result = pst.executeUpdate();
                    Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, "Registros afectados: {0}", result);
                    return true;

                } catch (SQLException ex) {
                    Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                } finally {
                    try {
                        if (pst != null) {
                            pst.close();
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }

        };
        cx.execute(tdb);

        return true;
    }

    @Override
    public Empleado update(Long id, Empleado p) {
        cx = ConexionDB.getInstance();

        tdb = new TransactionDB<Empleado>(p) {
            @Override
            public boolean execute(Connection con) {
                try {

                    String sql = "update ejemplo set id = ?, nombre = ?, direccion = ?, telefono = ? where id = ?";

                    pst = con.prepareStatement(sql);
                    pst.setLong(1, p.getClave());
                    pst.setString(2, p.getNombre());
                    pst.setString(3, p.getDireccion());
                    pst.setString(4, p.getTelefono());
                    pst.setLong(5, id);
                    pst.executeUpdate();
                    return true;
                } catch (SQLException ex) {
                    Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                } finally {
                    try {
                        if (pst != null) {
                            pst.close();
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            }

        };

        cx.execute(tdb);

        return null;
    }

    @Override
    public List<Empleado> findAll() {
        cx = ConexionDB.getInstance();

        tdb = new TransactionDB<Empleado>() {
            @Override
            public boolean execute(Connection con) {
                try {
                    String sql = "select * from ejemplo ";

                    pst = con.prepareStatement(sql);
                    rs = pst.executeQuery();

                    while (rs.next()) {
                        Logger.getLogger(DAOEmpleado.class.getName()).log(Level.INFO, rs.getString(1));
                        Logger.getLogger(DAOEmpleado.class.getName()).log(Level.INFO, rs.getString(2));
                        Logger.getLogger(DAOEmpleado.class.getName()).log(Level.INFO, rs.getString(3));
                        Logger.getLogger(DAOEmpleado.class.getName()).log(Level.INFO, rs.getString(4));
                    }

                    return true;

                } catch (SQLException ex) {
                    Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                } finally {
                    try {
                        if (pst != null) {
                            pst.close();
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }

        };

        cx.execute(tdb);
        return null;
    }

    @Override
    public Empleado findByID(Long id) {
        cx = ConexionDB.getInstance();

        tdb = new TransactionDB<Long>(id) {
            @Override
            public boolean execute(Connection con) {
                try {
                    String sql = "select * from ejemplo where id =?";

                    pst = con.prepareStatement(sql);
                    pst.setLong(1, id);

                    rs = pst.executeQuery();

                    while (rs.next()) {
                        Logger.getLogger(DAOEmpleado.class.getName()).log(Level.INFO, rs.getString(1));
                        Logger.getLogger(DAOEmpleado.class.getName()).log(Level.INFO, rs.getString(2));
                        Logger.getLogger(DAOEmpleado.class.getName()).log(Level.INFO, rs.getString(3));
                        Logger.getLogger(DAOEmpleado.class.getName()).log(Level.INFO, rs.getString(4));
                    }

                    return true;

                } catch (SQLException ex) {
                    Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                } finally {
                    try {
                        if (pst != null) {
                            pst.close();
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            }

        };

        cx.execute(tdb);

        return null;
    }
}