package dbp.techcall.course.infrastructure;

import dbp.techcall.course.domain.Course;
import dbp.techcall.course.dto.TopFiveCourses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CourseRepository extends JpaRepository <Course,Long>{
    @Query(value =
            "select c.id, c.title, tp.firstName, tp.s as rating\n" +
                    "from course as c\n" +
                    "join (select avg(rating) as s, p.id, p.first_name as firstName\n" +
                    "from review r\n" +
                    "join professor p\n" +
                    "    on r.professor_id = p.id\n" +
                    "group by p.id, p.first_name) as tp\n" +
                    "on tp.id = c.professor_id\n" +
                    "ORDER BY  rating DESC\n"+
                    "LIMIT 6;"
            , nativeQuery = true)
    List<TopFiveCourses> findTopCourses();
}
