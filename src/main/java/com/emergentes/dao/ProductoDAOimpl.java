
package com.emergentes.dao;

import com.emergentes.modelo.Producto;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAOimpl extends ConexionDB implements ProductoDAO{

    @Override
    public void insert(Producto producto) throws Exception {
        try {
            this.conectar();
            String sql = "insert into productos(nombre, descripcion, precio) values(?, ?, ?)";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setFloat(3, producto.getPrecio());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Error insert(): " + e.getMessage());
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Producto producto) throws Exception {
        try {
            this.conectar();
            String sql = "update productos set nombre=?, descripcion=?, precio=? where id=?";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setFloat(3, producto.getPrecio());

            ps.setInt(4, producto.getId());

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
            String sql = "delete from productos where id=?";
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
    public Producto getById(int id) throws Exception {
        Producto prod = new Producto();
        try {
            this.conectar();
            String sql = "select * from productos where id=?";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                prod.setId(rs.getInt("id"));
                prod.setNombre(rs.getString("nombre"));
                prod.setDescripcion(rs.getString("descripcion"));
                prod.setPrecio(rs.getFloat("precio"));

            }

        } catch (SQLException e) {
            throw new Exception("Error al obtener  getById(id): " + e.getMessage());
        } finally {
            this.desconectar();
        }

        return prod;
    }

    @Override
    public List<Producto> getAll() throws Exception {
        List<Producto> lista = new ArrayList<>();
        try {
            this.conectar();
            String sql = "select * from productos";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Producto prod = new Producto();
                prod.setId(rs.getInt("id"));
                prod.setNombre(rs.getString("nombre"));
                prod.setDescripcion(rs.getString("descripcion"));
                prod.setPrecio(rs.getFloat("precio"));

                lista.add(prod);
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
