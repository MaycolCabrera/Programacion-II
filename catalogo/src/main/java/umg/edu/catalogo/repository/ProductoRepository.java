package umg.edu.catalogo.repository;

import umg.edu.catalogo.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {}