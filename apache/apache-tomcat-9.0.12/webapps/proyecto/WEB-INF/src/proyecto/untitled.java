    //Carga serie para la vista
    public Serie cargarSerie(int id){ 
        Serie serie = new Serie(); //Objeto de la clase Pelicula
        String query_serie = "SELECT * FROM Series WHERE id =?";
        try(PreparedStatement st = connection.prepareStatement(query_serie)){
            st.setInt(1, id);            
            ResultSet rs = st.executeQuery();
            
            user.setId(id);
            user.setTitulo(rs.getString("titulo"));
            user.setAnyo(rs.getInt("anyo"));
            user.setTemporadas(rs.getInt("duracion"));
            user.setCapitulos(rs.getInt("pais"));
            user.setPais(rs.getInt("director"));
            user.setGenero(rs.getString("genero"));
            user.setTrailer(rs.getString("trailer"));
            user.setCreador(rs.getInt("creador"));
            user.setBloqueado(rs.getInt("bloqueado"));
        }
        return movie;
    }