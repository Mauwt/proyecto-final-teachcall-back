package dbp.techcall.professorAvailability.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.util.Pair;

import java.time.LocalTime;
import java.util.Map;

@Getter
@Setter
@RequiredArgsConstructor
public class WeekAvailabilityRequest {

    private String professorEmail;
    private Integer weekNumber;
    private Map<Integer, TimeRange> timeRanges;
}
