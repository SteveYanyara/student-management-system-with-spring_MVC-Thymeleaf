package steve.code.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import steve.code.entities.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {

	public List<Student> findByNom(String n);
	public Page<Student> findByNom(String n, Pageable pageable);
	
	@Query("select e from Student e where e.nom like :x")
	public Page<Student> chercherEtudiants(@Param("x")String mc, Pageable pageable);
	
	@Query("select e from Student e where e.dateNaissance >:x and e.dateNaissance <:y")
	public List<Student> chercherEtudiants(@Param("x")Date d1, @Param("y")Date d2);

	
}
