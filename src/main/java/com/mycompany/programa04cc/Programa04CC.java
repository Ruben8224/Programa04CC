/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.programa04cc;

/**
 *
 * @author ruben
 */
public class Programa04CC {

    public static void main(String[] args) {
        DAOEmpleado dao = new DAOEmpleado();
        
        Empleado emp = new Empleado();
        
        emp.setClave(1);
        emp.setNombre("ruben");
        emp.setDireccion("Av 1423");
        emp.setTelefono("24022023");
        //dao.create(emp);
        //dao.findByID(1L);
        //dao.findAll();
        //dao.update(1L, emp);
        //dao.delete(1L);    
    }
}