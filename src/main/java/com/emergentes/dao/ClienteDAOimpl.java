
package com.emergentes.dao;

import com.emergentes.modelo.Cliente;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOimpl extends ConexionDB implements ClienteDAO{

    @Override
    public void insert(Cliente cliente) throws Exception {
        try {
            this.conectar();
            String sql = "insert into clientes(nombre, correo, celular) values(?, ?, ?)";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getCorreo());
            ps.setString(3, cliente.getCelular());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Error insert(): " + e.getMessage());
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Cliente cliente) throws Exception {
        try {
            this.conectar();
            String sql = "update clientes set nombre=?, correo=?, celular=? where id=?";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getCorreo());
            ps.setString(3, cliente.getCelular());

            ps.setInt(4, cliente.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Error al actualizar  update( ): " + e.getMessage());
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql = "delete from clientes where id=?";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Error al eliminar  delete(id): " + e.getMessage());
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Cliente getById(int id) throws Exception {
        Cliente cli = new Cliente();
        try {
            this.conectar();
            String sql = "select * from clientes where id=?";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                cli.setId(rs.getInt("id"));
                cli.setNombre(rs.getString("nombre"));
                cli.setCorreo(rs.getString("correo"));
                cli.setCelular(rs.getString("celular"));
                
            }
            
        } catch (SQLException e) {
            throw new Exception("Error al obtener  getById(id): " + e.getMessage());
        } finally {
            this.desconectar();
        }
        
        return cli;
    }

    @Override
    public List<Cliente> getAll() throws Exception {
        List<Cliente> lista = null;
        try {
            this.conectar();
            String sql = "select * from clientes";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<>();
            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setId(rs.getInt("id"));
                cli.setNombre(rs.getString("nombre"));
                cli.setCorreo(rs.getString("correo"));
                cli.setCelular(rs.getString("celular"));

                lista.add(cli);
            }

            rs.close();
            ps.close();

        } catch (Exception e) {
            System.out.println("ERROR EN SQL getAll(): " + e.getMessage());
            e.printStackTrace();

        } finally {
            this.desconectar();
        }

        return lista;
    }
    
}
